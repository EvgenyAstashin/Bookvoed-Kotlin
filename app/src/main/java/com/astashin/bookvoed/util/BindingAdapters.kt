package com.astashin.bookvoed.util

import androidx.databinding.BindingAdapter
import com.astashin.bookvoed.user.ValidationState
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("app:validationState")
fun validationState(view: TextInputLayout, state: ValidationState?) {
    if(state?.getError() == null) {
        view.isErrorEnabled = false
    } else {
        view.isErrorEnabled = true
        view.error = view.context.getString(state.getError()!!)
    }
}