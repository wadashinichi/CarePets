package com.example.carepets.mainfunction.reminder

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.carepets.R

public class Broadcast : BroadcastReceiver() {

    lateinit var context: Context
    lateinit var intent: Intent
    override fun onReceive(p0: Context?, p1: Intent?) {
        if (p0 != null) {
            context = p0
        }
        if (p1 != null) {
            intent = p1
        }
        val notification = NotificationCompat.Builder(context,"channel1..?")
            .setSmallIcon(R.drawable.ic_android)
            .setContentTitle(intent.getStringExtra("AnnounceTitle"))
            .setContentText(intent.getStringExtra("AnnounceText"))
            .build()
        val manage = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manage.notify(1, notification)
    }
}