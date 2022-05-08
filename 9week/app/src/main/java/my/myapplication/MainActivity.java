package my.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MainFragment mainFragment;
    MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        menuFragment = new MenuFragment();
    }
    public void onFragmentChange(int i){
        if(i==0){
            getSupportFragmentManager().beginTransaction().replace(R.id.con,menuFragment).commit();
            //                            여러일을 한번에 처리함, 교체 ,                           실행해라
        }else if(i==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.con,mainFragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int curld = item.getItemId();
        switch (curld){
            case R.id.menu_refresh:
                Toast.makeText(MainActivity.this, "새로고침 메뉴가 선택되었습니다", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_search:
                Toast.makeText(MainActivity.this, "검색 메뉴가 선택되었습니다", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_settings:
                Toast.makeText(MainActivity.this, "설정가 선택되었습니다", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}