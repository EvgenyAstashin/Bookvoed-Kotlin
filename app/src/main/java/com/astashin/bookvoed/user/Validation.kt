package com.astashin.bookvoed.user

import android.text.TextUtils
import com.astashin.bookvoed.R

fun validateUsername(username: String?): UsernameState {
    if(TextUtils.isEmpty(username))
        return UsernameState.EMPTY
    return UsernameState.VALID
}

fun validatePassword(password: String?): PasswordState {
    if(TextUtils.isEmpty(password))
        return PasswordState.EMPTY
    return PasswordState.VALID
}

interface ValidationState {
    fun getError(): Int?
}

enum class UsernameState(private val errorId: Int?): ValidationState {
    VALID(null),
    EMPTY(R.string.username_is_empty);

    override fun getError() = errorId
}

enum class PasswordState(private val errorId: Int?): ValidationState {
    VALID(null),
    EMPTY(R.string.password_is_empty);

    override fun getError() = errorId
}