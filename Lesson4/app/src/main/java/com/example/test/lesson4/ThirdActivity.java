package com.example.test.lesson4;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.MenuInflater;
import android.util.Log;

/**
 * Created by fengjen on 2018/2/5.
 */

public class ThirdActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        TextView article_text = (TextView) findViewById(R.id.article);
        registerForContextMenu(article_text);


    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo menuInfo) {
        //設定選單內容
        super.onCreateContextMenu(contextMenu, view, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, contextMenu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_edit:
                Log.v("[Lesson 4-2]", "[Click item] = " + item);
                return true;
            case R.id.context_share:
                Log.v("[Lesson 4-2]", "[Click item] = " + item);
                return true;
            case R.id.context_delete:
                Log.v("[Lesson 4-2]", "[Click item] = " + item);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

}