package com.sklinn.pictureoftheday

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.sklinn.pictureoftheday.Model.PictureData
import com.sklinn.pictureoftheday.Presenter.MainPresenter
import com.sklinn.pictureoftheday.Presenter.MainView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(),MainView {
    private lateinit var mainPresenter: MainPresenter
    private var data:PictureData? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter()
        mainPresenter.registerView(this)


        fabdownload.setOnClickListener {
            val date = etReleaseDate.text.toString()
            mainPresenter.getDateImage(date)
        }

    }

    override fun renderView(data: PictureData) {
        this.data = data
        tvDescription.text = data.explanation
        tvCopyRight.text = data.copyright
        Glide.with(this)
            .load(data.hdurl)
            .into(ivBanner)
    }

}