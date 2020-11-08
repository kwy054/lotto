package com.wiki10.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 랜덤으로 번호 생성 카드의 클릭 리스너
        randomCard.setOnClickListener {
            //ResultActivity 시작하는 Intent 만들고 startActivity 로 실행
            startActivity(Intent(this, ResultActivity::class.java))
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

        /**
         * 랜덤으로 1~45 번호중 하나의 번호 생성
         */
        fun getRandomLottoNumber(): Int {
            // Random.nextInt는 0~전달받은파라미터 값 미만의 번호 생성
            return Random().nextInt(45) + 1
        }

        /**
         * 랜덤으로 추출하여 6개의 로또번호를 만드는 함수
         */
        fun getRandomLottoNumbers(): MutableList<Int> {
            // 무작위로 생성된 로또 번호를 저장할 가변 리스트 생성
            val lottoNumbers = mutableListOf<Int>()

            //6번반복문
            for (i in 1..6) {
                //리스트에 무작위로 생성된 번호 추가
                lottoNumbers.add(getRandomLottoNumber())
            }
            return lottoNumbers
        }

        // 랜덤으로 번호 생성 카드의 클릭 이벤트 리스너
        randomCard.setOnClickListener {

            //ResultActivity를 시작하는 Intent 생성
            val intent = Intent(this, ResultActivity::class.java)

            //intent 결과 데이터 전달
            intent.putIntegerArrayListExtra("result", ArrayList(getRandomLottoNumbers()))

            //ResultActivity 시작하는 Intent 만들고 startActivity로 실행
            startActivity(intent)
        }

    }
}