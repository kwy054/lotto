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
                // 임시저장변수
                var number = 0
                do {
                    //랜덤한 번호 추출해 number 변수에 저장
                    number = getRandomLottoNumber()

                    //lottoNumbers에 number 변수의 값이 없을때까지 반복
                } while (lottoNumbers.contains(number))

                //중복 없을때까지 돌린상테
                lottoNumbers.add(number)
            }
            return lottoNumbers
        }

        /**
         * Shuffle을 사용해 로또번호 생성
         */
        fun getShuffleLottoNumbers():MutableList<Int> {
            //1~45번에 로도 번호 저장할 리스트 생성
            val list = mutableListOf<Int>()
            //1~45까지 for문 돌면서 리스트레 로또번호 저장
            for(number in 1..45){
                list.add(number)
            }

            //리스트 무작위로 섞음
            list.shuffle()

            // 리스트를 앞에서부터 순서대로 6개 잘라 리턴
            return list.subList(0, 6)
        }

        // 랜덤으로 번호 생성 카드의 클릭 이벤트 리스너
        randomCard.setOnClickListener {

            //ResultActivity를 시작하는 Intent 생성
            val intent = Intent(this, ResultActivity::class.java)

            //intent 결과 데이터 전달
            intent.putIntegerArrayListExtra("result", ArrayList(getShuffleLottoNumbers()))

            //ResultActivity 시작하는 Intent 만들고 startActivity로 실행
            startActivity(intent)
        }



    }
}