package com.example.cheftest

import android.R.attr.id
import android.R.attr.x
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.graphics.PointF.length
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import coil.load
import com.example.cheftest.network.ChefRecipes
import com.example.cheftest.ui.main.MainViewModel
import okio.`-DeprecatedUtf8`.size
import java.nio.file.Files.size


class MainActivity : AppCompatActivity() {
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        //Code to hide apiKey
        val ai: ApplicationInfo = applicationContext.packageManager
            .getApplicationInfo(applicationContext.packageName, PackageManager.GET_META_DATA)
        val value = ai.metaData["keyValue"]

        // Set up observer to listen for changes in chef recipes
        // Can rename "it" by typing "response ->"
        // BTW "it" doesn't work outside of viewmodel line of code
       viewModel.currentlyDisplayedChefRecipe.observe(this) {
           findViewById<ImageView>(R.id.imageView).load(
               it?.image?.toUri()?.buildUpon()?.scheme("https")?.build()
           )
           //  Display the title of the current recipe in that TextView
           findViewById<TextView>(R.id.textView).text = it.title

       }
       /*   viewModel.currentlyDisplayedRecipeSummary.observe(this){
        //Display the recipe summary in TextView
           findViewById<TextView>(R.id.recipeDescription).text = it.summary
          } */

        //Insert user inputted ingredient into the API
        findViewById<Button>(R.id.button).setOnClickListener {
            val userIngredient = findViewById<EditText>(R.id.userInput).text.toString()
          getChefRecipes(userIngredient)

            //Need to figure out how to match IDs
           // getRecipeSummary(userIngredient)
          //  var index = 0
         //   val currentImageUrl = viewModel.currentlyDisplayedChefRecipe.value?.image
          //  getChefRecipes(userIngredient,index++)

           //put i in a parameter similar to the userInput then pass it in the viewmodel
            }


    }
    //private fun getChefRecipes(userIngredient: String, index: Int){
    //    viewModel.getChefRecipes(userIngredient, index)
    private fun getChefRecipes(userIngredient: String){
            viewModel.getChefRecipes(userIngredient)

        }
    private fun getRecipeSummary(id: Int){
        viewModel.getRecipeSummary(id)
    }
}






/*     Goal: match the id of the recipe to the recipe summary
        viewModel.currentlyDisplayedRecipeSummary.observe
        if getChefRecipes(userIngredient).contains(id) --> use when statement?
        list.get()*/
