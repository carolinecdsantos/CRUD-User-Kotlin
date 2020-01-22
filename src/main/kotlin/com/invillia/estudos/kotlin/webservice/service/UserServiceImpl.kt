package com.invillia.estudos.kotlin.webservice.service

import com.invillia.estudos.kotlin.webservice.exception.UserNotFoundException
import com.invillia.estudos.kotlin.webservice.model.User
import com.invillia.estudos.kotlin.webservice.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import javax.swing.text.html.Option

@Service
class UserServiceImpl : UserService {
    
    @Autowired
    lateinit var userRepository: UserRepository
    
    override fun createUser(user: User) : User {
        return userRepository.save(user)    
    }

    override fun updateUser(id: Long, user: User) : User ? {
        val currentUser: Optional<User> = userRepository.findById(id)
        if (currentUser.isPresent) {
            return userRepository.save(user.copy(id))
        }
        throw UserNotFoundException("O usuário com id: $id não foi encontrado")
    }

    override fun getUserById(id: Long) : User ? {
        val user:Optional<User> = userRepository.findById(id)
        if (user.isPresent) {
            return user.get()
        }
        throw UserNotFoundException("O usuário com id: $id não foi encontrado")
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