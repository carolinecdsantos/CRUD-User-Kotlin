package com.invillia.estudos.kotlin.webservice.controller

import com.invillia.estudos.kotlin.webservice.model.User
import com.invillia.estudos.kotlin.webservice.repository.UserRepository
import com.invillia.estudos.kotlin.webservice.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

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
    fun create(@Valid @RequestBody user: User) : User{
        return userService.createUser(user)
    }
    
    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long) : User? {
        val user: User? = userService.getUserById(id)
        return user
    }
    
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Valid @RequestBody user: User) : User? {
        return userService.updateUser(id, user)
    }
    
    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) {
        return userService.deleteUser(id)
    }
}