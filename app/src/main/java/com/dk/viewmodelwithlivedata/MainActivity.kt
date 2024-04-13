package com.dk.viewmodelwithlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var vm : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this).get(MainViewModel::class.java)

        findViewById<Button>(R.id.btnPlus).setOnClickListener {
            vm.plusLiveDataVal()
        }

        findViewById<Button>(R.id.btnMinus).setOnClickListener {
            vm.minusLiveDataVal()
        }


        /**
         * MutableLiveData 와 LiveData는 다르다.
         * 차이점: LiveData
         *  vm.testMutableLiveData.value = 10 이런식으로 재선언하기를 원하지 않을수도 있지 않을까?
         *  이때 사용하는게 LiveData
         */
        //LiveData를 관찰한다.
        vm.testMutableLiveData.observe(this, Observer{
//            findViewById<TextView>(R.id.textArea).text = vm.testMutableLiveData.value.toString()
            findViewById<TextView>(R.id.textArea).text = it.toString()
        })

        vm.testMutableLiveData.value = 10

    }
}