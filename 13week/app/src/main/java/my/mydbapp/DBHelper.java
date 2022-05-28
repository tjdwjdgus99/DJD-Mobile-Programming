package my.mydbapp;

import static java.sql.DriverManager.println;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    static final String DB_NAME = "employee.db";
    static final int VERSION = 1;
    static final String TABLE_NAME = "emp";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME , null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        println("onCreate 호출됨");
        String sql = "create table if not exists " + TABLE_NAME + "("+ " _id integer PRIMARY KEY autoincrement, " + " name text, " + " age integer, " + "mobile text)";
        println("테이블 생성함: " + TABLE_NAME);

        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (VERSION < i1){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS emp");
            onCreate(sqLiteDatabase);
        }
    }
}