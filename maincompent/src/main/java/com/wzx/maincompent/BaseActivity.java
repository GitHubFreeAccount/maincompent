package com.wzx.maincompent;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Declan on 2017 2017/6/27.9:41
 */

public class BaseActivity extends Activity {
    private String TAG="BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"BaseActivity onCreate");
    }
    public  View getRootView(Activity context){
        return  ((ViewGroup)context.findViewById(android.R.id.content)).getChildAt(0);
    }

}
