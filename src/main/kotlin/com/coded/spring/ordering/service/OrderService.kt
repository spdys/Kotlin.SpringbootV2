package com.coded.spring.ordering.service

import com.coded.spring.ordering.UserIdNotFound
import com.coded.spring.ordering.InvalidPasswordException
import com.coded.spring.ordering.dto.AuthenticationRequest
import com.coded.spring.ordering.dto.OrderRequest
import com.coded.spring.ordering.entity.ItemEntity
import com.coded.spring.ordering.entity.OrderEntity
import com.coded.spring.ordering.entity.UserEntity
import com.coded.spring.ordering.repository.ItemRepository
import com.coded.spring.ordering.repository.OrderRepository
import com.coded.spring.ordering.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val itemRepository: ItemRepository,
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun registerUser(request: AuthenticationRequest) {
        if (request.password.length < 6)
            throw InvalidPasswordException("Password must be at least 6 characters long.")
        if (!request.password.any { it.isUpperCase() })
            throw InvalidPasswordException("Password must contain at least one uppercase letter.")
        if (!request.password.any { it.isDigit() })
            throw InvalidPasswordException("Password must contain at least one number.")

        val user = UserEntity(
            0,
            request.username,
            passwordEncoder.encode(request.password)
        )

        userRepository.save(user)
    }

    fun getAllOrders(): List<OrderEntity> {
        return orderRepository.findAllByOrderByCreatedAtAsc()
    }

    fun createOrder(request: OrderRequest): String {
        val user = userRepository.findById(request.userId)
            .orElseThrow { UserIdNotFound(request.userId) }

        val itemsToString = request.items.joinToString(", ")
        val existingItem = itemRepository.findByName(itemsToString)
        val item = existingItem ?: itemRepository.save(ItemEntity(0, itemsToString))

        val order = OrderEntity(
            0,
            user.id,
            LocalDateTime.now(),
            request.restaurant,
            item
        )

        orderRepository.save(order)
        return "Order created."
    }

}