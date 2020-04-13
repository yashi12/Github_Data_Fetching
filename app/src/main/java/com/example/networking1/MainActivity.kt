package com.example.networking1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lecturescard.useradapter
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvlist.layoutManager = LinearLayoutManager(this)
        val call: Call<List<user>> = client.api.getallusers()
        call.enqueue(retrofitCallback { throwable, response ->
            val listadapter: useradapter = useradapter(response?.body() as ArrayList<user>)
            rvlist.adapter = listadapter
        })
    }

    override fun onStart() {
        super.onStart()
        val call:Call<user> = client.api.getuser("uditjain-cyber")
        call.enqueue(object : Callback<user>{
            override fun onResponse(call: Call<user>, response: Response<user>) {
                val userdata :user? = response.body()
                runOnUiThread{
                    textView.text = userdata?.url
                    subhead.text = userdata?.gists_url
                    Picasso.get().load(userdata?.avatar_url).into(imageView)
                }
            }
            override fun onFailure(call: Call<user>, t: Throwable) {
            }
        })
    }

//        val gson:Gson = Gson()
//        val user1:user = user("ji","hi","hello")
//        val json:String = gson.toJson(user1)
//        val json:String= "{\"avatarurl\":\"ji\",\"gisturl\":\"hello\",\"url\":\"hi\"}"
//        val user1:user = gson.fromJson(json,user::class.java)
//        Log.d("hi","hello")

}





