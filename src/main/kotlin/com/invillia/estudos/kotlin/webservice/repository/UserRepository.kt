package com.invillia.estudos.kotlin.webservice.repository

import com.invillia.estudos.kotlin.webservice.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {
}