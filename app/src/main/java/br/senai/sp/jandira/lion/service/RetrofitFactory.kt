package br.senai.sp.jandira.lion.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitFactory {

    private val URL_BASE = "https://api-lionschool.onrender.com/v1/lion-school/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCourseService(): CoursesService {
        return retrofitFactory.create(CoursesService::class.java)
    }

}