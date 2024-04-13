package com.dk.viewmodelwithlivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var testMutableLiveData = MutableLiveData(0)


    fun plusLiveDataVal(){
        testMutableLiveData.value = testMutableLiveData.value!!.plus(1)
    }

    fun minusLiveDataVal(){
        testMutableLiveData.value = testMutableLiveData.value!!.minus(1)
        testMutableLiveData.value = testMutableLiveData.value!!.minus(1)
    }
}