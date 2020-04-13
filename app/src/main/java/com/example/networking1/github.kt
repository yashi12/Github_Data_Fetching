package com.example.networking1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface github {
    @GET("users/{name}")
    fun getuser(@Path("name")name:String):Call<user>

    @GET("users")
    fun getallusers():Call<List<user>>
}