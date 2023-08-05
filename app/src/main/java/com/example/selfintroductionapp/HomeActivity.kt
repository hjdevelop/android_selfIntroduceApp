package com.example.selfintroductionapp

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val buttonFinish = findViewById<Button>(R.id.homeButtonFinish)
        val imgViewProfile = findViewById<ImageView>(R.id.homeImageView)

        val strDataID = intent.getStringExtra("dataFromSignInActivity")
        val ranNum = intent.getIntExtra("intFromSignInActivity", 0)

        val textViewID = findViewById<TextView>(R.id.homeTextViewID)    //부분 Bold 처리를 위한 텍스트뷰 연동
        val textViewName = findViewById<TextView>(R.id.homeTextViewName)
        val textViewAge = findViewById<TextView>(R.id.homeTextViewAge)
        val textViewMBTI = findViewById<TextView>(R.id.homeTextViewMBTI)
        val textViewGreet = findViewById<TextView>(R.id.homeTextViewGreet)

        val IDData: String = textViewID.text.toString() //텍스트뷰 문자열 변환 후 대입
        val nameData: String = textViewName.text.toString()
        val ageData: String = textViewAge.text.toString()
        val MBTIData: String = textViewMBTI.text.toString()
        val greetData: String = textViewGreet.text.toString()

        val IDBuilder = SpannableStringBuilder(IDData)  //변환된 문자열 SpannableStringBuilder로 변환
        val nameBuilder = SpannableStringBuilder(nameData)
        val ageBuilder = SpannableStringBuilder(ageData)
        val MBTIBuilder = SpannableStringBuilder(MBTIData)
        val greetBuilder = SpannableStringBuilder(greetData)

        val boldSpan = StyleSpan(Typeface.BOLD) //Span객체 생성 및 적용

        IDBuilder.setSpan(boldSpan, 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE) //해당 범위의 문자열에 Bold체 적용
        nameBuilder.setSpan(boldSpan, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ageBuilder.setSpan(boldSpan, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        MBTIBuilder.setSpan(boldSpan, 0, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        greetBuilder.setSpan(boldSpan, 0, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        textViewID.text = IDBuilder //부분 Bold변환된 것을 다시 텍스트뷰에 적용
        textViewName.text = nameBuilder
        textViewAge.text = ageBuilder
        textViewMBTI.text = MBTIBuilder
        textViewGreet.text = greetBuilder

        textViewID.append(strDataID)

        when (ranNum) { //0~4 중 랜덤한 숫자를 받고 해당 숫자에 대응하는 이미지뷰 출력
            0 -> imgViewProfile.setImageResource(R.drawable.profile1)
            1 -> imgViewProfile.setImageResource(R.drawable.profile2)
            2 -> imgViewProfile.setImageResource(R.drawable.profile3)
            3 -> imgViewProfile.setImageResource(R.drawable.profile4)
            4 -> imgViewProfile.setImageResource(R.drawable.profile5)
        }

        buttonFinish.setOnClickListener {
            finish()
        }
    }
}