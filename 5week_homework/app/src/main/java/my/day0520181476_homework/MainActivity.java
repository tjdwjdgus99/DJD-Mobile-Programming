package my.day0520181476_homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edt1,edt2,edt3;
    Button btn,btn2,btn3,btn4;
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);

        String st1 = edt1.getText().toString();
        String st2 = edt2.getText().toString();

        int num1 = Integer.parseInt(st1);
        int num2 = Integer.parseInt(st2);

        //더하기가 눌리면
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                result = Integer.parseInt(st1)+Integer.parseInt(st2);
                edt3.setText("계산 결과 : "+ result.toString());
                return  false;
            }
        });
        btn2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                result = Integer.parseInt(st1)-Integer.parseInt(st2);
                edt3.setText("계산 결과 : "+ result.toString());
                return  false;
            }
        });
        btn3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                result = Integer.parseInt(st1)*Integer.parseInt(st2);
                edt3.setText("계산 결과 : "+ result.toString());
                return  false;
            }
        });
        btn4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                result = Integer.parseInt(st1)%Integer.parseInt(st2);
                edt3.setText("계산 결과 : "+ result.toString());
                return  false;
            }
        });
    }
}