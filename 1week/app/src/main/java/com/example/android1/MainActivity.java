package com.example.android1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button3;
    Button button4;
    CheckBox Check1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "버튼을 눌렀어요~",
                            Toast.LENGTH_SHORT).show();

            }
        });
        button3 = (Button) findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "버튼을 눌렀다고~",
                        Toast.LENGTH_SHORT).show();

            }
        });
        button4 = (Button) findViewById(R.id.button4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "버튼을 그만늘러~",
                        Toast.LENGTH_SHORT).show();

            }
        });

        Check1 = (CheckBox) findViewById(R.id.Check1);

        Check1.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });


    }
}