package com.example.challenge.service

import com.example.challenge.domain.User
import com.example.challenge.repository.UserRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UserService(
    private val userRepository: UserRepository
) {

    private val logger: Logger = LoggerFactory.getLogger(UserService::class.java)

    fun getUserById(id: Long): Mono<User> {
        return userRepository.findById(id)
            .doOnError { logger.error("An error occurred when searching for user ID $id: ${it.message}", it) }
            .doOnSuccess { logger.info("Record found successfully") }
    }

}