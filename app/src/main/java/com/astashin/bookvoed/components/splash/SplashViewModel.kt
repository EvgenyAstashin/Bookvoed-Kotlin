package com.astashin.bookvoed.components.splash

import android.app.PendingIntent
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.astashin.bookvoed.network.UserApi
import com.astashin.bookvoed.user.UserManager
import com.astashin.bookvoed.user.UserManagerImpl
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val userManager: UserManagerImpl,
    private val userApi: UserApi
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _userLoggedIn = MutableLiveData<Boolean>()
    private val _loading = MutableLiveData<Boolean>(false)

    val userLoggedIn: LiveData<Boolean> = _userLoggedIn
    val loading: LiveData<Boolean> = _loading

    fun checkUser() {
        if (userManager.isUserLoggedIn())
            loadUser()
        else
            _userLoggedIn.value = false
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    private fun loadUser() {
        _loading.value = true
        _userLoggedIn.value = true
        PendingIntent
        Intent
        HashMap
    }
}