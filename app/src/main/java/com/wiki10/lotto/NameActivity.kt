package com.wiki10.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_name.*

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)



        // 로또 번호 확인 버튼의 클릭이벤트 리스너 설정
        goResultButton.setOnClickListener {
            //ResultActivity 시작하는 Intent 만들고 startActivity로 실행
            startActivity(Intent(this, ResultActivity::class.java))
        }

        // 뒤로가기 버튼의 클릭이벤트 리스너 설정
        backButton.setOnClickListener {
            //액티비티종료
            finish()
        }
    }
}