package com.example.test.lesson5hw;

/**
 * Created by fengjen on 2018/2/9.
 */
import android.os.AsyncTask;
import android.widget.TextView;
import java.util.Random;
import android.widget.ProgressBar;
import android.view.View;

class SimpleAsyncTask extends AsyncTask<Integer, Integer, String> {

    // The TextView where we will show results
    private TextView mTextView;

    private ProgressBar mProgressBar;

    // Constructor that provides a reference to the TextView from the MainActivity
    public SimpleAsyncTask(TextView tv, ProgressBar pb) {
        mTextView = tv;
        mProgressBar = pb;
        mProgressBar.setVisibility(View.VISIBLE);
        mProgressBar.setProgress(0);
    }

    /**
     * Runs on the background thread.
     *
     * @param voids No parameters in this use case.
     * @return Returns the string including the amount of time that
     * the background thread slept.
     */
    @Override
    protected String doInBackground(Integer... params) {

        // Generate a random number between 0 and 10
        Random r = new Random();
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running
        int s = n * 200;
        for (int count = 1; count <= params[0]; count++) {
            // Sleep for the random amount of time
            try {
                Thread.sleep(s/10);
                publishProgress(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Return a String result
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }



    /**
     * Does something with the result on the UI thread; in this case
     * updates the TextView.
     */
    protected void onPostExecute(String result) {
        mProgressBar.setVisibility(View.GONE);
        mTextView.setText(result);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        mProgressBar.setProgress(values[0]);
    }
}