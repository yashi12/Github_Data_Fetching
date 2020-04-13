package com.example.networking1

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun <T> retrofitCallback(function: (Throwable?,Response<T>?) -> Unit): Callback<T> {
    return object :Callback<T>{
        override fun onFailure(call: Call<T>, t: Throwable) {
            return function(t,null)
        }

        override fun onResponse(call: Call<T>, response: Response<T>) {
            return function(null,response)
        }

    }
}