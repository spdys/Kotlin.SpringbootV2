package com.coded.spring.ordering.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val userId: Long,
    val createdAt: LocalDateTime,
    val restaurant: String,

    @ManyToOne
    @JoinColumn(name = "items_id")
    val items: ItemEntity,
) {
    constructor(): this(
        0,
        0,
        LocalDateTime.now(),
        "",
        ItemEntity()
    )
}