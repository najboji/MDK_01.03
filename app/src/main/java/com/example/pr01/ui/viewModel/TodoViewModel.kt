package com.example.pr01.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class TodoViewModel(val tokenManager: TokenManager): ViewModel() {

    fun getTodos() {
        viewModelScope.launch {
            try {
                val token = tokenManager.tokenFlow().first()
                token?.let{
                    val todoResponse = RetrofitClient.todoService.getTodos(token)

                    for (item in todoResponse.items.orEmpty()) {
                        Log.d("TodoViewModel",
                            "id: ${item.id}, " +
                                    "\ntodo: ${item.todo}," +
                                    "\ncompleted: ${item.completed}," +
                                    "\ncreated: ${item.created}," +
                                    "\nupdated: ${item.updated}")
                    }

                }
            } catch (ex: Exception) {
                Log.e("TodoViewModel", "Сетевая ошибка: ${ex.message}")
            }
        }
    }
}