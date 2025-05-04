package com.foody.foody_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantFood extends JpaRepository<com.foody.foody_project.model.RestaurantFood, String> {
}
