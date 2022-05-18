//package com.zara.catalog.controller;
//
//import com.zara.catalog.controller.model.api.CatalogProductRequest;
//import java.time.LocalDateTime;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import org.springframework.web.reactive.function.BodyInserters;
//
//@SpringBootTest
//@AutoConfigureWebTestClient
// class CatalogControllerTestFFF {
//
//  @Autowired
//  private WebTestClient webClient;
//
//  @Test
//   void getProductOk1() {
//    var request = CatalogProductRequest.builder()
//        .brandId("1")
//        .productId("35455")
//        .applicationDate(LocalDateTime.parse("2020-06-14T10:00:00"))
//        .build();
//    webClient.get()
//        .uri("/api/zara/v1/catalog/product")
//        .accept(MediaType.APPLICATION_JSON)
//        .contentType(MediaType.APPLICATION_JSON)
//        .body(BodyInserters.fromValue(request))
//        .exchange()
//        .expectStatus().isOk();
//  }
//
//  @Test
//   void getProductOk2() {
//    var request = CatalogProductRequest.builder()
//        .brandId("1")
//        .productId("35455")
//        .applicationDate(LocalDateTime.parse("2020-06-14T16:00:00"))
//        .build();
//    webClient.get()
//        .uri("/api/zara/v1/catalog/product")
//        .accept(MediaType.APPLICATION_JSON)
//        .contentType(MediaType.APPLICATION_JSON)
//        .body(BodyInserters.fromValue(request))
//        .exchange()
//        .expectStatus().isOk();
//  }
//
//  @Test
//   void getProductOk3() {
//    var request = CatalogProductRequest.builder()
//        .brandId("1")
//        .productId("35455")
//        .applicationDate(LocalDateTime.parse("2020-06-14T21:00:00"))
//        .build();
//    webClient.get()
//        .uri("/api/zara/v1/catalog/product")
//        .accept(MediaType.APPLICATION_JSON)
//        .contentType(MediaType.APPLICATION_JSON)
//        .body(BodyInserters.fromValue(request))
//        .exchange()
//        .expectStatus().isOk();
//  }
//
//  @Test
//   void getProductOk4() {
//    var request = CatalogProductRequest.builder()
//        .brandId("1")
//        .productId("35455")
//        .applicationDate(LocalDateTime.parse("2020-06-15T10:00:00"))
//        .build();
//    webClient.get()
//        .uri("/api/zara/v1/catalog/product")
//        .accept(MediaType.APPLICATION_JSON)
//
//        .body(BodyInserters.fromValue(request))
//        .exchange()
//        .expectStatus().isOk();
//  }
//
//  @Test
//   void getProductOk5() {
//    var request = CatalogProductRequest.builder()
//        .brandId("1")
//        .productId("35455")
//        .applicationDate(LocalDateTime.parse("2020-06-16T21:00:00"))
//        .build();
//    webClient.get()
//        .uri("/api/zara/v1/catalog/product")
//        .accept(MediaType.APPLICATION_JSON)
//        .contentType(MediaType.APPLICATION_JSON)
//        .body(BodyInserters.fromValue(request))
//        .exchange()
//        .expectStatus().isOk();
//  }
//}
