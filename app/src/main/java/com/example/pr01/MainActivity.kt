package com.example.pr01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.pr01.data.model.Hair
import com.example.pr01.data.model.Recipe
import com.example.pr01.data.model.RecipeResponse
import com.example.pr01.data.model.User
import com.example.pr01.ui.viewModel.ProductViewModel
import com.example.pr01.ui.viewModel.RecipeViewModel
import com.example.pr01.ui.viewModel.UserViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        Практическая 14

//        val productViewModel: ProductViewModel by viewModels()
//        productViewModel.fetchProducts()

//        Практическая 15

//        val recipeViewModel: RecipeViewModel by viewModels()
//        val recipeToAdd = Recipe(
//            name = "Куриное филе в сливочно-чесночном соусе",
//            ingredients = listOf(
//                "Куриное филе",
//                "Сливки",
//                "Чеснок",
//                "Сливочное масло",
//                "Растительное масло",
//                "Твердый сыр",
//                "Соль",
//                "Черный перец",
//                "Итальянские травы"
//            ),
//            cookTimeMinutes = 25,
//            difficulty = "Easy"
//        )
//    recipeViewModel.fetchRecipes(recipeToAdd)

//          Практическая 16

        val viewModel = UserViewModel()
        val userForEdit = User(
            id = 15,
            firstName = "Ирина",
            lastName = "Воронова",
            age = 29,
            hair = Hair(
                color = "темные",
                type = "кудрявые"
            )
        )
        viewModel.editUser(userForEdit)
    }
}