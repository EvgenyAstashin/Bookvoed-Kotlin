package com.astashin.bookvoed.components.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.astashin.bookvoed.user.*
import com.astashin.bookvoed.util.asMutable
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val userManager: UserManager) : ViewModel() {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val usernameState: LiveData<UsernameState> = MutableLiveData()
    val passwordState: LiveData<PasswordState> = MutableLiveData()

    val showProgress: LiveData<Boolean> = MutableLiveData()

    init {
        listenUsernameAndPasswordChanges()
    }

    fun login() {
        if (validateAndSetErrorsIfNeed()) {
            userManager.login(username.value!!, password.value!!)
        }
    }

    private fun listenUsernameAndPasswordChanges() {
        username.observeForever { usernameState.asMutable().value =  UsernameState.VALID}
        password.observeForever { passwordState.asMutable().value =  PasswordState.VALID}
    }

    private fun validateAndSetErrorsIfNeed(): Boolean {
        val usernameValidationState = validateUsername(username.value)
        val passwordValidationState = validatePassword(password.value)

        usernameState.asMutable().value = usernameValidationState
        passwordState.asMutable().value = passwordValidationState

        return usernameValidationState == UsernameState.VALID && passwordValidationState == PasswordState.VALID
    }
}