package com.foody.foody_project.repository;

import com.foody.foody_project.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, String> {

    @Transactional
    @Modifying
    @Query("""
        update CartItem c set c.quantityOfFoods = c.quantityOfFoods + 1 where c.id = ?1
    """)
    void increaseFoodQuantity(String id);

    @Transactional
    @Modifying
    @Query("""
        update CartItem c set c.quantityOfFoods = c.quantityOfFoods - 1 where c.id = ?1
    """)
    void decreaseFoodQuantity(String id);

    @Transactional
    @Modifying
    @Query("""
        update CartItem c set c.price = c.price + ?2 where c.id = ?1
    """)
    void increaseCartItemPrice(String id, BigDecimal foodPrice);

    @Transactional
    @Modifying
    @Query("""
        update CartItem c set c.quantityOfFoods = c.quantityOfFoods - ?2 where c.id = ?1
    """)
    void decreaseCartItemPrice(String id, BigDecimal foodPrice);

    @Transactional
    @Query("""
        select sum(c.price) from CartItem c where c.fkCartId = ?1 and c.foodIsChecked = true 
    """)
    BigDecimal calculateTotalPrice(String cartId);

    @Transactional
    @Modifying
    @Query("""
        update CartItem c set c.foodIsChecked = false where c.fkCartId = ?1
    """)
    void clearCartItemsByCartId(String cartId);

    @Transactional
    @Modifying
    @Query("""
        update CartItem c set c.foodIsChecked = false where c.id = ?1
    """)
    void removeCartItemById(String id);
}
