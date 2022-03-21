package com.asthiseta.bismillahtest.follow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asthiseta.bismillahtest.util.TypeView
import com.asthiseta.core.domain.usecase.UserUseCase

class FollowViewModel(userUseCase: UserUseCase) : ViewModel(){
    private var username : MutableLiveData<String> = MutableLiveData()
    private lateinit var typeView : TypeView

    fun setFollow(user : String, type: TypeView){
        if(username.value == user){
            return
        }
        username.value = user
        typeView = type
    }
}