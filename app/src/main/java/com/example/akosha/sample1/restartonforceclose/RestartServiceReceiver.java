package com.example.akosha.sample1.restartonforceclose;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by kushagarlall on 19/01/16.
 */
public class RestartServiceReceiver extends WakefulBroadcastReceiver {

    private static final String TAG = "RestartServiceReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive");
        Toast.makeText(Application.getInstance(), "service destroyed", Toast.LENGTH_SHORT).show();
        context.startService(new Intent(context.getApplicationContext(), StickyService.class));
    }

}