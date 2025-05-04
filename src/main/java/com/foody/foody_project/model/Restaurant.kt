package com.foody.foody_project.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Restaurant(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    var restaurantName: String?,
    var fkAddressId: String?,
    @Lob
    var photo: String?,
    @Lob
    var banner: String?,
    var restaurantStatus: Boolean?,
    var restaurantRating: BigDecimal? = BigDecimal.ZERO,
    @ManyToMany
    @JoinTable(
        name = "restaurant_category",
        joinColumns = [JoinColumn(name = "restaurant_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    var categories: MutableList<Category> = mutableListOf(),

    @ManyToMany
    @JoinTable(
        name = "restaurant_food",
        joinColumns = [JoinColumn(name = "restaurant_id")],
        inverseJoinColumns = [JoinColumn(name = "food_id")]
    )
    var foods: MutableList<Food> = mutableListOf()
) {
    constructor(): this(
        null, null,null, null, null, null, null,
        mutableListOf(), mutableListOf()
    )
}