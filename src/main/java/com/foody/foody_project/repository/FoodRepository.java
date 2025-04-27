package com.foody.foody_project.repository;

import com.foody.foody_project.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, String> {

    @Query("""
        select a from Food a where a.foodPrice between ?1 and ?2 order by a.foodPrice desc
    """)
    List<Food> findAllFoodsBetweenPriceDesc(BigDecimal minPrice, BigDecimal maxPrice);

    @Query("""
        select a from Food a where a.foodPrice between ?1 and ?2 order by a.foodPrice asc
    """)
    List<Food> findAllFoodsBetweenPriceAsc(BigDecimal minPrice, BigDecimal maxPrice);

    @Query("""
        select a from Food a where a.foodPrice between ?1 and ?2 order by a.foodRating desc
    """)
    List<Food> findAllFoodsBetweenPriceByRatingDesc(BigDecimal minPrice,BigDecimal maxPrice);

    @Query("""
        select a from Food a where a.foodPrice between ?1 and ?2 order by a.foodRating asc
    """)
    List<Food> findAllFoodsBetweenPriceByRatingAsc(BigDecimal minPrice,BigDecimal maxPrice);

    @Query("""
        select a from Food a where a.foodName = ?1
    """)
    List<Food> findAllFoodsByName(String name);

    @Query("""
        select a from Food a where a.foodDescription = ?1
    """)
    List<Food> findAllFoodsByDescription(String description);
}