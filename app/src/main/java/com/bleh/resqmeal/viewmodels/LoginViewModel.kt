package com.bleh.resqmeal.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel(): ViewModel() {
    private val _email = MutableStateFlow("")
    val email = _email

    private val _password = MutableStateFlow("")
    val password = _password

    private val _passwordVisible = MutableStateFlow(false)
    val passwordVisible = _passwordVisible

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPassword(password: String) {
        _password.value = password
    }

    fun setPasswordVisible(visible: Boolean) {
        _passwordVisible.value = visible
    }
}