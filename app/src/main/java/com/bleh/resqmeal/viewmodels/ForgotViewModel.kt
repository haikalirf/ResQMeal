package com.bleh.resqmeal.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ForgotViewModel() : ViewModel() {
    private val _email = MutableStateFlow("")
    val email = _email

    private val _password1 = MutableStateFlow("")
    val password1 = _password1

    private val _password2 = MutableStateFlow("")
    val password2 = _password2

    private val _passwordVisible1 = MutableStateFlow(false)
    val passwordVisible1 = _passwordVisible1

    private val _passwordVisible2 = MutableStateFlow(false)
    val passwordVisible2 = _passwordVisible2

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPassword1(password: String) {
        _password1.value = password
    }

    fun setPassword2(password: String) {
        _password2.value = password
    }

    fun setPasswordVisible1(visible: Boolean) {
        _passwordVisible1.value = visible
    }

    fun setPasswordVisible2(visible: Boolean) {
        _passwordVisible2.value = visible
    }
}