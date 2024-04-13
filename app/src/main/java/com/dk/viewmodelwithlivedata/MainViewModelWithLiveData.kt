package com.dk.viewmodelwithlivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModelWithLiveData : ViewModel() {

    private var _testMutableLiveData = MutableLiveData(0)
    val testLiveData : LiveData<Int>
        get() = _testMutableLiveData
    fun plusLiveDataVal(){
        _testMutableLiveData.value = _testMutableLiveData.value!!.plus(1)
    }

    fun minusLiveDataVal(){
        _testMutableLiveData.value = _testMutableLiveData.value!!.minus(1)
    }
}