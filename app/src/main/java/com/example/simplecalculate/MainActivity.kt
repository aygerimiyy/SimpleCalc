package com.example.simplecalculate


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences: SharedPreferences =
            getSharedPreferences("MySharedPrefs", Context.MODE_PRIVATE)
        val myEditText1: EditText = findViewById(R.id.edit_first)
        val myEditText2: EditText = findViewById(R.id.edit_second)

        val firstTil: TextInputLayout = findViewById(R.id.til_first)
        val secondTil: TextInputLayout = findViewById(R.id.til_second)

        val myButtonPlus: Button = findViewById(R.id.btn_plus)
        val myButtonMinus: Button = findViewById(R.id.btn_minus)
        val myButtonMultiply: Button = findViewById(R.id.btn_multiply)
        val myButtonDivide: Button = findViewById(R.id.btn_divide)

        val myButton: Button = findViewById(R.id.btn_submit)

        val myTextResult: TextView = findViewById(R.id.text_result)

        myEditText1.addTextChangedListener {
            firstTil.isErrorEnabled = false
            myButtonPlus.isEnabled = true

            if (it.toString().isEmpty()) {
                firstTil.error = "Minanı toltir"

                myButtonPlus.isEnabled = false
            }
        }
        myEditText2.addTextChangedListener {
            secondTil.isErrorEnabled = false
            myButtonPlus.isEnabled = true

            if (it.toString().isEmpty()) {

                secondTil.error = "Minanı toltir"

                myButtonPlus.isEnabled = false
            }
        }

        myButtonPlus.setOnClickListener {

            val first = myEditText1.text.toString()
            val second = myEditText2.text.toString()

            if (first.isNotEmpty() && second.isNotEmpty()) {
                val result = first.toInt() + second.toInt()
                myTextResult.text = getString(R.string.result_text, result.toString())
            } else {
                if (first.isEmpty()) {
                    firstTil.error = "Minanı toltır"
                }
                if (second.isEmpty()) {
                    secondTil.error = "Minanı toltır"
                }
            }


        }


        myButtonMinus.setOnClickListener {
            val first = myEditText1.text.toString()
            val second = myEditText2.text.toString()


            if (first.isNotEmpty() && second.isNotEmpty()) {
                val result = first.toInt() - second.toInt()
                myTextResult.text = getString(R.string.result_text, result.toString())
            }
        }
        myButtonMultiply.setOnClickListener {
            val first = myEditText1.text.toString()
            val second = myEditText2.text.toString()

            if (first.isNotEmpty() && second.isNotEmpty()) {
                val result = first.toInt() * second.toInt()
                myTextResult.text = getString(R.string.result_text, result.toString())
            }
        }

        myButtonDivide.setOnClickListener {
            val first = myEditText1.text.toString()
            val second = myEditText2.text.toString()

            if (first.isNotEmpty() && second.isNotEmpty()) {

                val result = first.toDouble() / second.toDouble()
                myTextResult.text = getString(R.string.result_text, result.toString())
                // "%.2f".format(result)
            }
        }
            myButton.setOnClickListener {
                val text = myTextResult.text.toString()
                sharedPreferences.edit().putString("myData", text).apply()
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
        }
    }
}