package com.example.simplecalculate

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val getSharedPreferences =
            getSharedPreferences("MySharedPrefs", Context.MODE_PRIVATE)
        val tvText: TextView = findViewById(R.id.tv_text)

        val btnGetData: Button = findViewById(R.id.btn_get_data)

        val myText = intent.getStringExtra("myText")?: "NOTHING TO SHOW"
        tvText.text = myText

        btnGetData.setOnClickListener {
            val text = getSharedPreferences.getString("myData", "Empty")?:"There is null"
                tvText.text = text
        }


    }
}