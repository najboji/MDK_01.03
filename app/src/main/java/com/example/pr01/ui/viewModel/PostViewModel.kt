package com.example.pr01.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {

    fun deletePost(postId: Int) {
        viewModelScope.launch {
            try {
                val deleted = RetrofitClient.postService.deletePost(postId)
                Log.d("PostViewModel", "Пост с ID ${deleted.id} успешно удален")
                Log.d("PostViewModel", "isDeleted: ${deleted.isDeleted}")
                Log.d("PostViewModel", "deleted: ${deleted.deletedOn}")

            } catch (ex: Exception) {
                Log.e("PostViewModel", "Ошибка при удалении поста $postId: ${ex.message}")
            }
        }
    }
}