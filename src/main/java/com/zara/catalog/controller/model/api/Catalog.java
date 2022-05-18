package com.zara.catalog.controller.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catalog implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer catalogId;
    private String brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String priceList;
    private String productId;
    private Integer priority;
    private Double price;
    private String currency;
    private LocalDateTime lastUpdate;
    private String lastUpdateBy;

}
