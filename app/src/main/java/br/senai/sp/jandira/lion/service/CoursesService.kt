package br.senai.sp.jandira.lion.service

import br.senai.sp.jandira.lion.model.CoursesList
import retrofit2.Call
import retrofit2.http.GET

interface CoursesService {
        @GET ("cursos")
    fun getCourses(): Call<CoursesList>


}