package com.astashin.bookvoed.network

import com.astashin.bookvoed.network.request.LoginRegistrationRequest
import com.astashin.bookvoed.network.response.LoginRegistrationResponse
import io.reactivex.Flowable
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("/users/login")
    fun login(@Body request: LoginRegistrationRequest): Flowable<LoginRegistrationResponse>

    @POST("/users/registration")
    fun registration(@Body request: LoginRegistrationRequest): Flowable<LoginRegistrationResponse>
}