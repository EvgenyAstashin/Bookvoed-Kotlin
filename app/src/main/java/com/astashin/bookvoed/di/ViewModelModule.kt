package com.astashin.bookvoed.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.astashin.bookvoed.ViewModelFactory
import com.astashin.bookvoed.ViewModelKey
import com.astashin.bookvoed.components.login.LoginViewModel
import com.astashin.bookvoed.components.registration.RegistrationViewModel
import com.astashin.bookvoed.components.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    internal abstract fun splashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun loginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RegistrationViewModel::class)
    internal abstract fun registrationViewModel(viewModel: RegistrationViewModel): ViewModel
}