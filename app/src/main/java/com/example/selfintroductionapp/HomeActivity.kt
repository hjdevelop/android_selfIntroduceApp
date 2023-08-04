package com.example.selfintroductionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val buttonFinish = findViewById<Button>(R.id.homeButtonFinish)

        val strDataID = intent.getStringExtra("dataFromSignInActivity")
        val textViewID = findViewById<TextView>(R.id.homeTextViewID)

        textViewID.append(strDataID)

        buttonFinish.setOnClickListener {
            finish()
        }
    }
}