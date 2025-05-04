package com.foody.foody_project.repository;


import com.foody.foody_project.model.RestaurantCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantCategoryRepository extends JpaRepository<RestaurantCategory, String> {

    @Query("""
        select r.fkRestaurantId from RestaurantCategory r where (r.fkCategoryId = ?1) and (r.relationStatus = true) 
    """)
    List<String> getRestaurantsByCategoryId(String categoryId);
}
