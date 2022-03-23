package com.asthiseta.bismillahtest.di

import com.asthiseta.bismillahtest.detail.DetailViewModel
import com.asthiseta.bismillahtest.follow.FollowViewModel
import com.asthiseta.bismillahtest.home.HomeViewModel
import com.asthiseta.core.domain.usecase.UserInteractor
import com.asthiseta.core.domain.usecase.UserUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module{
    factory<UserUseCase> {UserInteractor(get()) }
}

val viewModelModule = module{
    viewModel { HomeViewModel(get()) }
    viewModel { FollowViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}