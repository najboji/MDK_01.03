package com.example.pr01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.pr01.data.model.Recipe
import com.example.pr01.data.model.RecipeResponse
import com.example.pr01.ui.viewModel.ProductViewModel
import com.example.pr01.ui.viewModel.RecipeViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recipeViewModel: RecipeViewModel by viewModels()
        val recipeToAdd = Recipe(
            name = "Куриное филе в сливочно-чесночном соусе",
            ingredients = listOf(
                "Куриное филе",
                "Сливки",
                "Чеснок",
                "Сливочное масло",
                "Растительное масло",
                "Твердый сыр",
                "Соль",
                "Черный перец",
                "Итальянские травы"
            ),
            cookTimeMinutes = 25,
            difficulty = "Easy"
        )
    recipeViewModel.fetchRecipes(recipeToAdd)
    }
}