package my.day0720181476;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView = findViewById(R.id.IdPwdView);
        button = findViewById(R.id.btn_back);

        Intent intent = getIntent();
        String tvid = intent.getStringExtra("id");
        String tvpwd = intent.getStringExtra("pwd");

        Toast.makeText(LoginActivity.this,"id는"+tvid,Toast.LENGTH_SHORT).show();

        textView.setText("전달받은 아이디 : " + tvid +"\n" +"전달받은 비밀번호 : "+ tvpwd );

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(LoginActivity.this,MainActivity.class);
                intent1.putExtra("login","성공!!!!");
                setResult(RESULT_OK,intent1);
                finish();
            }
        });

    }
}