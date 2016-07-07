package com.project.kongdy.lockscreen.Base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author kongdy
 *         on 2016/7/7
 */
public abstract class BaseActivty extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InjectContentView();
        setParam();
        initMethod();
    }

    /**
     * 做一些公共方法
     */
    private void initMethod(){

    }
    /**
     * 负责注入界面
     */
    public abstract void InjectContentView();

    /**
     * 所有初始化方法统一在这里执行
     */
    public abstract void setParam();


}
