package com.zara.catalog.controller.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogProductRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String brandId;
    private String productId;
    private LocalDateTime applicationDate;

}
