package com.example.pr01.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import com.example.pr01.data.model.User
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    fun editUser(userToSend: User) {
        viewModelScope.launch {
            try {
                val updatedUser = RetrofitClient.userService.updateUser(
                    id = userToSend.id ?: 0,
                    user = userToSend
                )

                Log.d("UserViewModel", "ID: ${updatedUser.id}")
                Log.d("UserViewModel", "Имя: ${updatedUser.firstName}")
                Log.d("UserViewModel", "Фамилия: ${updatedUser.lastName}")
                Log.d("UserViewModel", "Возраст: ${updatedUser.age}")
                Log.d("UserViewModel", "Волосы - Цвет: ${updatedUser.hair.color}, Тип: ${updatedUser.hair.type}")

            } catch (ex: Exception) {
                Log.d("UserViewModel", "Ошибка при редактировании: ${ex.message}")
            }
        }
    }
}