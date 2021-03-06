package com.asthiseta.core.domain.usecase

import com.asthiseta.core.data.Resource
import com.asthiseta.core.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserUseCase {
    fun getAllUsers(): Flow<Resource<List<User>>>

    fun getAllFollowers(username: String): Flow<Resource<List<User>>>

    fun getAllFollowing(username: String): Flow<Resource<List<User>>>

    fun getDetailUser(username: String): Flow<Resource<User>>
}