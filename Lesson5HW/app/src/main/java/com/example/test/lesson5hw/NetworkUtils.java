package com.example.test.lesson5hw;

/**
 * Created by fengjen on 2018/2/14.
 */

import android.net.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


class NetworkUtils {

    // Class name for Log tag.
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();
    /**
     * Method for downloading book information from the Books API based on a search term.
     * This method makes a network call so it can not be called on the main thread.
     * @param queryString The search term for the Books API query
     * @return The raw response from the API as a JSON String
     */
    static String getContent(String queryString){

        // Set up variables for the try block that need to be closed in the finally block.
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resString = null;

        // Attempt to query the Books API.
        try {
            // Base URI for the Books API.


            // Build up your query URI, limiting results to 10 items and printed books.
            Uri builtURI = Uri.parse(queryString).buildUpon().build();

            URL requestURL = new URL(builtURI.toString());

            // Open the network connection.
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Get the InputStream.
            InputStream inputStream = urlConnection.getInputStream(); //entity

            // Read the response string into a StringBuilder.
            StringBuilder builder = new StringBuilder();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            //reader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) // Read line by line
                sb.append(line + "\n");

            resString = sb.toString(); // Result is here

            inputStream.close(); // Close the stream


            // Catch errors.
        } catch (IOException e) {
            e.printStackTrace();

            // Close the connections.
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        // Return the raw response.
        return resString;
    }
}
