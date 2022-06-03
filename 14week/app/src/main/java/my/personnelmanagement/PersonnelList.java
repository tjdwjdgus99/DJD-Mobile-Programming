package my.personnelmanagement;

import android.content.Intent;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PersonnelList extends AppCompatActivity implements OnClickListener {

    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnel_list);

        // 인물정보 레이아웃 인식
        LinearLayout layout = (LinearLayout)findViewById(R.id.personnel);

        try {
            dbHelper = new DBHelper(this);
            sqLiteDatebase = dbHelper.getReadableDatabase();

            Cursor cursor = sqLiteDatebase.query("personnel",null,null,null,null,null,null,null);

            int i = 0;
            while(cursor.moveToNext()){

                String str_name = cursor.getString(cursor.getColumnIndex("name"));
                String str_gender = cursor.getString(cursor.getColumnIndex("gender"));
                int age = cursor.getInt(cursor.getColumnIndex("age"));
                String str_tel = cursor.getString(cursor.getColumnIndex("tel"));

                LinearLayout layout_item = new LinearLayout(this);
                layout_item.setOrientation(LinearLayout.VERTICAL);
                layout_item.setPadding(20,10,20,10);
                layout_item.setId(i);
                layout_item.setTag(str_name);
                //  성명
                TextView tv_name = new TextView(this);
                tv_name.setText("성명 : " + str_name);
                tv_name.setTextSize(30);
                tv_name.setBackgroundColor(Color.argb(50,0,255,0));

                layout_item.addView(tv_name);
                //  성별
                TextView tv_gender = new TextView(this);
                tv_gender.setText("성별 : " + str_gender);

                layout_item.addView(tv_gender);
                //  나이
                TextView tv_age = new TextView(this);
                tv_age.setText("나이 : " + age);

                layout_item.addView(tv_age);
                //  전화번호
                TextView tv_tel = new TextView(this);
                tv_tel.setText("전화번호 : " + str_tel);

                layout_item.addView(tv_tel);

                layout_item.setOnClickListener(this);

                layout.addView(layout_item);

                i++;
            }

        } catch(SQLiteException e) {
            Toast.makeText(this,  e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        // 클릭한 목록 아이템 인식
        LinearLayout layout_item = (LinearLayout)findViewById(id);
        String str_name = (String)layout_item.getTag();

        // 인물정보 액티비티 호출
        Intent it = new Intent(this, PersonnelInfo.class);
        it.putExtra("it_name", str_name);
        startActivity(it);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 액션 바에 메뉴 아이템 추가
        getMenuInflater().inflate(R.menu.menu_personnel_list, menu);
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
        } else if (id == R.id.action_settings2) {
            Intent it = new Intent(this, PersonnelReg.class);
            startActivity(it);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
