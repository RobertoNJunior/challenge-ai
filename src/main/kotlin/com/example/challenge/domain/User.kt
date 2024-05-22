package com.example.challenge.domain

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table


@Entity
@Table(name = "tb_user")
data class User @JsonCreator constructor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    val id: Long = 0,

    @JsonProperty("login")
    val login: String,

    @JsonProperty("name")
    val name: String
)