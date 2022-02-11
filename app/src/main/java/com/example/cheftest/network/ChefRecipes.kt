package com.example.cheftest.network

import com.squareup.moshi.Json

/* This data class defines a Chef recipe which includes an ID and an image URL.
* The property names of this data class are used by Moshi to match the names of values in JSON.
 */

data class ChefRecipes(
 val id: String,
 val image: String,
 val title: String

 // possibly add more here
)