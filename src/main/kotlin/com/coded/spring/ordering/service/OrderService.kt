package com.coded.spring.ordering.service

import com.coded.spring.ordering.dto.OrderRequest
import com.coded.spring.ordering.entity.ItemEntity
import com.coded.spring.ordering.entity.OrderEntity
import com.coded.spring.ordering.repository.ItemRepository
import com.coded.spring.ordering.repository.OrderRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val itemRepository: ItemRepository
) {

    fun getAllOrders(): List<OrderEntity> {
        return orderRepository.findAllByOrderByCreatedAtAsc()
    }

    fun createOrder(request: OrderRequest): String {
        val itemsToString = request.items.joinToString(", ")
        val existingItem = itemRepository.findByName(itemsToString)

        val item = existingItem ?: itemRepository.save(ItemEntity(0, itemsToString))

        val order = OrderEntity(
            0,
            request.userId,
            LocalDateTime.now(),
            request.restaurant,
            item
        )
        orderRepository.save(order)
        return "Order created."
    }
}