package com.project.kongdy.lockscreen;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.project.kongdy.lockscreen.Base.BaseService;

/**
 * @author kongdy
 *         on 2016/7/7
 */
public class GhostService extends BaseService {

    private final String TAG = "GhostService";
    private final int myId = -966121;

    private BroadcastReceiver screenReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Intent lockScreenIntent = new Intent();
            lockScreenIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            lockScreenIntent.setClass(GhostService.this,LockScreenActivity.class);
            startActivity(lockScreenIntent);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG,"service is on the background");
        startForeground(myId,new Notification());
        Toast.makeText(this,"on background!",Toast.LENGTH_LONG).show();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
        registerReceiver(screenReceiver,intentFilter);
        flags = START_REDELIVER_INTENT;
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"is be killed!",Toast.LENGTH_LONG).show();
        unregisterReceiver(screenReceiver);
        Intent intent = new Intent();
        intent.setClass(GhostService.this,GhostService.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startService(intent);
        Log.v(TAG,"service is destoryed!");
    }
}
