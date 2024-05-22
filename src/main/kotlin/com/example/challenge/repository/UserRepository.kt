package com.example.challenge.repository

import com.example.challenge.domain.User
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : R2dbcRepository<User, Long>