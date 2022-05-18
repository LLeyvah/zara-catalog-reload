package com.zara.catalog.mapper;

import com.zara.catalog.controller.model.api.Catalog;
import com.zara.catalog.controller.model.api.CatalogProductResponse;
import com.zara.catalog.controller.model.api.CatalogProductResponse.CatalogProductResponseBuilder;
import com.zara.catalog.controller.model.csv.CatalogCsv;
import com.zara.catalog.repository.entity.CatalogEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-18T00:05:14-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
)
@Component
public class CatalogMapperImpl implements CatalogMapper {

    @Override
    public CatalogProductResponse toProduct(CatalogEntity catalogEntity) {
        if ( catalogEntity == null ) {
            return null;
        }

        CatalogProductResponseBuilder catalogProductResponse = CatalogProductResponse.builder();

        catalogProductResponse.brandId( catalogEntity.getBrandId() );
        catalogProductResponse.productId( catalogEntity.getProductId() );
        catalogProductResponse.priceList( catalogEntity.getPriceList() );
        catalogProductResponse.price( catalogEntity.getPrice() );
        catalogProductResponse.startDate( catalogEntity.getStartDate() );
        catalogProductResponse.endDate( catalogEntity.getEndDate() );

        return catalogProductResponse.build();
    }

    @Override
    public Catalog toCatalog(CatalogEntity catalogEntity) {
        if ( catalogEntity == null ) {
            return null;
        }

        Catalog catalog = new Catalog();

        catalog.setCatalogId( catalogEntity.getCatalogId() );
        catalog.setBrandId( catalogEntity.getBrandId() );
        catalog.setStartDate( catalogEntity.getStartDate() );
        catalog.setEndDate( catalogEntity.getEndDate() );
        catalog.setPriceList( catalogEntity.getPriceList() );
        catalog.setProductId( catalogEntity.getProductId() );
        catalog.setPriority( catalogEntity.getPriority() );
        catalog.setPrice( catalogEntity.getPrice() );
        catalog.setCurrency( catalogEntity.getCurrency() );
        catalog.setLastUpdate( catalogEntity.getLastUpdate() );
        catalog.setLastUpdateBy( catalogEntity.getLastUpdateBy() );

        return catalog;
    }

    @Override
    public CatalogEntity toCatalogEntity(CatalogCsv catalogCsv) {
        if ( catalogCsv == null ) {
            return null;
        }

        CatalogEntity catalogEntity = new CatalogEntity();

        catalogEntity.setBrandId( catalogCsv.getBrandId() );
        catalogEntity.setStartDate( toDateTime( catalogCsv.getStartDate() ) );
        catalogEntity.setEndDate( toDateTime( catalogCsv.getEndDate() ) );
        catalogEntity.setPriceList( catalogCsv.getPriceList() );
        catalogEntity.setProductId( catalogCsv.getProductId() );
        catalogEntity.setPriority( catalogCsv.getPriority() );
        catalogEntity.setPrice( catalogCsv.getPrice() );
        catalogEntity.setCurrency( catalogCsv.getCurrency() );
        catalogEntity.setLastUpdate( toDateTime( catalogCsv.getLastUpdate() ) );
        catalogEntity.setLastUpdateBy( catalogCsv.getLastUpdateBy() );

        return catalogEntity;
    }
}
