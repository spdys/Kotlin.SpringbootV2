package com.coded.spring.ordering

open class OrderException(message: String) : RuntimeException(message)

class UserIdNotFound(userId: Long): OrderException("User ID $userId not found.")
