package com.project.kongdy.lockscreen;


import android.view.WindowManager;

import com.project.kongdy.lockscreen.Base.BaseActivty;

public class LockScreenActivity extends BaseActivty {


    @Override
    public void InjectContentView() {
        setContentView(R.layout.activity_lock_screen);
    }

    @Override
    public void setParam() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
    }

    @Override
    public void onBackPressed() {

        //super.onBackPressed();
    }
}
