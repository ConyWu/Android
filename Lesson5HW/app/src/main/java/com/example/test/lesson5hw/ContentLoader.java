package com.example.test.lesson5hw;

/**
 * Created by fengjen on 2018/2/14.
 */

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public class ContentLoader extends AsyncTaskLoader<String> {

    // Variable that stores the search string.
    private String mQueryString;


    // Constructor providing a reference to the search term.
    public ContentLoader(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }

    /**
     * This method is invoked by the LoaderManager whenever the loader is started
     */
    @Override
    protected void onStartLoading() {
        forceLoad(); // Starts the loadInBackground method
    }

    /**
     * Connects to the network and makes the Books API request on a background thread.
     *
     * @return Returns the raw JSON response from the API call.
     */
    @Override
    public String loadInBackground() {
        return NetworkUtils.getContent(mQueryString);
    }

}
