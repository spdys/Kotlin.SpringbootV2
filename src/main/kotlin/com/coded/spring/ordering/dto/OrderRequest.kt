package com.coded.spring.ordering.dto

data class OrderRequest(
    val userId: Long,
    val restaurant: String,
    val items: List<String>
)