package com.example.challenge.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(RecordNotFoundException::class)
    fun handleRecordNotFoundException(ex: RecordNotFoundException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.message)
    }
}