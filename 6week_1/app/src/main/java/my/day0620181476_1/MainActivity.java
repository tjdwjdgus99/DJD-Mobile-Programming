package my.day0620181476_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    //요청코드 상수 선언
    public static final int REQUEST_CODE_MENU = 100;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setTitle("메인 엑티비티");

        Button button = findViewById(R.id.button);
        
        //메뉴화면 뛰우기 기능 구현
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                startActivityForResult(intent,REQUEST_CODE_MENU);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        //결과를 받아 처리하기 유효성 체크
        if(requestCode == REQUEST_CODE_MENU){
            Toast.makeText(getApplicationContext(),"요청한 코드 :" + requestCode + "요청한 결과: " + resultCode , Toast.LENGTH_SHORT).show();
        }
        if(data != null){
            String name = data.getStringExtra("name");
            int age = data.getIntExtra("age",0);
            Toast.makeText(getApplicationContext(),"전달된 데이터 이름 :" + name + ", 나이 :" + age + "입니다.",Toast.LENGTH_SHORT).show();
        }
    }
}