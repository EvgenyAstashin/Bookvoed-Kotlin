package com.astashin.bookvoed.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.astashin.bookvoed.util.asMutable
import com.astashin.bookvoed.network.UserApi
import com.astashin.bookvoed.user.UserManager
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val userManager: UserManager,
    private val userApi: UserApi
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val userLoggedIn: LiveData<Boolean> = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = MutableLiveData<Boolean>(false)

    init {
        checkUser()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    private fun checkUser() {
        if (userManager.isUserLoggedIn())
            loadUser()
        else
            userLoggedIn.asMutable().value = false
    }

    private fun loadUser() {
        loading.asMutable().value = true
    }
}