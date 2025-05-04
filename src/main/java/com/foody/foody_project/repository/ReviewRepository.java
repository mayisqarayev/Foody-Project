package com.foody.foody_project.repository;

import com.foody.foody_project.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {

    @Query("""
        select count(r.receiverId) from Review r where r.receiverId = ?1
    """)
    BigDecimal calculateCount(String foodId);

}
