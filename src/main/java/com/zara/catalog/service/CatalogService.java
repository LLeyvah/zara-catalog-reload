package com.zara.catalog.service;

import com.zara.catalog.controller.model.api.Catalog;
import com.zara.catalog.controller.model.api.CatalogProductResponse;
import com.zara.catalog.controller.model.api.CatalogProductRequest;
import com.zara.catalog.repository.entity.CatalogEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CatalogService {

  Flux<Catalog> findAllCatalogs();

  Mono<CatalogProductResponse> retrieveProduct(CatalogProductRequest request);

  Mono<Void> saveCatalog(CatalogEntity catalogEntity);

  Mono<Void> updateCatalog(CatalogEntity catalogEntity);

  Mono<Void> deleteCatalog(CatalogEntity catalogEntity);
}
