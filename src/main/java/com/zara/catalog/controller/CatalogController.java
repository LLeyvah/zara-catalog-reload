package com.zara.catalog.controller;

import com.zara.catalog.controller.model.api.Catalog;
import com.zara.catalog.controller.model.api.CatalogProductResponse;
import com.zara.catalog.controller.model.api.CatalogProductRequest;
import com.zara.catalog.service.CatalogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/api/zara/v1")
@RequiredArgsConstructor
@Slf4j
public class CatalogController {

  private final CatalogService catalogService;

  @GetMapping("/catalog")
  public Flux<Catalog> getAllCatalog() {
    return catalogService.findAllCatalogs();
  }

  @GetMapping("/catalog/product")
  public Mono<CatalogProductResponse> getProduct(@RequestBody CatalogProductRequest request) {
    return catalogService.retrieveProduct(request);
  }
}
