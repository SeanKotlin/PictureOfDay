package com.sklinn.pictureoftheday.Presenter

import com.sklinn.pictureoftheday.Model.PictureData

interface MainView{
    fun renderView(data:PictureData)
}