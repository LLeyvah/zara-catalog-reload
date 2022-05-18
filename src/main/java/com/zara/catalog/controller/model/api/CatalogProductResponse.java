package com.zara.catalog.controller.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CatalogProductResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String brandId;
    private String productId;
    private String priceList;
    private Double price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
