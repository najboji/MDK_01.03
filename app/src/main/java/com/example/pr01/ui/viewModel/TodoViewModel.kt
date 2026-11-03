package com.example.pr01.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {

    fun fetchTodos() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.todoService.getTodos()

                if (response.isSuccessful) {
                    val body = response.body()
                    if (body?.items != null) {
                        Log.d("TodoViewModel", "Пагинация: страница ${body.page}, всего ${body.totalItems} задач")
                        for (todo in body.items) {
                            Log.d("TodoViewModel",
                                "ID: ${todo.id}\n" +
                                        "Задача: ${todo.todo}\n" +
                                        "Статус: ${if (todo.completed == true) "Выполнено" else "Не выполнено"}\n" +
                                        "Создано: ${todo.created}")
                        }
                    } else {
                        Log.d("TodoViewModel", "Список задач пуст.")
                    }
                } else {
                    Log.e("TodoViewModel", "Ошибка сервера: ${response.code()} - ${response.message()}")
                }
            } catch (ex: Exception) {
                Log.e("TodoViewModel", "Сетевая ошибка: ${ex.message}")
            }
        }
    }
}