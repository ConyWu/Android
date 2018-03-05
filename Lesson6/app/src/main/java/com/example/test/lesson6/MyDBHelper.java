package com.example.test.lesson6;

/**
 * Created by fengjen on 2018/2/12.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.content.ContentValues;
import android.database.Cursor;

import static android.provider.BaseColumns._ID;


public class MyDBHelper extends SQLiteOpenHelper {


    public static final String TABLE_NAME = "tasks";  //表格名稱
    public static final String TASK = "task";
    public static final String CREATE_DATE  = "create_date";
    public static final String COMPLETE_DATE = "complete_date";
    public static final String HAS_COMPLETED = "has_completed";
    private static final String KEY_ID = "id";

    // 資料庫名稱
    public static final String DATABASE_NAME = "mydata.db";
    // 資料庫版本，資料結構改變的時候要更改這個數字，通常是加一
    public static final int VERSION = 1;
    // 資料庫物件，固定的欄位變數
    private static SQLiteDatabase database;


    // 建構子，在一般的應用都不需要修改
    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        Log.v("[Lesson 6]", "MyDBHelper");
    }

    // 需要資料庫的元件呼叫這個方法，這個方法在一般的應用都不需要修改
    public static SQLiteDatabase getDatabase(Context context) {
        if (database == null || !database.isOpen()) {
            database = new MyDBHelper(context).getWritableDatabase();
        }

        return database;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 建立應用程式需要的表格
        //final String INIT_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TASK + " CHAR, " + CREATE_DATE + " DATETIME, " + COMPLETE_DATE + " DATETIME, " + HAS_COMPLETED + " BOOLEAN);";
        Log.v("[Lesson 6]", "onCreate");
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + TASK + " TEXT,"
                + CREATE_DATE + " TEXT," + COMPLETE_DATE + " TEXT," + HAS_COMPLETED + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
        Log.v("[Lesson 6]", "onCreate --");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 刪除原有的表格
        final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(DROP_TABLE);
        // 呼叫onCreate建立新版的表格
        onCreate(db);
    }

    public void addItem(String task, String create_date, String completed_date) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(MyDBHelper.TASK, task);
        cv.put(MyDBHelper.CREATE_DATE, create_date);
        cv.put(MyDBHelper.COMPLETE_DATE, completed_date);
        cv.put(MyDBHelper.HAS_COMPLETED, "No");
        long check = db.insert(TABLE_NAME, null, cv);

        db.close(); // Closing database connection
    }

    public Cursor getItem(String[] projectionIn, String selection, String[] selectionArgs) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, projectionIn, selection, selectionArgs, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        //for (int i = 0; i <cursor.getCount(); i++)
        //    Log.i("1111111", cursor.getString(0) +" " + cursor.getString(1));

        //Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
        //        cursor.getString(1), cursor.getString(2));
        // return contact
        return cursor;
    }

}