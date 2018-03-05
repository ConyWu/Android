package com.example.test.lesson6;

/**
 * Created by fengjen on 2018/2/13.
 */

import static com.example.test.lesson6.Constants.TASK_COLUMN;
import static com.example.test.lesson6.Constants.CREATE_DATE_COLUMN;
import static com.example.test.lesson6.Constants.COMPLETED_DATE_COLUMN;
import static com.example.test.lesson6.Constants.HAS_COMPLETED_COLUMN;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter{

    public ArrayList<HashMap<String, String>> list;
    Activity activity;
    TextView txtTask;
    TextView txtCreateDate;
    TextView txtCompletedDate;
    TextView txtHasCompleted;
    public ListViewAdapter(Activity activity,ArrayList<HashMap<String, String>> list){
        super();
        this.activity=activity;
        this.list=list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub



        LayoutInflater inflater=activity.getLayoutInflater();

        if(convertView == null){

            convertView=inflater.inflate(R.layout.simplerow, null);

            txtTask=(TextView) convertView.findViewById(R.id.task);
            txtCreateDate=(TextView) convertView.findViewById(R.id.create_date);
            txtCompletedDate=(TextView) convertView.findViewById(R.id.completed_date);
            txtHasCompleted=(TextView) convertView.findViewById(R.id.has_completed);

        }

        HashMap<String, String> map=list.get(position);
        txtTask.setText(map.get(TASK_COLUMN));
        txtCreateDate.setText(map.get(CREATE_DATE_COLUMN));
        txtCompletedDate.setText(map.get(COMPLETED_DATE_COLUMN));
        txtHasCompleted.setText(map.get(HAS_COMPLETED_COLUMN));

        return convertView;
    }

    public void addItem(ArrayList<HashMap<String, String>> new_list) {
        // TODO Auto-generated method stub
        list = new_list;
        notifyDataSetChanged();
    }

    public String getTask(int position) {
        // TODO Auto-generated method stub
        HashMap<String, String> map = list.get(position);
        return map.get(TASK_COLUMN);
    }

    public String getCreateDate(int position) {
        // TODO Auto-generated method stub
        HashMap<String, String> map = list.get(position);
        return map.get(CREATE_DATE_COLUMN);
    }

    public String getCompletedDate(int position) {
        // TODO Auto-generated method stub
        HashMap<String, String> map = list.get(position);
        return map.get(COMPLETED_DATE_COLUMN);
    }

    public String getHasCompletetd(int position) {
        // TODO Auto-generated method stub
        HashMap<String, String> map = list.get(position);
        return map.get(HAS_COMPLETED_COLUMN);
    }



}