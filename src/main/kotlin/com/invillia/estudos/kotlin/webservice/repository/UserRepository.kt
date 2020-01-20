package com.invillia.estudos.kotlin.webservice.repository

import com.invillia.estudos.kotlin.webservice.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long> {
}