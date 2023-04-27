package com.example.carepets.mainfunction.reminder

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationManagerCompat
import com.example.carepets.R

class Broadcast : BroadcastReceiver() {

    private lateinit var context: Context
    override fun onReceive(p0: Context?, p1: Intent?) {
        if (p0 != null) {
            context = p0
        }
        var builder = androidx.core.app.NotificationCompat.Builder(context, "channelID")
            .setSmallIcon(R.drawable.ic_android)
            .setContentTitle("Remind ...")
            .setContentText("Hey, this the time for ...")
            .setPriority(androidx.core.app.NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager: NotificationManagerCompat = NotificationManagerCompat.from(context)
//        notificationManager.notify(200, builder.build())
    }
}