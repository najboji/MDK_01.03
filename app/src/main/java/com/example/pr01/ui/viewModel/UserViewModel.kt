package com.example.pr01.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import com.example.pr01.data.model.Hair
import com.example.pr01.data.model.User
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    fun loadAndEditUser(id: Int) {
        viewModelScope.launch {
            try {
                val originalUser = RetrofitClient.userService.getUser(id)
                Log.d("UserViewModel", "Получен: ${originalUser.id} ${originalUser.firstName} ${originalUser.lastName} ${originalUser.age} ${originalUser.hair}")

                val updatedUser = originalUser.copy(
                    firstName = "Ирина",
                    lastName = "Воронова",
                    age = 29,
                    hair = Hair(
                        color = "темные",
                        type = "кудрявые"
                    )
                )
                val response = RetrofitClient.userService.updateUser(originalUser.id, updatedUser)

                Log.d("UserViewModel", "Пользователь успешно обновлен:")
                Log.d("UserViewModel", "Новое имя: ${response.firstName}")
                Log.d("UserViewModel", "Новое фамилия: ${response.lastName}")
                Log.d("UserViewModel", "Новый возраст: ${response.age}")
                Log.d("UserViewModel", "Новый цвет волос: ${response.hair.color}")
                Log.d("UserViewModel", "Новый тип волос: ${response.hair.type}")
            } catch (ex: Exception) {
                Log.e("UserViewModel", "Ошибка в цепочке получения-изменения: ${ex.message}")
            }
        }
    }
}