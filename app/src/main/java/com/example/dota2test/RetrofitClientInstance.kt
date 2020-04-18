package com.example.dota2test

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {

    private var retrofit: Retrofit? = null
    //private val BASE_URL = "https://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/V001/?account_id=64335358&key=98386B16E9E93CE3F216965CC303BEA5"
    private val BASE_URL = "https://api.steampowered.com/"

    // create a retrofit instance, only if it has not been created yet.
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit =  Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit
        }
}