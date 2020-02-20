package com.astashin.bookvoed.components.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.astashin.bookvoed.user.*
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val userManager: UserManagerImpl) : ViewModel() {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _usernameState = MutableLiveData<UsernameState>()
    private val _passwordState = MutableLiveData<PasswordState>()
    private val _showProgress = MutableLiveData<Boolean>()
    private val _loggedIn = MutableLiveData<Boolean>()

    val usernameState: LiveData<UsernameState> = _usernameState
    val passwordState: LiveData<PasswordState> = _passwordState
    val showProgress: LiveData<Boolean> = _showProgress
    val loggedIn: LiveData<Boolean> = _loggedIn

    init {
        listenUsernameAndPasswordChanges()
    }

    fun login() {
        if (validateAndSetErrorsIfNeed()) {
            userManager.login(username.value!!, password.value!!)
            _loggedIn.value = true
        }
    }

    private fun listenUsernameAndPasswordChanges() {
        username.observeForever { _usernameState.value =  UsernameState.VALID}
        password.observeForever { _passwordState.value =  PasswordState.VALID}
    }

    private fun validateAndSetErrorsIfNeed(): Boolean {
        val usernameValidationState = validateUsername(username.value)
        val passwordValidationState = validatePassword(password.value)

        _usernameState.value = usernameValidationState
        _passwordState.value = passwordValidationState

        return usernameValidationState == UsernameState.VALID && passwordValidationState == PasswordState.VALID
    }
}