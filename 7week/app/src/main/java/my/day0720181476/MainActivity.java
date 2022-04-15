package my.day0720181476;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText id,pwd;
    Button login,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.edt_id);
        pwd = findViewById(R.id.edt_pwd);
        login = findViewById(R.id.btn_login);
        cancel = findViewById(R.id.btn_cancel);

        // 버튼 클릭후 위, 값들을 인텐트의 부가 데이터 함수를 이용해 저장후 , 로그인 엔티비티로 전달
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 아이디와 비밀번호 입력값 가져오기
                String inputId = id.getText().toString();     
                String inputPwd = pwd.getText().toString();   
                //인텐트 객체 생성
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                intent.putExtra("id",inputId);
                intent.putExtra("pwd",inputPwd);
                startActivityForResult(intent,100);
            }
        });

    }
    //loginCancel버튼 이벤트 처리
    public void loginCancel(View view){
        //아이디 비밀번호 초기화
        id.setText("");
        pwd.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == RESULT_OK){
            String info = data.getStringExtra("login");

            Toast.makeText(MainActivity.this,info,Toast.LENGTH_SHORT).show();
        }
    }
}