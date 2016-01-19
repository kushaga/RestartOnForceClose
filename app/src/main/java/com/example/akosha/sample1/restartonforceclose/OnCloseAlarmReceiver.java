package com.example.akosha.sample1.restartonforceclose;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by kushagarlall on 19/01/16.
 */
public class OnCloseAlarmReceiver extends BroadcastReceiver {

    public static final String PROCESS_RESPONSE = ".action.RESPONSE";

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intentRestart = new Intent(context, MyIntentService.class);
//        WakefulIntentService.sendWakefulWork(context, intentRestart);
        PendingIntent onRestartPenIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        context.startService(intentRestart);
    }
}
