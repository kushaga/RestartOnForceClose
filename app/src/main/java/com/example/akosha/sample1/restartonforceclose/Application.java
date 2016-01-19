package com.example.akosha.sample1.restartonforceclose;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by kushagarlall on 19/01/16.
 */
public class Application extends android.app.Application {


    @Override
    public void onCreate() {
        super.onCreate();
        restartOnForceClose();
    }

    private void restartOnForceClose() {
//        IntentFilter filter = new IntentFilter(OnCloseAlarmReceiver.PROCESS_RESPONSE);
//        filter.addCategory(Intent.CATEGORY_DEFAULT);
//        OnCloseAlarmReceiver receiver = new OnCloseAlarmReceiver();
//        registerReceiver(receiver, filter);

        SharedPreferences sharedPreferences = getSharedPreferences("DEFAULT", MODE_PRIVATE);
        if (!sharedPreferences.getBoolean("AlarmSet", false)) {
            AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

            Intent intent = new Intent(this, MyIntentService.class);

            PendingIntent onRestartPenIntent = PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
            alarm.setRepeating(AlarmManager.RTC, System.currentTimeMillis() + 10000, 10000, onRestartPenIntent);

            sharedPreferences.edit().putBoolean("AlarmSet", true);
        }

//        PendingIntent onRestartPenIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);


    }


}
