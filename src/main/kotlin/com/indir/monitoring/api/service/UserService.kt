package com.indir.monitoring.api.service

import com.indir.monitoring.api.dto.CreateUserDto
import com.indir.monitoring.api.dto.UserDto
import com.indir.monitoring.api.entity.User
import com.indir.monitoring.api.exception.error.BadRequestException
import com.indir.monitoring.api.exception.error.NotFoundException
import com.indir.monitoring.api.exception.error.RestApiError
import com.indir.monitoring.api.mapper.UserMapper
import com.indir.monitoring.api.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun getUsers(): List<UserDto> = userRepository.findAll().map { user -> UserMapper.toDto(user) }

    fun getUser(id: Long): UserDto = UserMapper.toDto(findById(id))

    fun saveUser(createUserDto: CreateUserDto) {
        val user = userRepository.findByUsername(createUserDto.username)
        if (user != null)
            throw BadRequestException(RestApiError.USER_ALREADY_EXISTS)

        userRepository.save(UserMapper.toEntity(createUserDto))
    }

    private fun findById(id: Long): User {
        val user = userRepository.findById(id)
        if (user.isPresent)
            return user.get()
        throw NotFoundException(RestApiError.USER_NOT_FOUND)
    }
}