package com.wzx.maincompent;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout contextView= (ConstraintLayout) getRootView(this);
        contextView.getChildAt(0).setVisibility(View.GONE);
        Button button=new Button(this);
        button.setText(getString(R.string.set_wallpaper));
        button.setOnClickListener(new View.OnClickListener(){

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
               VideoLiveWallPaper.setToWallPaper(MainActivity.this);
            }
        });
        contextView.addView(button);
    }




}
