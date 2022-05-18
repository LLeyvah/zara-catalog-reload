package com.zara.catalog.scheduler;

import com.zara.catalog.component.ApplicationProperties;
import com.zara.catalog.scheduler.helper.CatalogConstant;
import com.zara.catalog.mapper.CatalogMapper;
import com.zara.catalog.controller.model.csv.CatalogCsv;
import com.zara.catalog.service.CatalogService;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class CatalogScheduler {

  private final ApplicationProperties properties;
  private final CatalogMapper catalogMapper;
  private final CatalogService catalogService;

  @Scheduled(fixedRateString = "${application.scheduler.period-milliseconds}")
  public void priceLoadingTask() {
    CsvToBean<CatalogCsv> csvBuilt = new CsvToBeanBuilder<CatalogCsv>(this.getReader())
        .withType(CatalogCsv.class)
        .withSkipLines(1)
        .withSeparator(',')
        .withIgnoreLeadingWhiteSpace(true)
        .build();
    var catalogList = csvBuilt.parse();
    Flux.fromIterable(catalogList)
        .filter(this::validateUpgrade)
        .flatMap(this::upgradeCatalog)
        .subscribe();
  }

  private Reader getReader() {
    BufferedReader reader = null;
    try {
      FileReader fileReader = new FileReader(properties.getCsvPath());
      reader = new BufferedReader(fileReader);
    } catch (FileNotFoundException ex) {
      log.error("Error al leer ruta: ", ex);
    }
    return reader;
  }

  private Mono<Void> upgradeCatalog(CatalogCsv csvBean) {
    var entity = catalogMapper.toCatalogEntity(csvBean);
    if (CatalogConstant.INSERT.equals(csvBean.getStatus())) {
      return catalogService.saveCatalog(entity);
    } else if (CatalogConstant.UPDATE.equals(csvBean.getStatus())) {
      return catalogService.updateCatalog(entity);
    } else if (CatalogConstant.DELETE.equals(csvBean.getStatus())) {
      return catalogService.deleteCatalog(entity);
    }
    return Mono.empty();
  }

  private boolean validateUpgrade(CatalogCsv csvBean) {
    return CatalogConstant.INSERT.equals(csvBean.getStatus())
        || CatalogConstant.UPDATE.equals(csvBean.getStatus())
        || CatalogConstant.DELETE.equals(csvBean.getStatus());
  }
}
