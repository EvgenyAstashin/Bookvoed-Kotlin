package com.astashin.bookvoed.di

import com.astashin.bookvoed.BuildConfig
import com.astashin.bookvoed.network.BookApi
import com.astashin.bookvoed.network.UserApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AppModule {

    @Provides
    fun userApi(): UserApi = buildRetrofit().create(UserApi::class.java)

    @Provides
    fun bookApi(): BookApi = buildRetrofit().create(BookApi::class.java)

    private fun buildRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API)
            .build()
    }
}