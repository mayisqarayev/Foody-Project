package com.foody.foody_project.repository;

import com.foody.foody_project.model.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, String> {

    @Transactional
    @Modifying
    @Query("""
        update Favorites f set f.status = false where f.receiverId = ?1
    """)
    void removeItemFromFavorites(String itemId);
}
