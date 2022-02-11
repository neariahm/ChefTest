package com.example.cheftest.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cheftest.network.ChefApi
import com.example.cheftest.network.ChefRecipes
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _currentlyDisplayedChefRecipe = MutableLiveData<ChefRecipes>()
    val currentlyDisplayedChefRecipe: LiveData<ChefRecipes> = _currentlyDisplayedChefRecipe

 /* init {
        getChefRecipes("pepper")
    } */

    // Must specify which item in the list
    fun getChefRecipes(ingredient: String) {
        viewModelScope.launch {
            _currentlyDisplayedChefRecipe.value = ChefApi.retrofitService.getChefRecipes(ingredient)[0]
        }
      //  How can I consolidate the code? Iterate through the list instead? Another possibility:
      // Increment - declare a variable, make i = 0, in the click listener increment i
        viewModelScope.launch {
            _currentlyDisplayedChefRecipe.value = ChefApi.retrofitService.getChefRecipes(ingredient)[1]
        }
        viewModelScope.launch {
            _currentlyDisplayedChefRecipe.value = ChefApi.retrofitService.getChefRecipes(ingredient)[2]
        }
        viewModelScope.launch {
            _currentlyDisplayedChefRecipe.value = ChefApi.retrofitService.getChefRecipes(ingredient)[3]
        }
        viewModelScope.launch {
            _currentlyDisplayedChefRecipe.value = ChefApi.retrofitService.getChefRecipes(ingredient)[4]
        }
        viewModelScope.launch {
            _currentlyDisplayedChefRecipe.value = ChefApi.retrofitService.getChefRecipes(ingredient)[5]
        }
        viewModelScope.launch {
            _currentlyDisplayedChefRecipe.value = ChefApi.retrofitService.getChefRecipes(ingredient)[6]
        }
    }
}




