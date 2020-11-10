package com.wiki10.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.akj.lotto.LottoNumberMaker
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 랜덤으로 번호 생성 카드의 클릭 리스너
        randomCard.setOnClickListener {
            //ResultActivity 시작하는 Intent 만들고 startActivity 로 실행
            val intent = Intent(this, ResultActivity::class.java)

            //intent 결과 데이터 전달
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getShuffleLottoNumbers()))

            //ResultActivity를 시작하는 Intent 만들고 startActivity 실행
            startActivity(intent)
        }

        // 별자리으로 번호 생성 카드의 클릭 리스너
        constellationCard.setOnClickListener {
            //ConstellationActivity 시작하는 Intent 만들고 startActivity 로 실행
            startActivity(Intent(this, ConstellationActivity::class.java))
        }

        // 이름으로 번호 생성 카드의 클릭 리스너
        nameCard.setOnClickListener {
            //NameActivity 시작하는 Intent 만들고 startActivity 로 실행
            startActivity(Intent(this, NameActivity::class.java))
        }
    }
}