package com.example.fengjen.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Creating the URI…");

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.linearlayout);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.duffy);

        constraintLayout.addView(iv);

        constraintSet.constrainWidth(iv.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.constrainHeight(iv.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.center(iv.getId(), ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0, 0.5f);
        constraintSet.center(iv.getId(), ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0, 0.5f);
        constraintSet.applyTo(constraintLayout);

        //setContentView(constraintLayout);

        //LinearLayout linearL = (LinearLayout) findViewById(R.id.linearlayout);
        //linearL.setOrientation(LinearLayout.VERTICAL);

        //set image to the center
        //LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        //layoutParams.gravity = Gravity.CENTER;

        //ImageView iv = new ImageView(this);
        //iv.setImageResource(R.drawable.duffy);
        //iv.setLayoutParams(layoutParams);
        //linearL.addView(iv);
        //setContentView(linearL);
    }
}
