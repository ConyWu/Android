package com.example.test.lesson6;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import android.widget.ArrayAdapter;
import android.util.Log;
import java.util.HashMap;
import android.widget.EditText;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import android.database.Cursor;

import static com.example.test.lesson6.Constants.TASK_COLUMN;
import static com.example.test.lesson6.Constants.CREATE_DATE_COLUMN;
import static com.example.test.lesson6.Constants.COMPLETED_DATE_COLUMN;
import static com.example.test.lesson6.Constants.HAS_COMPLETED_COLUMN;

public class MainActivity extends AppCompatActivity {

    private MyDBHelper dbhelper;

    private Button btn1;
    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;
    private ArrayList<HashMap<String, String>> list;
    private ListViewAdapter adapter;
    private ListView listView;
    private boolean mEditMode;
    //SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbhelper = new MyDBHelper(this);
        //db = dbhelper.getWritableDatabase();
        listView=(ListView)findViewById(R.id.listView1);

        list=new ArrayList<HashMap<String,String>>();

        String[] projectionIn = { MyDBHelper.TASK, MyDBHelper.CREATE_DATE, MyDBHelper.COMPLETE_DATE };
        String selection = MyDBHelper.HAS_COMPLETED + "=?";
        String[] selectionArgs = new String[]{"No"};
        Cursor cursor = dbhelper.getItem(projectionIn, selection, selectionArgs);
        if (cursor != null) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                String id = cursor.getString(0);    //取得第0欄的資料，根據欄位type使用適當語法
                String name = cursor.getString(1);
                String value = cursor.getString(2);
                Log.i("33333", "id = " + id + " name = " + name + " value = " + value);
                cursor.moveToNext();        //將指標移至下一筆資料
            }
        }

/*
        HashMap<String,String> temp=new HashMap<String, String>();
        temp.put(TASK_COLUMN, "Ankit Karia");
        temp.put(CREATE_DATE_COLUMN, "Male");
        temp.put(COMPLETED_DATE_COLUMN, "22");
        temp.put(HAS_COMPLETED_COLUMN, "Unmarried");
        list.add(temp);

        HashMap<String,String> temp2=new HashMap<String, String>();
        temp2.put(TASK_COLUMN, "Rajat Ghai");
        temp2.put(CREATE_DATE_COLUMN, "Male");
        temp2.put(COMPLETED_DATE_COLUMN, "25");
        temp2.put(HAS_COMPLETED_COLUMN, "Unmarried");
        list.add(temp2);

        HashMap<String,String> temp3=new HashMap<String, String>();
        temp3.put(TASK_COLUMN, "Karina Kaif");
        temp3.put(CREATE_DATE_COLUMN, "Female");
        temp3.put(COMPLETED_DATE_COLUMN, "31");
        temp3.put(HAS_COMPLETED_COLUMN, "Unmarried");
        list.add(temp3);
*/
        adapter=new ListViewAdapter(this, list);
        listView.setAdapter(adapter);

        btn1 = (Button) findViewById(R.id.button1);

        btn1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText task_text = (EditText)findViewById(R.id.editText1);
                String task = task_text.getText().toString();

                EditText completed_date_text = (EditText)findViewById(R.id.editText2);
                String completed_date = completed_date_text.getText().toString();

                addItem(task, completed_date);
            }
        });

        initListeners();
/*
        listView.setOnItemClickListener(new OnItemClickListener(){
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                Object position_ID = adapter.getItem(position);//.getItemName().toString();
                //String temp = adapter.getItem(position).getItemName().toString();
                //String changedName = "Thomas";
                //adapter.getItem(position).setItemName(changedName);
                Toast.makeText(listView.getContext(), "position = " + position_ID + " ffff = " + view,
                        Toast.LENGTH_LONG).show();
            }

        });

*/
    }


    public boolean getEditMode()
    {
        return mEditMode;
    }

    public void setEditMode(boolean mEditMode)
    {
        this.mEditMode = mEditMode;
    }

    private void initListeners()
    {
        /*
        listView.setOnItemClickListener(new ListView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                //Toast.makeText(getApplicationContext(), "默认模式", Toast.LENGTH_SHORT).show();
            }

        });
        */
        listView.setOnItemClickListener(new ListView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                /*
                boolean mEditMode = getEditMode();
                if(!mEditMode)
                {
                    setEditMode(true);
                    Toast.makeText(getApplicationContext(), "进入编辑模式", Toast.LENGTH_SHORT).show();
                    //mTitleName.setText("编辑模式");
                }else{
                    Toast.makeText(getApplicationContext(), "编辑 "+position, Toast.LENGTH_SHORT).show();
                }*/
                //return false;
            }

        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.completed:
                Toast.makeText(this, "You have selected Bookmark Menu", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.incompleted:
                Toast.makeText(this, "You have selected Save Menu", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    public void addItem(String task, String completed_date) {

        DateFormat df = new SimpleDateFormat("yyyy.MM.dd");//("EEE, d MMM yyyy, HH:mm");
        String create_date = df.format(Calendar.getInstance().getTime());

        HashMap<String,String> temp = new HashMap<String, String>();
        temp.put(TASK_COLUMN, task);
        temp.put(CREATE_DATE_COLUMN, create_date);
        temp.put(COMPLETED_DATE_COLUMN, completed_date);
        temp.put(HAS_COMPLETED_COLUMN, "Unmarried");
        list.add(temp);
        adapter.addItem(list);
        listView.setAdapter(adapter);

        dbhelper.addItem(task, create_date, completed_date);
        //dbhelper.addItem
    }

    public void loadItem(){

    }
}
