package com.invillia.estudos.kotlin.webservice.service

import com.invillia.estudos.kotlin.webservice.model.User

interface UserService {
    fun createUser(user: User) : User
    fun updateUser(id: Long, user: User) : User ?
    fun getUserById(id: Long) : User ?
    fun getUsers() : List<User>
    fun deleteUser(id : Long)
    fun existsUserById(id: Long) : Boolean
}