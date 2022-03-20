package com.asthiseta.core.domain.usecase

import com.asthiseta.core.data.Resource
import com.asthiseta.core.data.UserRepository
import com.asthiseta.core.domain.model.User
import com.asthiseta.core.domain.repository.IUserRepository
import kotlinx.coroutines.flow.Flow

class UserInteractor(private val userRepository: IUserRepository) : UserUseCase {
    override fun getAllUsers(): Flow<Resource<List<User>>> =
        userRepository.getAllUsers()

    override fun getAllFollowers(username: String): Flow<Resource<List<User>>> =
        userRepository.getAllFollowers(username)

    override fun getAllFollowing(username: String): Flow<Resource<List<User>>> =
        userRepository.getAllFollowing(username)

    /*override fun getDetailUser(username: String): Flow<Resource<User>> {

    }*/

}