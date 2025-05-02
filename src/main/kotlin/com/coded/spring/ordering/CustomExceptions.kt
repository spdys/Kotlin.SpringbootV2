package com.coded.spring.ordering

open class OrderException(message: String) : RuntimeException(message)

class UserIdNotFound(userId: Long): OrderException("User ID $userId not found.")
class InvalidPasswordException(reason: String): OrderException("Invalid password: $reason")
class UsernameAlreadyExistsException(): OrderException("Username already exists.")