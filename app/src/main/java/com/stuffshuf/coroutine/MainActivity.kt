package com.stuffshuf.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random

class MainActivity : AppCompatActivity(),CoroutineScope  {

    val supervisor = SupervisorJob()
    override val coroutineContext: CoroutineContext

        get() = Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        button.setOnClickListener {

            launch {
                for (i in 0..10){

                    delay(3000)
                    tvTimer.text = "$i"
                }
            }
        }

        button2.setOnClickListener {
            tvTimer.text = "${randNum()}"
        }




    }

    private fun randNum() = Random(System.currentTimeMillis()).nextInt()


    override fun onDestroy() {
        coroutineContext.cancelChildren()
        super.onDestroy()

    }
}
