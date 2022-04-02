package com.example.cheftest.network

import android.os.Build
import com.example.cheftest.BuildConfig
import com.example.cheftest.BuildConfig.apiKey
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://api.spoonacular.com/recipes/"

private val networkLoggingInterceptor =
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .client(OkHttpClient.Builder().addInterceptor(networkLoggingInterceptor).build())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

// suspend functions are core to coroutines which handle async work (wont block the main thread)
    interface ChefTestService {
        @GET ("findByIngredients?apiKey=$apiKey&number=15&ranking=2")
        suspend fun getChefRecipes(@Query("ingredients") ingredient: String): List<ChefRecipes>

        @GET ("{id}/summary?apiKey=$apiKey")
        suspend fun getRecipeSummary(@Path("id") id: Int): RecipeSummary
    }
// Exposes the Retrofit service to the rest of the app
    object ChefApi {
        val retrofitService : ChefTestService by lazy {
            retrofit.create(ChefTestService::class.java)
        }
    }
