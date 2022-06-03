package my.personnelmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String id ="hong", password="123445";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public void onClick(View v) {
        login(id, password);
    }

    private void login(String id, String password){

    }


    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 액션 바에 메뉴 아이템 추가
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 클릭한 목록 아이템 ID
        int id = item.getItemId();

        // 클릭한 목록 아이템 ID별 이동할 액티비티
        if (id == R.id.action_settings) { //홈
            Intent it = new Intent(this, MainActivity.class);
            startActivity(it);
            finish();
            return true;
        } else if (id == R.id.action_settings1) { //인물목록
            Intent it = new Intent(this, PersonnelList.class);
            startActivity(it);
            finish();
            return true;
        } else if (id == R.id.action_settings2) { //인물등록
            Intent it = new Intent(this, PersonnelReg.class);
            startActivity(it);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
