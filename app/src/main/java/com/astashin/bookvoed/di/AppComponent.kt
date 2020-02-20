package com.astashin.bookvoed.di

import android.content.Context
import com.astashin.bookvoed.components.login.LoginFragment
import com.astashin.bookvoed.components.splash.SplashFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(fragment: SplashFragment)

    fun inject(fragment: LoginFragment)
}