package com.dk.viewmodelwithlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity2 : AppCompatActivity() {
    private lateinit var vm : MainViewModelWithLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this).get(MainViewModelWithLiveData::class.java)

        findViewById<Button>(R.id.btnPlus).setOnClickListener {
            vm.plusLiveDataVal()
        }

        findViewById<Button>(R.id.btnMinus).setOnClickListener {
            vm.minusLiveDataVal()
        }

        vm.testLiveData.observe(this, Observer{
//            findViewById<TextView>(R.id.textArea).text = vm.testMutableLiveData.value.toString()
            findViewById<TextView>(R.id.textArea).text = it.toString()
        })

//        vm.testLiveData.value = 10 // LiveData는 이런 방식의 재선언을 허용하지 않는다.

    }
}