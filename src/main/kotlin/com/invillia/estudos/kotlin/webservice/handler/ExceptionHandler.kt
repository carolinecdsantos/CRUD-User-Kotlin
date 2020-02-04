package com.invillia.estudos.kotlin.webservice.handler

import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
import com.invillia.estudos.kotlin.webservice.exception.ErrorDetails
import com.invillia.estudos.kotlin.webservice.exception.MissingParametersRequestException
import com.invillia.estudos.kotlin.webservice.exception.UserNotFoundException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*


@ControllerAdvice
class ExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = [(UserNotFoundException::class)])
    fun handleUserNotFound(exception: UserNotFoundException, request:WebRequest) : ResponseEntity<ErrorDetails> {
        val errorsDetails = ErrorDetails(Date(), "User not found", exception.message!!)
        return ResponseEntity(errorsDetails, HttpStatus.NOT_FOUND)
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = [(MethodArgumentNotValidException::class)])
    fun handleMissingKotlinParameterException(exception: MethodArgumentNotValidException) : ResponseEntity<ErrorDetails> {
        val errorDetails = ErrorDetails(Date(), "Missing Parameters Method Argument Not Valid", exception.message)
        return ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = [(JsonMappingException::class)])
    fun handleJsonMappingException(exception: JsonMappingException) : ResponseEntity<ErrorDetails> {
        val errorDetails = ErrorDetails(Date(), "Missing Parameters Json Mapping", exception.message!!)
        return ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
    }
}