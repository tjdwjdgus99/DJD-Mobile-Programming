package my.day0620181476_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle("매뉴 엑티비티");

        //돌아가기 기능 구현

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //인텐트 객체 생성하기
                Intent intent = new Intent();
                //부가 데이터 추가
                intent.putExtra("name","JeongHyeon");//인텐트에 넣기
                intent.putExtra("age",24);
                setResult(RESULT_OK,intent);//응답 보내기
                finish();
            }
        });

    }
}