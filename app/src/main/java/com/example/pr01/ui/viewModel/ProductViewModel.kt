package com.example.pr01.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr01.data.RetrofitClient
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    fun fetchProducts(){
        viewModelScope.launch {
            try{
                val response = RetrofitClient.productsService.getProducts()
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        val products = body.products ?: emptyList()
                        for (product in products){
                            Log.d("ProductViewModel",
                                "title: "+"${product.title}," +
                                        " \ndescription: "+"${product.description}," +
                                        " \nprice: "+ "${product.price}")
                        }
                    }
                }
            } catch(ex: Exception){
                Log.d("ProductViewModel", "${ex.message}")
            }
        }
    }

}