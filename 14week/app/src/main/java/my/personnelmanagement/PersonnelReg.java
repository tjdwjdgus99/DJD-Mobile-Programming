package my.personnelmanagement;


import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PersonnelReg extends AppCompatActivity {

    //  dbhelper 객체 생성
    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnel_reg);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 액션 바에 메뉴 아이템 추가
        getMenuInflater().inflate(R.menu.menu_personnel_reg, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 클릭한 목록 아이템 ID
        int id = item.getItemId();

        // 클릭한 목록 아이템 ID별 이동할 액티비티
        if (id == R.id.action_settings) {
            Intent it = new Intent(this, MainActivity.class);
            startActivity(it);
            finish();
            return true;
        } else if (id == R.id.action_settings1) {
            Intent it = new Intent(this, PersonnelList.class);
            startActivity(it);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // '등록' 버튼 클릭 시
    public void register(View v) {
        // 1. 입력한 인물정보 추출
        // 성명
        EditText et_name = (EditText)findViewById(R.id.name);
        String str_name = et_name.getText().toString();

        // 성별
        RadioGroup rg_gender = (RadioGroup)findViewById(R.id.gender);
        RadioButton rb_gender;
        String str_gender = "";
        if (rg_gender.getCheckedRadioButtonId() == R.id.male) {
            rb_gender = (RadioButton)findViewById(R.id.male);
            str_gender = rb_gender.getText().toString();
        }
        if (rg_gender.getCheckedRadioButtonId() == R.id.female) {
            rb_gender = (RadioButton)findViewById(R.id.female);
            str_gender = rb_gender.getText().toString();
        }

        // 나이
        EditText et_age = (EditText)findViewById(R.id.age);
        String str_age = et_age.getText().toString();

        // 전화번호
        EditText et_tel = (EditText)findViewById(R.id.tel);
        String str_tel = et_tel.getText().toString();

        // 2. 테이블에 인물정보 추가
        try {
            dbHelper = new DBHelper(this);
            sqLiteDatebase = dbHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name",str_name);
            contentValues.put("gender",str_gender);
            contentValues.put("age",str_age);
            contentValues.put("tel",str_tel);
            
            long result = sqLiteDatebase.insert("Personnel",null,contentValues);
            /*if(result != -1){
                Toast.makeText(getApplicationContext(),"등록 실패!", Toast.LENGTH_LONG);
            }else{
                Toast.makeText(getApplicationContext(),"등록 성공!", Toast.LENGTH_LONG);
            }*/
            sqLiteDatebase.close();

            Intent intent = new Intent(getApplicationContext(),PersonnelInfo.class);
            intent.putExtra("name", str_name);
            startActivity(intent);

        } catch(SQLiteException e) {
            Toast.makeText(this,  e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}