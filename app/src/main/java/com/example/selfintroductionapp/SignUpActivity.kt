package com.example.selfintroductionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btnSignUp = findViewById<Button>(R.id.signUpSignUpButton)

        val editTextName = findViewById<EditText>(R.id.signUpEditTextName)
        val editTextID = findViewById<EditText>(R.id.signUpEditTextID)
        val editTextPwd = findViewById<EditText>(R.id.signUpEditTextPwd)

        btnSignUp.setOnClickListener {
            val strDataName = editTextName.text.toString().trim()
            val strDataID = editTextID.text.toString().trim()
            val strDataPwd = editTextPwd.text.toString().trim()

            if(strDataName.isNullOrEmpty() || strDataID.isNullOrEmpty() || strDataPwd.isNullOrEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_LONG).show()
            }
            else {
                intent.putExtra("IDFromSignUpActivity", strDataID)
                intent.putExtra("PwdFromSignUpActivity", strDataPwd)
                setResult(RESULT_OK,intent)
                finish()
            }
        }
    }
}