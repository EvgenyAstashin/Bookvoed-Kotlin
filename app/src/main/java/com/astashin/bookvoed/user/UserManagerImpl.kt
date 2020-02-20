package com.astashin.bookvoed.user

import android.accounts.AccountManager
import android.content.Context
import com.astashin.bookvoed.network.UserApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserManagerImpl @Inject constructor(val context: Context, val userApi: UserApi) : UserManager {

    var returnValue = false

    companion object {
        const val ACCOUNT_TYPE = "com.astashin.bookvoed"
    }

    override fun isUserLoggedIn(): Boolean {
//        val am = AccountManager.get(context)
//        val accounts = am.getAccountsByType(ACCOUNT_TYPE)
//        return accounts.isNotEmpty()
        val value = returnValue
        returnValue = true
        return value
    }

    override fun login(username: String, password: String) {

    }

    override fun register(username: String, password: String) {

    }

    override fun logout() {

    }

    private fun setToAccountManager(token: String) {
        val am: AccountManager = AccountManager.get(context)
    }
}