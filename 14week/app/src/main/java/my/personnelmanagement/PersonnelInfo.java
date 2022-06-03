package my.personnelmanagement;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PersonnelInfo extends AppCompatActivity {

    String str_name;
    String str_gender;
    int age;
    String str_tel;

    //  dbhelper 객체 생성
    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnel_info);


        // 인물정보 출력 뷰 인식
        TextView tv_name   = (TextView) findViewById(R.id.name);
        TextView tv_gender = (TextView) findViewById(R.id.gender);
        TextView tv_age  = (TextView) findViewById(R.id.age);
        TextView tv_tel  = (TextView) findViewById(R.id.tel);

        // 수신받은 성명 추출
        Intent it = getIntent();
        str_name = it.getStringExtra("name");

        // 테이블에서 해당 성명의 인물 추출
        try {
            dbHelper = new DBHelper(this);
            sqLiteDatebase = dbHelper.getReadableDatabase();
            String sql = "SELECT * FROM Personnel WHERE name =?";
            Cursor cursor = sqLiteDatebase.query("personnel",null,"name=?",new String[]{str_name},null,null,null);

            if(cursor != null){
                while (cursor.moveToNext()){
                    str_name = cursor.getString(cursor.getColumnIndex("name"));
                    str_gender = cursor.getString(cursor.getColumnIndex("gender"));
                    age = cursor.getInt(cursor.getColumnIndex("age"));
                    str_tel = cursor.getString(cursor.getColumnIndex("tel"));
                }
            }
        } catch(SQLiteException e) {
            Toast.makeText(this,  e.getMessage(), Toast.LENGTH_LONG).show();
        }

        // 추출한 데이터 출력
        // 성명
        tv_name.setText(str_name);
        // 성별
        tv_gender.setText(str_gender);
        // 나이
        tv_age.setText("" + age);
        // 전화번호
        tv_tel.setText(str_tel + "\n");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 액션 바에 메뉴 아이템 추가
        getMenuInflater().inflate(R.menu.menu_personnel_info, menu);
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
        } else if (id == R.id.action_settings2) {
            Intent it = new Intent(this, PersonnelReg.class);
            startActivity(it);
            finish();
            return true;
        } else if (id == R.id.action_settings4) {
            try {


            } catch(SQLiteException e) {
                Toast.makeText(this,  e.getMessage(), Toast.LENGTH_LONG).show();
            }

            Intent it = new Intent(this, PersonnelList.class);
            startActivity(it);
            finish();
        }


        return super.onOptionsItemSelected(item);
    }

}