package com.sklinn.pictureoftheday.Remote

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestClient {
    companion object {
        fun getApiService(): ApiService {
            return getRetrofit().create(ApiService::class.java)
        }

        private fun getClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .build()
        }

        private fun getConverter(): GsonConverterFactory {
            val gson = Gson()
            return GsonConverterFactory.create(gson)
        }

        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/planetary/")
                .client(getClient())
                .addConverterFactory(getConverter())
                .build()
        }
    }
}