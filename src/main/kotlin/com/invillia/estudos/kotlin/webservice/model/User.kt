package com.invillia.estudos.kotlin.webservice.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User(@Id @GeneratedValue @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY) val id: Long = 0L, val name:String = "", val login:String = "", val password:String = "") {
    constructor() : this(0L, "", "", "")
}