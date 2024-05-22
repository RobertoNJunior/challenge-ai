package com.example.challenge.controller

import com.example.challenge.domain.User
import com.example.challenge.domain.input.EncryptedUserDataInput
import com.example.challenge.domain.output.DecryptedUserDataOutput
import com.example.challenge.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {

    private val logger = LoggerFactory.getLogger(UserController::class.java)

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getUserById(@PathVariable id: Long): Mono<User> {
        return userService.getUserById(id)
            .doFirst { logger.info("Recovering user with id: $id") }
    }

    @PostMapping("/decrypt-user-data")
    @ResponseStatus(HttpStatus.OK)
    fun decryptUserData(@RequestBody userInput: EncryptedUserDataInput): Mono<DecryptedUserDataOutput> {
        return Mono.just(DecryptedUserDataOutput(id = 1, login = "teste@gmail.com", name = "Teste"))
    }
}