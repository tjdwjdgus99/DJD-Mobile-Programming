package com.example.day0520181476;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    // 사랑과 희망 버튼 위젯 버튼 참조 변수
    Button btn1, btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn1 = findViewById(R.id.button3);
        btn2 = findViewById(R.id.button4);

        btn1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(MainActivity2.this, "LOVE", Toast.LENGTH_SHORT).show();
                //                      부모위치                텍스트         지속 시간
                return true;
            }
        });

        btn2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(MainActivity2.this, "Hope", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
    public void click(View v){
        Toast.makeText(MainActivity2.this,"클릭을 눌렀습니다",Toast.LENGTH_SHORT).show();
    }
}