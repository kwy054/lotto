package com.wiki10.lotto

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_test.*


class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        // 코드에서 View에 이벤트 리스너를 설정하는 방법
        // 코틀린에서는 Android Extension 덕분에 FindViewById 없이 바로 접근 가능
        // 버튼과 같은 View가 클릭되었을때 실행 될 listener를 등록하는 메소드가 setOnClickListener 다
        button.setOnClickListener {
            val intent = Intent(this@TestActivity, MainActivity::class.java)
            // intent를 사용하여 Activity를 시작한다
            startActivity(intent)
        }

        // CONSTELLATION ACTION 버튼을 누른 경우 동작하는 이벤트 리스너를 등록한다
        button2.setOnClickListener {
            val intent = Intent(this@TestActivity, ConstellationActivity::class.java)
            // intent를 사용하여 Activity를 시작한다
            startActivity(intent)
        }

        // NAME ACTION 버튼을 누른 경우 동작하는 이벤트 리스너를 등록한다
        button3.setOnClickListener {
            val intent = Intent(this@TestActivity, NameActivity::class.java)
            // intent를 사용하여 Activity를 시작한다
            startActivity(intent)
        }

        // RESULT ACTION 버튼을 누른 경우 동작하는 이벤트 리스너를 등록한다
        button4.setOnClickListener {
            val intent = Intent(this@TestActivity, ResultActivity::class.java)
            // intent를 사용하여 Activity를 시작한다
            startActivity(intent)
        }
    }

    /**
     * xml에서 참조할 수 있게 메소드를 정의한다
     */
    fun goConstellation(view: View) {
        //ConstellationActivity로 화면전환 하는 코드
        val intent= Intent(this@TestActivity, ConstellationActivity::class.java)
        startActivity(intent)
    }

    fun callweb(view: View){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"))
        startActivity(intent)
    }

}