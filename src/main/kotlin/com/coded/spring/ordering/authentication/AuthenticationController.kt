package com.coded.spring.ordering.authentication

import com.coded.spring.ordering.dto.AuthenticationRequest
import com.coded.spring.ordering.dto.AuthenticationResponse
import com.coded.spring.ordering.dto.FailureResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.*
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping()
class AuthenticationController(
    private val authenticationManager: AuthenticationManager,
    private val userDetailsService: UserDetailsService,
    private val authenticationService: AuthenticationService
) {

    @PostMapping("/login")
    fun login(@RequestBody authRequest: AuthenticationRequest): ResponseEntity<*> {
        return try {
            val authToken = UsernamePasswordAuthenticationToken(authRequest.username, authRequest.password)
            val authentication = authenticationManager.authenticate(authToken)

            if (authentication.isAuthenticated) {
                val userDetails = userDetailsService.loadUserByUsername(authRequest.username)
                val token = authenticationService.generateToken(userDetails.username)
                ResponseEntity.ok(AuthenticationResponse(token))
            } else {
                throw UsernameNotFoundException("Invalid user request!")
            }
        } catch (e: BadCredentialsException) {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(FailureResponse("Invalid username or password."))
        }
    }
}