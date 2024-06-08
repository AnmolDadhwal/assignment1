package com.assig.assignment1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    var tvname: TextView?= null
    var name = ""
    var tvnumber: TextView?= null
    var number = ""
    var tvdob: TextView?= null
    var dob = ""
    var tvcollegename: TextView?= null
    var collegename = ""
    var back: Button?=null
    var study = ""
    var tvStudy : TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        intent?.extras?.let {
            name = it.getString("name") ?: ""
            number = it.getString("number") ?: ""
            dob = it.getString("birthdate")?:""
            collegename= it.getString("collegeName")?:""
            study = it.getString("study")?:""
            println("name $name number $number birthdate $dob collegename $collegename")
        }
        tvname= findViewById(R.id.name)
        tvname?.setText(name)
        tvnumber = findViewById(R.id.number)
        tvnumber?.setText(number)
        tvdob = findViewById(R.id.dob)
        tvdob?.setText(dob)
        tvcollegename = findViewById(R.id.collegename)
        tvcollegename?.setText(collegename)
        back= findViewById(R.id.back)
        tvStudy= findViewById(R.id.study)
        tvStudy?.text = study
        if(collegename == ""){
            tvcollegename?.visibility = View.GONE
        }else{
            tvcollegename?.visibility = View.VISIBLE
            tvcollegename?.setText(collegename)
        }
        back?.setOnClickListener {
            this.finish()
        }
    }
}