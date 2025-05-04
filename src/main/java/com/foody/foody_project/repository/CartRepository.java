package com.foody.foody_project.repository;

import com.foody.foody_project.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {

    @Transactional
    @Modifying
    @Query("""
        update Cart c set c.isPaid = true where c.id = ?1
    """)
    void changeIsPaidById(String id);
}
