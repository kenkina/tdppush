package com.tdp.tdppush;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.tdp.tdppush.MainActivity;
import com.tdp.tdppush.R;
import com.tdp.tdppush.util.Constants;

import java.util.Map;

/**
 * Created by kenkina on 29/10/2017.
 */

public class NotificationService extends FirebaseMessagingService {

    public static int NOTIFICATION_ID = 1;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        //Call method to generate notification
        generateNotification(remoteMessage.getData(), remoteMessage.getNotification().getBody());
    }

    private void generateNotification(Map data, String messageBody) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Constants.ALUMNO_ID, (String) data.get(Constants.ALUMNO_ID));
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Notification.Builder mNotifyBuilder = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("TDPPush")
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (NOTIFICATION_ID > 1073741824) {
            NOTIFICATION_ID = 0;
        }
        notificationManager.notify(NOTIFICATION_ID++, mNotifyBuilder.build());
    }
}
