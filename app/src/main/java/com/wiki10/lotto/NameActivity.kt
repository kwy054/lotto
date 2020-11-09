package com.wiki10.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_name.*
import kotlin.random.Random

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        /**
         * 입력받은 이름에 대한 해시코드를 사용하여 로또번호를 섞고 결과를 반환한다         *
         */
        fun getLottoNumbersFromHash(name: String): MutableList<Int>{
            //1~45 번에 로또 번호를 저장할 리스트 생성
            val list = mutableListOf<Int>()

            //1~45까지 for문을 돌면서 리스트에 로또번호 저장
            for (number in 1..45){
                list.add(number)
            }

            // 리스트 무작위로 섞음. 섞는 기준으로 Random(SEED) 사용
            // SEED값은 전달받은 이름의 해시코드를 사용
            list.shuffle(Random(name.hashCode().toLong()))

            //리스트를 앞에서부터 순서대로 6개 잘라 결과 반환
            return list.subList(0, 6)
        }

        //번호 생성 버튼의 크릭리벤트 리스너 설정
        goResultButton.setOnClickListener {
            //ResultActivity를 시작하는 Intet 생성 !!!505페이지에는 goButton임
            val intent = Intent(this, ResultActivity::class.java)
            //intent 결과 데이터 전달
            intent.putIntegerArrayListExtra("result", ArrayList(getLottoNumbersFromHash(editText.text.toString())))

            //ResultActivity를 시작하는 Intent 만들고 startActivity로 실행
            startActivity(intent)

            //여기까지 잘라내기 붙여넣기 전

        }
        // 뒤로가기 버튼의 클릭이벤트 리스너 설정
        backButton.setOnClickListener {
            //액티비티종료
            finish()
        }
    }
}