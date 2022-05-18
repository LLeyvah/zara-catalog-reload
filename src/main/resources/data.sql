DROP TABLE IF EXISTS CATALOG;

CREATE TABLE CATALOG (
    catalog_id      INT AUTO_INCREMENT,
    brand_id        CHAR(1) NULL,
    start_date      TIMESTAMP,
    end_date        TIMESTAMP,
    price_list      VARCHAR(4) NULL,
    product_id      VARCHAR(10) NULL,
    priority        INT,
    price           DECIMAL(10,2) NULL,
    currency        VARCHAR(4) NULL,
    last_update     TIMESTAMP,
    last_update_by  VARCHAR(20) NULL,
    PRIMARY KEY (catalog_id)
)
AS SELECT
    NULL,
    BrandId,
    StartDate,
    EndDate,
    PriceList,
    ProductId,
    Priority,
    Price,
    Currency,
    LastUpdate,
    LastUpdateBy
FROM CSVREAD('classpath:prices.csv');