package com.asthiseta.bismillahtest.home

import androidx.lifecycle.*
import com.asthiseta.core.data.Resource
import com.asthiseta.core.domain.model.User
import com.asthiseta.core.domain.usecase.UserUseCase


class HomeViewModel(userUseCase : UserUseCase) : ViewModel()  {

    val users : LiveData<Resource<List<User>>> = userUseCase.getAllUsers().asLiveData()
}