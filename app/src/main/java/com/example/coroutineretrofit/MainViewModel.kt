package com.example.coroutineretrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutineretrofit.models.Post
import com.example.coroutineretrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {
    val myresponse:MutableLiveData<Response<Post>> = MutableLiveData()
    val myresponse2:MutableLiveData<Response<Post>> = MutableLiveData()
    val mycustomresponse:MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun pushPost(post:Post){
        viewModelScope.launch {
            val response=repository.pushPost(post)
            myresponse.value=response
        }
    }
    fun getPost(){
        viewModelScope.launch{
           val response=repository.getPost()
            myresponse.value=response
        }
    }
    fun getPost2(number:Int){
        viewModelScope.launch{
           val response=repository.getPost2(number)
            myresponse2.value=response
        }
    }

    fun getCustomPost(userId:Int,sort:String,order:String){
        viewModelScope.launch {
            val response=repository.getCustomPost(userId,sort,order)
            mycustomresponse.value=response
        }
    }

}