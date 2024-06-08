package com.assig.assignment1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var name: EditText?=null
    var number: EditText?= null
    var birthdate: EditText?=null
    var collegename: EditText?=null
    var yes: RadioButton?= null
    var no: RadioButton?=null
    var check: Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        name=findViewById(R.id.name)
        number=findViewById(R.id.number)
        birthdate=findViewById(R.id.birthdate)
        collegename=findViewById(R.id.collegename)
        yes=findViewById(R.id.yes)
        no=findViewById(R.id.no)
        check=findViewById(R.id.check)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        yes?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                collegename?.visibility = View.VISIBLE
            } else {
                collegename?.visibility = View.GONE
            }
        }
        check?.setOnClickListener {
            if(name?.text?.trim().isNullOrEmpty()){
                name?.error="Enter The Name"
            }else if (number?.text?.trim().isNullOrEmpty()){
                number?.error="Enter The Number"
            } else if((number?.text?.trim()?.length?:0) <10){
                number?.error = "Number should be valid"
            } else if(birthdate?.text?.trim().isNullOrEmpty()){
                birthdate?.error="Enter The Birth Date"
            }else if (collegename?.text?.trim().isNullOrEmpty()){
                collegename?.error="Enter The College name"
            } else {
                var intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("name", name?.text?.toString()?.trim())
                intent.putExtra("number",number?.text?.toString()?.trim())
                intent.putExtra("birthdate",birthdate?.text?.toString()?.trim()?.toInt())
                startActivity(intent)
            }
        }
    }
}