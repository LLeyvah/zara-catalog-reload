package com.zara.catalog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.zara.catalog.controller.model.api.CatalogProductRequest;
import com.zara.catalog.controller.model.api.CatalogProductResponse;
import com.zara.catalog.service.CatalogService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(CatalogController.class)
class CatalogControllerTest {

    @MockBean
    CatalogService service;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getProductOk1() throws Exception {

        CatalogProductRequest request = CatalogProductRequest.builder()
                .brandId("1")
                .productId("35455")
                .applicationDate(LocalDateTime.parse("2020-06-14T10:00:00"))
                .build();
        CatalogProductResponse response = CatalogProductResponse.builder()
                .brandId("1")
                .productId("35455")
                .priceList("1")
                .price(35.5)
                .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
                .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
                .build();
        when(service.retrieveProduct(request)).thenReturn(Mono.just(response));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/zara/v1/catalog/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper()
                                .registerModule(new JavaTimeModule())
                                .writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(6)))
                .andExpect(jsonPath("$.brandId", Matchers.is("1")))
                .andExpect(jsonPath("$.productId", Matchers.is("35455")))
                .andExpect(jsonPath("$.priceList", Matchers.is("1")))
                .andExpect(jsonPath("$.price", Matchers.is(35.5)))
                .andExpect(jsonPath("$.startDate", Matchers.is("2020-06-14T00:00:00")))
                .andExpect(jsonPath("$.endDate", Matchers.is("2020-12-31T23:59:59")));

    }

//    @Test
//    void getProductOk2() {
//        var request = CatalogProductRequest.builder()
//                .brandId("1")
//                .productId("35455")
//                .applicationDate(LocalDateTime.parse("2020-06-14T16:00:00"))
//                .build();
//        webClient.get()
//                .uri("/api/zara/v1/catalog/product")
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue(request))
//                .exchange()
//                .expectStatus().isOk();
//    }
//
//    @Test
//    void getProductOk3() {
//        var request = CatalogProductRequest.builder()
//                .brandId("1")
//                .productId("35455")
//                .applicationDate(LocalDateTime.parse("2020-06-14T21:00:00"))
//                .build();
//        webClient.get()
//                .uri("/api/zara/v1/catalog/product")
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue(request))
//                .exchange()
//                .expectStatus().isOk();
//    }
//
//    @Test
//    void getProductOk4() {
//        var request = CatalogProductRequest.builder()
//                .brandId("1")
//                .productId("35455")
//                .applicationDate(LocalDateTime.parse("2020-06-15T10:00:00"))
//                .build();
//        webClient.get()
//                .uri("/api/zara/v1/catalog/product")
//                .accept(MediaType.APPLICATION_JSON)
//
//                .body(BodyInserters.fromValue(request))
//                .exchange()
//                .expectStatus().isOk();
//    }
//
//    @Test
//    void getProductOk5() {
//        var request = CatalogProductRequest.builder()
//                .brandId("1")
//                .productId("35455")
//                .applicationDate(LocalDateTime.parse("2020-06-16T21:00:00"))
//                .build();
//        webClient.get()
//                .uri("/api/zara/v1/catalog/product")
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(BodyInserters.fromValue(request))
//                .exchange()
//                .expectStatus().isOk();
//    }
}

