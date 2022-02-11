package com.example.cheftest

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.cheftest.ui.main.MainViewModel
import androidx.activity.viewModels
import androidx.core.net.toUri
import coil.load
import com.example.cheftest.network.ChefRecipes

class MainActivity : AppCompatActivity() {
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val ai: ApplicationInfo = applicationContext.packageManager
            .getApplicationInfo(applicationContext.packageName, PackageManager.GET_META_DATA)
        val value = ai.metaData["keyValue"]
        val key = value.toString()

        // Can rename "it" by typing "response ->"
        // BTW "it" doesn't work outside of viewmodel line of code
        viewModel.currentlyDisplayedChefRecipe.observe(this) {
            findViewById<ImageView>(R.id.imageView).load(
                it?.image?.toUri()?.buildUpon()?.scheme("https")?.build()
            )
            //  Display the title of the current recipe in that TextView
            findViewById<TextView>(R.id.textView).text = it.title

        }
        //Insert user inputted ingredient into the API
        findViewById<Button>(R.id.button).setOnClickListener {
            val userIngredient = findViewById<EditText>(R.id.userInput).text.toString()
            getChefRecipes(userIngredient)
        }
    }
    private fun getChefRecipes(userIngredient: String){
            viewModel.getChefRecipes(userIngredient)
        }
          }







