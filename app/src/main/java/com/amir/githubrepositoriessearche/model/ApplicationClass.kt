package com.amir.githubrepositoriessearche.model

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationClass : Application() {
    companion object {
        // Github URL
        const val BASE_URL = "https://api.github.com"

        lateinit var retrofit: Retrofit
    }

    override fun onCreate() {
        super.onCreate()

        //retrofit basic config
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }



}