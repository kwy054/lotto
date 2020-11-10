package com.wiki10.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.akj.lotto.LottoNumberMaker
import kotlinx.android.synthetic.main.activity_name.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        //번호 생성 버튼의 크릭리벤트 리스너 설정
        goResultButton.setOnClickListener {
            //입력된 이름이 없으면 토스트메세지 출력후 리턴
            if(TextUtils.isEmpty(editText.text.toString())) {
                Toast.makeText(applicationContext, "이름을 입력하세요", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            //ResultActivity를 시작하는 Intet 생성 !!!
            val intent = Intent(this, ResultActivity::class.java)

            //intent 결과 데이터 전달
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash(editText.text.toString())))

            //입력받은 이름을 추가로 전달
            intent.putExtra("name", editText.text.toString())

            //ResultActivity를 시작하는 Intent 만들고 startActivity로 실행
            startActivity(intent)
        }
        // 뒤로가기 버튼의 클릭이벤트 리스너 설정
        backButton.setOnClickListener {
            //액티비티종료
            finish()
        }
    }
}