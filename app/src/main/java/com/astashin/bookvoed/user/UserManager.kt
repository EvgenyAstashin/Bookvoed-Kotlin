package com.astashin.bookvoed.user

import android.accounts.AccountManager
import android.content.Context
import com.astashin.bookvoed.network.UserApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserManager @Inject constructor(val context: Context, val userApi: UserApi) {

    companion object {
        const val ACCOUNT_TYPE = "com.astashin.bookvoed"
    }

    fun isUserLoggedIn(): Boolean {
        val am = AccountManager.get(context)
        val accounts = am.getAccountsByType(ACCOUNT_TYPE)
        return accounts.isNotEmpty()
    }

    fun login(username: String, password: String) {

    }

    fun register(username: String, password: String) {

    }

    fun logout() {

    }

    private fun setToAccountManager(token: String) {
        //AccountManager
    }
}