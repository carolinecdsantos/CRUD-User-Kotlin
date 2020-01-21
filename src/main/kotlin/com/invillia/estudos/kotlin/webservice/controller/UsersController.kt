package com.invillia.estudos.kotlin.webservice.controller

import com.invillia.estudos.kotlin.webservice.model.User
import com.invillia.estudos.kotlin.webservice.repository.UserRepository
import com.invillia.estudos.kotlin.webservice.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("users")
class UsersController {
    
    @Autowired
    lateinit var userService: UserService
    
    @GetMapping
    fun list() : List<User> {
        return userService.getUsers().toList()
    }
    
    @PostMapping
    fun create(@RequestBody user: User) : User{
        return userService.createUser(user)
    }
    
    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long) : User? {
        val user: User? = userService.getUserById(id)
        return user
    }
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody user: User) : User {
        if (userService.existsUserById(id)) {
            val safeUser = user.copy(id)
            return userService.createUser(safeUser)
        }

        return User()
    }
    
    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) {
        if (userService.existsUserById(id)) {
            userService.deleteUser(id)
        }
    }
}