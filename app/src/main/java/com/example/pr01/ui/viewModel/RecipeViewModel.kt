package com.example.pr01.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import com.example.pr01.data.model.Recipe
import kotlinx.coroutines.launch

class RecipeViewModel: ViewModel() {
    fun fetchRecipes(recipeToSend: Recipe){
        viewModelScope.launch {
            try{
                val newRecipe = RetrofitClient.recipeService.addRecipe(recipeToSend)
                Log.d("RecipeViewModel", "${newRecipe.id}\n" +
                        "${newRecipe.name}\n" +
                        "${newRecipe.ingredients}\n" +
                        "${newRecipe.cookTimeMinutes}\n" +
                        "${newRecipe.difficulty}\n")
            } catch(ex: Exception){
                Log.d("RecipeViewModel", "${ex.message}")
            }
        }
    }
}