package com.example.lecturescard

import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.networking1.R
import com.example.networking1.user
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.item_user.view.*


class useradapter(var userlist:ArrayList<user>) : RecyclerView.Adapter<useradapter.userviewholder>() {
    class userviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image1:CircleImageView=itemView.findViewById(R.id.imageView)
        val textView:TextView=itemView.findViewById(R.id.textView)
        val subtext:TextView=itemView.findViewById(R.id.subhead)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userviewholder {
        val list:View=LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return userviewholder(list)
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    override fun onBindViewHolder(holder: userviewholder, position: Int) {
        val list:user=userlist[position]
        Log.d("error","${list}")
        Picasso.get()
            .load(list.avatar_url)
            .placeholder(android.R.drawable.btn_default)
            //.error(R.drawable.ic_launcher_background)
            .into(holder.image1)
      //  Picasso.get().load("https://avatars0.githubusercontent.com/u/1?v=4").into(holder.image1)
        holder.textView.text=list.url
        holder.subtext.text=list.gists_url
    }

}
