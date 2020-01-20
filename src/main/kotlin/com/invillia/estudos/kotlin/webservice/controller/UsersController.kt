package com.invillia.estudos.kotlin.webservice.controller

import com.invillia.estudos.kotlin.webservice.model.User
import com.invillia.estudos.kotlin.webservice.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("users")
class UsersController {
    
    @Autowired
    lateinit var userRepository: UserRepository
    
    @GetMapping
    fun list() : List<User> {
        return userRepository.findAll().toList()
    }
    
    @PostMapping
    fun create(@RequestBody user: User) : User{
        return userRepository.save(user)
    }
    
    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long) : User {
        val user: Optional<User> = userRepository.findById(id)
        return user.get()
    }
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody user: User) : User {
        if (userRepository.existsById(id)) {
            val safeUser = user.copy(id)
            return userRepository.save(safeUser)
        }

        return User()
    }
    
    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
        }
    }
}