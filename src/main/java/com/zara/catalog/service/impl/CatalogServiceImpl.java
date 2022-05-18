package com.zara.catalog.service.impl;

import com.zara.catalog.mapper.CatalogMapper;
import com.zara.catalog.controller.model.api.Catalog;
import com.zara.catalog.controller.model.api.CatalogProductResponse;
import com.zara.catalog.controller.model.api.CatalogProductRequest;
import com.zara.catalog.repository.entity.CatalogEntity;
import com.zara.catalog.repository.CatalogRepository;
import com.zara.catalog.service.CatalogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class CatalogServiceImpl implements CatalogService {

  private final CatalogRepository catalogRepository;
  private final CatalogMapper catalogMapper;

  @Override
  public Flux<Catalog> findAllCatalogs() {
    return catalogRepository.findAll()
        .map(catalogMapper::toCatalog);
  }

  @Override
  public Mono<CatalogProductResponse> retrieveProduct(CatalogProductRequest request) {
    return catalogRepository.findByParams(
        request.getProductId(),
        request.getBrandId(),
        request.getApplicationDate())
        .last()
        .map(catalogMapper::toProduct)
        .onErrorResume(ex -> {
          log.error(ex.getMessage());
          throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Producto no encontrado");
        });
  }

  @Override
  public Mono<Void> saveCatalog(CatalogEntity entity) {
    log.info("New catalog: {}", entity.toString());
    return catalogRepository.save(entity)
        .flatMap(result-> Mono.empty());
  }

  @Override
  public Mono<Void> updateCatalog(CatalogEntity entity) {
    log.info("Update catalog: {}", entity.toString());
    return catalogRepository.getEntity(entity.getBrandId(),
        entity.getPriceList(),
        entity.getProductId())
        .flatMap(result -> {
          entity.setCatalogId(result.getCatalogId());
          return catalogRepository.save(entity);
        })
        .flatMap(result-> Mono.empty());
  }

  @Override
  public Mono<Void> deleteCatalog(CatalogEntity entity) {
    log.info("Delete catalog: {}", entity.toString());
    return catalogRepository.getEntity(entity.getBrandId(),
        entity.getPriceList(),
        entity.getProductId())
        .flatMap(catalogRepository::delete);
  }

}
