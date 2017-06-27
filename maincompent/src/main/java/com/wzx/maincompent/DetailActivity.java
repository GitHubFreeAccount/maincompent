package com.wzx.maincompent;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Iterator;

/**
 * Created by Declan on 2017 2017/6/26.18:53
 */

public class DetailActivity extends BaseActivity {

    private String TAG = "DetailActivity";
    private int getVideoId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        getVideoId = intent.getIntExtra("ID", 0);
        Bundle bundle = intent.getExtras();

        Iterator<String> iterator = bundle.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = String.valueOf(bundle.get(key));
            Log.d(TAG, value);
        }

        Log.d(TAG, String.valueOf(getVideoId));
        ConstraintLayout contextView = (ConstraintLayout) getRootView(this);
        TextView textview = (TextView) contextView.getChildAt(0);
        textview.setText(getString(R.string.detial));
    }


}
