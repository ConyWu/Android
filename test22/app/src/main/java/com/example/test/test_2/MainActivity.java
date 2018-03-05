package com.example.test.test_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private String[] sources = {
            "http://lorempixel.com/600/250/",
            "http://lorempixel.com/600/250/sports",
            "http://lorempixel.com/600/200/sports/Dummy-Text",
            "http://lorempixel.com/600/200/nature",
            "http://lorempixel.com/600/200/food",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // this is data fro recycler view
        ItemData[] itemsData = {
                new ItemData("Delete",sources[0]),
                new ItemData("Cloud",sources[1]),
                new ItemData("Favorite",sources[2]),
                new ItemData("Like",sources[3]),
                new ItemData("Rating",sources[4]),
                new ItemData("Delete",sources[0]),
                new ItemData("Cloud",sources[1]),
                new ItemData("Favorite",sources[2]),
                new ItemData("Like",sources[3]),
                new ItemData("Rating",sources[4])
        };


        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 3. create an adapter
        MyAdapter mAdapter = new MyAdapter(itemsData);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
