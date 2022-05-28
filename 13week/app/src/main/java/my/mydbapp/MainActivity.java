package my.mydbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    TextView textView;

    SQLiteDatabase database;
    String tableName;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                createDatabase(name);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableName = editText2.getText().toString();
                createTable(tableName);

                insertRecord();
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executeQuary();
            }
        });
    }



    // DB 생성 메소드
    private void createDatabase(String name) {
        println("createDatabase 호출됨");
        dbHelper = new DBHelper(this);//시험 나오는 부분
        database = dbHelper.getWritableDatabase();//시험 나오는 부분
        //database = openOrCreateDatabase(name,MODE_PRIVATE,null);
        println("데이터베이스 생성함 " + name);
    }


    // 테이블 생성 메소드
    private void createTable(String name) {
        println("createTable 호출됨");
        if (database == null){
            println("데이터베이스를 먼저 생성해라 ");
            return;
        }else{
            database.execSQL("create table if not exists " + name + "("+ " _id integer PRIMARY KEY autoincrement, " + " name text, " + " age integer, " + "mobile text)");
            println("테이블 생성함: " + name);
        }

    }



    // 레코드 추가 메소드
    private void insertRecord() {
        println("insertRecord 호출됨");
        if (database == null) {
            println("데이터베이스를 먼저 생성하세요 ");
            return;
        }
        if (tableName == null) {
            println("테이블을 먼저 ");
            return;
        }
        database.execSQL("insert into " + tableName + "(name, age, mobile)" + " values " + "('John' , 20,'010-1000-1000')");
        println("레코드 추가함");
    }



    // 텍스트 뷰에 데이타 출력
    public void println(String data) {
        textView.append(data + "\n");
    }

    // 조회 메소드
    public void executeQuary(){

        println("executeQuary 함수 호출");
        String sql = "Select _id, name, age, mobile from " + tableName;//Select * 도 가능
        Cursor cursor = database.rawQuery(sql,null);
        int recordCount = cursor.getCount();

        int i = 0;

        while (cursor.moveToNext()){//cursor가 올때까지 반복 //for (int i = 0; i < recordCount; i++){


            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            String mobile = cursor.getString(3);

            i++;
            println("레코드# " + i + ":" + id + ","+ name + ","+ age + ","+ mobile);

        }
        cursor.close();

    }


}