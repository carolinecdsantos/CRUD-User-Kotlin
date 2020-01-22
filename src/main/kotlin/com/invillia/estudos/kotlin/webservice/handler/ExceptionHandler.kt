package com.invillia.estudos.kotlin.webservice.handler

import com.invillia.estudos.kotlin.webservice.exception.ErrorDetails
import com.invillia.estudos.kotlin.webservice.exception.UserNotFoundException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*


@ControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = [(UserNotFoundException::class)])
    fun handleUserNotFound(exception: UserNotFoundException, request:WebRequest) : ResponseEntity<ErrorDetails> {
        val errorsDetails = ErrorDetails(Date(), "User not found", exception.message!!)
        return ResponseEntity(errorsDetails, HttpStatus.NOT_FOUND)
    }
}