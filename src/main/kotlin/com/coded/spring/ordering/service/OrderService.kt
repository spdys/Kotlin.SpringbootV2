package com.coded.spring.ordering.service

import com.coded.spring.ordering.dto.OrderRequest
import com.coded.spring.ordering.entity.OrderEntity
import com.coded.spring.ordering.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(private val orderRepository: OrderRepository) {

    fun getAllOrders(): List<OrderEntity> {
        return orderRepository.findAll()
    }

    fun createOrder(request: OrderRequest): String {
        val order = OrderEntity(
            0,
            request.userId,
            request.restaurant,
            request.items.joinToString(", ")
        )
        orderRepository.save(order)
        return "Order created."
    }
}