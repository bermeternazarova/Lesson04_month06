package com.example.lesson04_month06

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var counter =0
    val mCounter=MutableLiveData<String>()

    val mCover =MutableLiveData<String>()
    private var list =ArrayList<String>()


    fun onIncrement(){
        counter++
        mCounter.value=counter.toString()

        list.add("\n+")
        mCover.value=list.toString()
    }
    fun onReduce(){
        counter--
        mCounter.value=counter.toString()

        list.add("\n-")
        mCover.value=list.toString()

    }
    fun getX():LiveData<String>{
        mCounter.value=this.counter.toString()
        return mCounter
    }
}
