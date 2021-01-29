package com.wdpfm.android_kotlin_learn

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        button2.setOnClickListener {
            val intent=Intent();
            intent.putExtra("data_return","Hello FirstActivity")
            setResult(RESULT_OK,intent)
            finish()
        }
        val data1=intent.getStringExtra("param1")
        Log.d("SecondActivity", "data1 is $data1")
        val data2=intent.getStringExtra("param2")
        Log.d("SecondActivity", "data2 is $data2")
    }

    override fun onBackPressed() {
        val intent=Intent();
        intent.putExtra("data_return","Hello FirstActivity")
        setResult(RESULT_OK,intent)
        finish()
    }


    companion object{
        fun actionStart(context: Context, data1:String, data2:String){
            val intent=Intent(context,SecondActivity::class.java)
            intent.putExtra("param1",data1)
            intent.putExtra("param2",data2)
            context.startActivity(intent)
        }
    }
}