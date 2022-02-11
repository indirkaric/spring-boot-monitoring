package com.indir.monitoring.api.mapper

import com.indir.monitoring.api.dto.CreateUserDto
import com.indir.monitoring.api.dto.UserDto
import com.indir.monitoring.api.entity.User

class UserMapper {
    companion object {
        fun toDto(user: User): UserDto {
            return UserDto(
                id = user.id,
                firstName = user.firstName,
                lastName = user.lastName,
                username = user.username,
                createdAt = user.createdAt
            )
        }

        fun toEntity(user: CreateUserDto): User {
            return User(
                firstName = user.firstName,
                lastName = user.lastName,
                username = user.username
            )
        }
    }
}