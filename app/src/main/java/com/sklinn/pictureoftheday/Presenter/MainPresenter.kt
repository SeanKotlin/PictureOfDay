package com.sklinn.pictureoftheday.Presenter

import android.util.Log
import com.bumptech.glide.Glide
import com.sklinn.pictureoftheday.MainActivity
import com.sklinn.pictureoftheday.Model.PictureData
import com.sklinn.pictureoftheday.Remote.RestClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter {
    private var view: MainView? = null

    fun registerView(view: MainView?){
        this.view = view
    }

    fun getDateImage(date: String) {
        RestClient.getApiService()
            .getPicture("DEMO_KEY", date)
            .enqueue(object : Callback<PictureData> {
                override fun onResponse(call: Call<PictureData>, response: Response<PictureData>) {
                    if (response.isSuccessful) {
                        response.body()?.let { data ->
                              view?.renderView(data)
//                            view?.tvDescription.text = PictureDate.explanation
//                            view?.renderView(PictureData)
//
//
                        }
                    }
                }

                override fun onFailure(call: Call<PictureData>, t: Throwable) {
                    Log.d("Error", t.message.toString())
                }
            })
    }
}