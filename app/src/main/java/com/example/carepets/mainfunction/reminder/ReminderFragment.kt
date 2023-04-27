package com.example.carepets.mainfunction.reminder

import android.app.AlarmManager
import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carepets.R
import com.example.carepets.databinding.FragmentReminderBinding
import java.util.Date


class ReminderFragment : Fragment() {

    private lateinit var binding: FragmentReminderBinding
    private val NOTIFICATION_REMINDER_NIGHT = 1
    private val CHANNEL_ID = "channelID"
    private lateinit var calendar: Calendar
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReminderBinding.inflate(layoutInflater)

        var timeWalk: String = ""
        binding.tvWalk.setOnClickListener {view: View ->
//            timeWalk = takeTime(view)
            binding.tvWalk.text = timeWalk
        }
        binding.switchWalk.setOnClickListener {
            if (binding.switchWalk.isChecked) {

            } else {

            }
        }
        return binding.root
    }
//    private fun createNotificationChannel() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            // Create the NotificationChannel.
//            val name = getString(R.string.channel_name)
//            val descriptionText = getString(R.string.channel_description)
//            val importance = NotificationManager.IMPORTANCE_DEFAULT
//            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
//            mChannel.description = descriptionText
//            // Register the channel with the system. You can't change the importance
//            // or other notification behaviors after this.
//            val notificationManager: NotificationManager = getSystemService(NotificationManager::class.java)
//            notificationManager.createNotificationChannel(mChannel)
//        }
//    }
    private fun takeTime(hour: Int, minute: Int, day: Int, month: Int, year: Int) {
        calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        // if alarm time has already passed, increment day by 1
        if (calendar.timeInMillis <= System.currentTimeMillis()) {
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
        }
    }
}