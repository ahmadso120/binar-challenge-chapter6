package com.sopian.challenge5.domain.usecase.login

import androidx.lifecycle.LiveData
import com.sopian.challenge5.data.UserRepository
import com.sopian.challenge5.data.source.local.entity.UserEntity

class LoginUseCase(
    private val userRepository: UserRepository
) {
    operator fun invoke(email: String, password: String): LiveData<UserEntity?> {
        return userRepository.login(email, password)
    }
}