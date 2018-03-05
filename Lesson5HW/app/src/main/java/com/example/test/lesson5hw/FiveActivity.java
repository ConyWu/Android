package com.example.test.lesson5hw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONObject;
import android.view.View.OnClickListener;
import android.widget.PopupMenu;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MenuItem;
import android.util.Log;
/**
 * Created by fengjen on 2018/2/14.
 */

public class FiveActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>{

    private EditText mWebInput;
    private TextView mContentText;
    private Button mBtn;
    private TextView mHeaderText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        mWebInput = (EditText)findViewById(R.id.editText);
        mContentText = (TextView)findViewById(R.id.MAINLABEL);
        mBtn = (Button) findViewById(R.id.button);
        mHeaderText = (TextView)findViewById(R.id.textView2);


        //Check if a Loader is running, if it is, reconnect to it
        if(getSupportLoaderManager().getLoader(0)!=null){
            getSupportLoaderManager().initLoader(0,null,this);
        }

        mBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchBooks(v);
            }
        });

        mHeaderText.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popupmenu = new PopupMenu(FiveActivity.this, mHeaderText);
//        popupmenu.inflate(R.menu.menu_demo1); // API 14以上才支援此方法.
                popupmenu.getMenuInflater().inflate(R.menu.menu, popupmenu.getMenu());
                popupmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // 設定popupmenu項目點擊傾聽者.

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {  // 項目被點擊後變更文字顏色.
                        // text的文字顏色變成選單項目所對應之顏色
                        mHeaderText.setText((String) item.getTitleCondensed());
                        return true;
                    }

                });
                popupmenu.show();

            }
        });
    }


    /**
     * Gets called when the user pushes the "Search Books" button
     *
     * @param view The view (Button) that was clicked.
     */
    public void searchBooks(View view) {
        // Get the search string from the input field.
        String queryString = mHeaderText.getText().toString() + mWebInput.getText().toString();
        Log.e("111111111", "queryString = " + queryString);

        // Hide the keyboard when the button is pushed.
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        // Check the status of the network connection.
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // If the network is active and the search field is not empty,
        // add the search term to the arguments Bundle and start the loader.
        if (networkInfo != null && networkInfo.isConnected() && queryString.length()!=0) {
            //mTitleText.setText(R.string.loading);
            Bundle queryBundle = new Bundle();
            queryBundle.putString("queryString", queryString);
            getSupportLoaderManager().restartLoader(0, queryBundle, this);
        }
        // Otherwise update the TextView to tell the user there is no connection or no search term.
        else {
            if (queryString.length() == 0) {
                mContentText.setText(R.string.no_search_term);
            } else {
                mContentText.setText(R.string.no_network);
            }
        }
    }

    /**
     * The LoaderManager calls this method when the loader is created.
     *
     * @param id ID integer to id   entify the instance of the loader.
     * @param args The bundle that contains the search parameter.
     * @return Returns a new BookLoader containing the search term.
     */
    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        return new ContentLoader(this, args.getString("queryString"));
    }

    /**
     * Called when the data has been loaded. Gets the desired information from
     * the JSON and updates the Views.
     *
     * @param loader The loader that has finished.
     * @param data The JSON response from the Books API.
     */
    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        try {


            // If both are found, display the result.
            if (data != null){
                mContentText.setText(data);
            } else {
                // If none are found, update the UI to show failed results.
                mContentText.setText(R.string.no_results);
            }

        } catch (Exception e){
            // If onPostExecute does not receive a proper JSON string, update the UI to show failed results.
            mContentText.setText(R.string.no_results);
            e.printStackTrace();
        }


    }

    /**
     * In this case there are no variables to clean up when the loader is reset.
     *
     * @param loader The loader that was reset.
     */
    @Override
    public void onLoaderReset(Loader<String> loader) {}
}