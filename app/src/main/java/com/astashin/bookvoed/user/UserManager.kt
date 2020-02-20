package com.astashin.bookvoed.user

interface UserManager {

    fun isUserLoggedIn(): Boolean

    fun login(username: String, password: String)

    fun register(username: String, password: String)

    fun logout()
}