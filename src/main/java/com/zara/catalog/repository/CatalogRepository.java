package com.zara.catalog.repository;

import com.zara.catalog.repository.entity.CatalogEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Repository
public interface CatalogRepository extends ReactiveCrudRepository<CatalogEntity, Integer> {

    @Query(value = " SELECT * FROM catalog WHERE product_id = :productId " +
            "AND brand_id = :brandId AND (start_date <= :applicationDate AND end_date >= :applicationDate) " +
            "ORDER BY priority ASC")
    Flux<CatalogEntity> findByParams(@Param("productId") String productId,
                                     @Param("brandId") String brandId,
                                     @Param("applicationDate") LocalDateTime applicationDate);

    @Query(value = " DELETE FROM catalog WHERE brand_id = :brandId " +
            "AND price_list = :priceList AND product_id = :productId")
    Mono<Void> deleteCatalog(@Param("brandId") String brandId,
                             @Param("priceList") String priceList,
                             @Param("productId") String productId);

    @Query(value = " SELECT * FROM catalog WHERE brand_id = :brandId " +
            "AND price_list = :priceList AND product_id = :productId")
    Mono<CatalogEntity> getEntity(@Param("brandId") String brandId,
                                  @Param("priceList") String priceList,
                                  @Param("productId") String productId);
}
