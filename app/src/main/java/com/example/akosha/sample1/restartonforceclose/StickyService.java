package com.example.akosha.sample1.restartonforceclose;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by kushagarlall on 19/01/16.
 */
public class StickyService extends Service {
    private static final String TAG = "StickyService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "oncreate");
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand");
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "service destroyed", Toast.LENGTH_SHORT).show();
        sendBroadcast(new Intent("YouWillNeverKillMe"));
    }
}