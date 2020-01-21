package com.invillia.estudos.kotlin.webservice.service

import com.invillia.estudos.kotlin.webservice.model.User
import com.invillia.estudos.kotlin.webservice.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull

class UserServiceImpl : UserService {
    
    @Autowired
    lateinit var userRepository: UserRepository
    
    override fun createUser(user: User) : User {
        return userRepository.save(user)    
    }

    override fun updateUser(id: Long, user: User) : User ? {
        val currentUser = userRepository.findByIdOrNull(id)
        if (currentUser != null) {
            return userRepository.save(user.copy(id))
        }
        return currentUser;
    }

    override fun getUserById(id: Long) : User ? {
        return userRepository.findById(id).get()
    }

    override fun getUsers(): List<User> {
        return userRepository.findAll().toList()
    }

    override fun deleteUser(id: Long) {
        return userRepository.deleteById(id)
    }

    override fun existsUserById(id: Long): Boolean {
        return userRepository.existsById(id)
    }
}