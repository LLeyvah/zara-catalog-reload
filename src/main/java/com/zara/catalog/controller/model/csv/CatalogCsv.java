package com.zara.catalog.controller.model.csv;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class CatalogCsv {

  @CsvBindByPosition(position = 0)
  private String brandId;
  @CsvBindByPosition(position = 1)
  private String startDate;
  @CsvBindByPosition(position = 2)
  private String endDate;
  @CsvBindByPosition(position = 3)
  private String priceList;
  @CsvBindByPosition(position = 4)
  private String productId;
  @CsvBindByPosition(position = 5)
  private Integer priority;
  @CsvBindByPosition(position = 6)
  private Double price;
  @CsvBindByPosition(position = 7)
  private String currency;
  @CsvBindByPosition(position = 8)
  private String lastUpdate;
  @CsvBindByPosition(position = 9)
  private String lastUpdateBy;
  @CsvBindByPosition(position = 10)
  private String status;

}
