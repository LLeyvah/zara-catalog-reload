package com.zara.catalog.repository.entity;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("CATALOG")
public class CatalogEntity {

  @Id
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
