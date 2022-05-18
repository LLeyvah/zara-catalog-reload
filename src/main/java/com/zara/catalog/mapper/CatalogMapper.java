package com.zara.catalog.mapper;

import com.zara.catalog.controller.model.api.Catalog;
import com.zara.catalog.controller.model.api.CatalogProductResponse;
import com.zara.catalog.controller.model.csv.CatalogCsv;
import com.zara.catalog.repository.entity.CatalogEntity;
import java.time.LocalDateTime;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CatalogMapper {

  @Mapping(source = "brandId", target = "brandId")
  @Mapping(source = "productId", target = "productId")
  @Mapping(source = "priceList", target = "priceList")
  @Mapping(source = "price", target = "price")
  @Mapping(source = "startDate", target = "startDate")
  @Mapping(source = "endDate", target = "endDate")
  CatalogProductResponse toProduct(CatalogEntity catalogEntity);

  Catalog toCatalog(CatalogEntity catalogEntity);

  @Mapping(source = "brandId", target = "brandId")
  @Mapping(source = "startDate", target = "startDate", qualifiedByName = "toDateTime")
  @Mapping(source = "endDate", target = "endDate", qualifiedByName = "toDateTime")
  @Mapping(source = "priceList", target = "priceList")
  @Mapping(source = "productId", target = "productId")
  @Mapping(source = "priority", target = "priority")
  @Mapping(source = "price", target = "price")
  @Mapping(source = "currency", target = "currency")
  @Mapping(source = "lastUpdate", target = "lastUpdate", qualifiedByName = "toDateTime")
  @Mapping(source = "lastUpdateBy", target = "lastUpdateBy")
  CatalogEntity toCatalogEntity(CatalogCsv catalogCsv);

  @Named("toDateTime")
  default LocalDateTime toDateTime(String dateTime) {
    return StringUtils.isNotBlank(dateTime) ? LocalDateTime.parse(dateTime) : null;
  }

}
