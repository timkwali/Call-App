package com.example.callapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val callButton = findViewById<Button>(R.id.btCall)

        callButton.setOnClickListener {
            val phoneNumber = findViewById<EditText>(R.id.etNumbers).text
            if(phoneNumber.isBlank()) {
                Toast.makeText(this, "Please enter a phone number", Toast.LENGTH_SHORT).show()
            } else {
                var intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("num:$phoneNumber")
                startActivity(intent)
            }
        }
    }
}