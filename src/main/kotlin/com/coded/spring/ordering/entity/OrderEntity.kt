package com.coded.spring.ordering.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "orders")
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val userId: Long,
    val restaurant: String,
    val items: String,
) {
    constructor(): this(
        0,
        0,
        "",
        ""
    )
}