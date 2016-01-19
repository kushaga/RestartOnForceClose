package com.example.akosha.sample1.restartonforceclose;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Timer;

/**
 * Created by kushagarlall on 19/01/16.
 */
public class MyIntentService extends Service {

    private Timer timer = new Timer();
    private static final String name = MyIntentService.class.getName();

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public MyIntentService() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("TAG", "service create");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        Log.d("TAG", "service started");

        /*AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

        Intent cIntent = new Intent(this, MyIntentService.class);

        PendingIntent onRestartPenIntent = PendingIntent.getService(this, 0 , cIntent, PendingIntent.FLAG_CANCEL_CURRENT);

//        PendingIntent onRestartPenIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        alarm.set(AlarmManager.RTC, 5000, onRestartPenIntent);*/
    }
/*

    @Override
    protected void onHandleIntent(Intent intent) {

        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(OnCloseAlarmReceiver.PROCESS_RESPONSE);
        broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
        sendBroadcast(broadcastIntent);
    }
*/

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("intent_service", "Background thread started");

        // Sticky means service will continue running until explicitly stopped
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
