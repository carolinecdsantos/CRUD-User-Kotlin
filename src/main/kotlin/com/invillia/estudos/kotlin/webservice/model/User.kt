package com.invillia.estudos.kotlin.webservice.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.sun.istack.NotNull
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
data class User(
        @Id 
        @GeneratedValue(strategy = GenerationType.AUTO) 
        @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
        var id: Long,
        @NotNull
        @NotBlank
        val name:String,
        @NotNull
        @NotBlank
        @Size(min = 1)
        val login:String,
        @NotNull
        @NotBlank
        val password:String
)