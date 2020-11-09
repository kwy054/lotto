package com.wiki10.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_name.*
import kotlinx.android.synthetic.main.activity_result.*
import kotlin.random.Random

class ResultActivity : AppCompatActivity() {

    //로또 1번공 이미지의 아이디 사용
    val lottoImageStartId=R.drawable.ball_01

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // 전달받은 결과배열을 가져온다
        val result = intent.getIntegerArrayListExtra("result")

        // 전달받은 결과가 있는경우에만 실행
        result?.let {
            // 결과에 맞게 로또공 이미지 업데이트
            // 결과 정렬
            updateLottoBallImage(result.sortedBy { it })
        }
    }

    /**
     * 결과에 따라 로또 공 이미지 업데이트
     */

    fun updateLottoBallImage(result: List<Int>){
        if(result.size<6) return

        imageView01.setImageResource(lottoImageStartId+(result[0]-1))
        imageView02.setImageResource(lottoImageStartId+(result[1]-1))
        imageView03.setImageResource(lottoImageStartId+(result[2]-1))
        imageView04.setImageResource(lottoImageStartId+(result[3]-1))
        imageView05.setImageResource(lottoImageStartId+(result[4]-1))
        imageView06.setImageResource(lottoImageStartId+(result[5]-1))
    }


}