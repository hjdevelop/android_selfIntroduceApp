package com.example.selfintroductionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    lateinit var editTextID : EditText
    lateinit var editTextPwd : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSignIn = findViewById<Button>(R.id.signInSignInButton)
        val btnSignUp = findViewById<Button>(R.id.signInSignUpButton)

        editTextID = findViewById<EditText>(R.id.signInEditTextID)
        editTextPwd = findViewById<EditText>(R.id.signInEditTextPwd)

        setResultNext()

        btnSignIn.setOnClickListener {
            val strDataID = editTextID.text.toString().trim()
            val strDataPwd = editTextPwd.text.toString().trim()

            if (strDataID.isNullOrEmpty() || strDataPwd.isNullOrEmpty()) {
                Toast.makeText(this,"아이디 또는 비밀번호를 입력해 주세요.", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this,"로그인 성공", Toast.LENGTH_LONG).show()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("dataFromSignInActivity", strDataID)
                startActivity(intent)
            }
        }
        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }
    }
    private fun setResultNext(){
        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){ result ->
            // 서브 액티비티로부터 돌아올 때의 결과 값을 받아 올 수 있는 구문
            if (result.resultCode == RESULT_OK){
                val ID = result.data?.getStringExtra("IDFromSignUpActivity") ?: ""
                val Password = result.data?.getStringExtra("PwdFromSignUpActivity") ?: ""

                editTextID.setText(ID)
                editTextPwd.setText(Password)
            }
        }
    }
}