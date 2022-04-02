package com.example.cheftest.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cheftest.network.ChefApi
import com.example.cheftest.network.ChefRecipes
import com.example.cheftest.network.RecipeSummary
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    //Declare LiveData objects so MainActivity can observe the changes
    private val _currentlyDisplayedChefRecipe = MutableLiveData<ChefRecipes>()
    val currentlyDisplayedChefRecipe: LiveData<ChefRecipes> = _currentlyDisplayedChefRecipe

    private val _currentlyDisplayedRecipeSummary = MutableLiveData<RecipeSummary>()
   val currentlyDisplayedRecipeSummary: LiveData<RecipeSummary>  = _currentlyDisplayedRecipeSummary


  //  init {
    //    getRecipeSummary(4632)
   // }

    // Must specify which item in the list
    // fun getChefRecipes(ingredient: String, i: Int)
    fun getChefRecipes(ingredient: String) {
        // i is a variable that changes
        viewModelScope.launch {
           // _currentlyDisplayedChefRecipe.value = ChefApi.retrofitService.getChefRecipes(ingredient)[i]
        _currentlyDisplayedChefRecipe.value = ChefApi.retrofitService.getChefRecipes(ingredient)[0]

        }
    }
    // Match ids - Look at LinkedIn Challenge video
    fun getRecipeSummary(id: Int){
        viewModelScope.launch {
         //   try {
            _currentlyDisplayedRecipeSummary.value = ChefApi.retrofitService.getRecipeSummary(id)
         //  } catch (e:Exception) {
        //  _currentlyDisplayedRecipeSummary.value = "Failure: ${e.message}"
     //     }
            }
      //  How can I consolidate the code? Iterate through the list instead? Another possibility:
      // Increment - declare a variable, make i = 0, in the click listener increment i
      /* viewModelScope.launch {
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
        }*/

        }
        }
  //  }
//}




