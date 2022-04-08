package com.example.coroutineretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutineretrofit.adapter.MyAdapter
import com.example.coroutineretrofit.databinding.ActivityMainBinding
import com.example.coroutineretrofit.models.Post
import com.example.coroutineretrofit.repository.Repository

class MainActivity : AppCompatActivity() {

    var binding : ActivityMainBinding?=null
    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy {MyAdapter()}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val repository= Repository()
        val viewModelFactory=MainViewModelFactory(repository)
        setUpRecycleView()
        viewModel = ViewModelProvider(this,viewModelFactory)[MainViewModel::class.java]

//        val mypost= Post(2,"this is tittle","this is body",2)
        viewModel.getCustomPost(5,"id","desc")

        viewModel.mycustomresponse.observe(this, Observer {
            response->
            if(response.isSuccessful){
                //reponse from the get request is set to mylist of myadapter for recyleview
                response?.body()?.let { myAdapter.setData(it) }
            }else{
                Toast.makeText(this,"response of this post request not received",Toast.LENGTH_LONG).show()
            }
        })
    }
        private fun setUpRecycleView(){
            binding?.recycleview?.adapter=myAdapter
            binding?.recycleview?.layoutManager=LinearLayoutManager(this)
        }

}
