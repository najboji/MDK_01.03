package com.example.pr01.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import com.example.pr01.data.model.AuthRequest
import com.example.pr01.data.model.AuthResponse
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class LoginViewModel(val tokenManager: TokenManager,
                    val todoViewModel: TodoViewModel): ViewModel() {

    fun login(authRequest: AuthRequest){
        viewModelScope.launch {
            try{
                val authResponse = RetrofitClient.authService.authWithPassword(authRequest)

                authResponse.token?.let {
                    tokenManager.saveToken(it)

                    todoViewModel.getTodos()
                }
            }
            catch (e: Exception){
                Log.e("LoginViewModel",e.message.toString())
            }
        }
    }
}