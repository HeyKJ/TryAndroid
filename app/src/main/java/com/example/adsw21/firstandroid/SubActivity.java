package com.example.adsw21.firstandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by adsw2 on 2016-07-06.
 */
public class SubActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity);
    }

    public void mOnClick(View view){
        finish();
    }
}
