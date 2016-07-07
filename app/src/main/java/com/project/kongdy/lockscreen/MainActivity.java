package com.project.kongdy.lockscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.project.kongdy.lockscreen.Base.BaseActivty;

public class MainActivity extends BaseActivty {

    private final String TAG = "MainActivity";

    private Button startBtn;

    /**
     * 开机自启动
     */
    public class BootReciver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            context.startActivity(new Intent(context,MainActivity.class));
            context.startService(new Intent("com.project.kongdy.lockscreen.GhostService"));
            Toast.makeText(context,"锁屏已经启动",Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void setParam() {

        startBtn = (Button) findViewById(R.id.startBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setClass(MainActivity.this,GhostService.class);
                startService(intent);
            }
        });

    }

    @Override
    public void InjectContentView() {
      setContentView(R.layout.activity_main);
    }
}
