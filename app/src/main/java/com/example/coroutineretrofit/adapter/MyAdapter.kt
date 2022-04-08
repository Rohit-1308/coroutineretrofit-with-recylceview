package com.example.coroutineretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutineretrofit.R
import com.example.coroutineretrofit.databinding.RowLayoutBinding
import com.example.coroutineretrofit.models.Post

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    private var mylist= emptyList<Post>()

    inner class MyViewHolder(var binding:RowLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        return MyViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
//        holder.itemView.rootView.findViewById<TextView>(R.id.userid_txt).text=mylist[position].userId.toString()
//        holder.itemView.rootView.findViewById<TextView>(R.id.id_txt).text=mylist[position].id.toString()
//        holder.itemView.rootView.findViewById<TextView>(R.id.title_txt).text=mylist[position].title.toString()
//        holder.itemView.rootView.findViewById<TextView>(R.id.body_txt).text=mylist[position].body.toString()
        holder.binding.useridTxt.text=mylist[position].userId.toString()
        holder.binding.idTxt.text=mylist[position].id.toString()
        holder.binding.titleTxt.text=mylist[position].title.toString()
        holder.binding.bodyTxt.text=mylist[position].body.toString()
    }

    override fun getItemCount(): Int {
        return mylist.size
    }


    fun setData(newList:List<Post>){
        mylist=newList
        notifyDataSetChanged()
    }
}