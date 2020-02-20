package com.astashin.bookvoed.user

import android.app.Service
import android.content.Intent
import android.os.IBinder

class AuthenticatorService : Service() {

    lateinit var authenticator: AccountAuthenticator

    override fun onCreate() {
        super.onCreate()
        authenticator = AccountAuthenticator(this)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return authenticator.iBinder
    }
}