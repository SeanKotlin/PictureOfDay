package com.sklinn.pictureoftheday.Remote

import com.sklinn.pictureoftheday.Model.PictureData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("apod")
    fun getPicture(
        @Query("api_key") key: String,
        @Query("date") date: String
    ): Call<PictureData>
}