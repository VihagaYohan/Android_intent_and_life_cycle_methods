package com.techtribeservices.android_intent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var name: EditText;
    lateinit var age: EditText;
    lateinit var button: Button;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        name = findViewById(R.id.name)
        age = findViewById(R.id.number)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            // intent
            var userName: String = name.text.toString()
            var userAge: Int = age.text.toString().toInt()

            val intent = Intent(this@MainActivity,HomeActivity::class.java)
            intent.putExtra("userName", userName)
            intent.putExtra("age", userAge)
            startActivity(intent)
        }
    }
}