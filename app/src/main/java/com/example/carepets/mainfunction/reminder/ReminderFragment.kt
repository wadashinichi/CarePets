package com.example.carepets.mainfunction.reminder

import android.app.AlarmManager
import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.icu.text.CaseMap.Title
import android.icu.util.Calendar
import android.os.Bundle
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.carepets.R
import com.example.carepets.databinding.FragmentReminderBinding
import com.example.carepets.mainfunction.Broadcast
import java.time.Month
import java.util.Date


class ReminderFragment : Fragment() {

    private lateinit var binding: FragmentReminderBinding
    private fun createNotificationChannel(title: String, text: String) {
        val name = title
        val text = text
        val important = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel("channel..1?", name, important)
        channel.description = text
        val notificationManager = requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

    }
    private fun scheduleNotification(name: String, des: String) {
        val i: Intent = Intent(requireActivity().applicationContext, Broadcast::class.java)
        val title = name
        val text = des
        i.putExtra("AnnounceTitle", title)
        i.putExtra("AnnounceText", text)

        val pendingIntent = PendingIntent.getBroadcast(requireContext().applicationContext,
        1, i, PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)
        val alarmManager = requireActivity().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        var time: Long = 0L
//        time = getTime()
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            time,
            pendingIntent
        )
        showAlert(time, title, text)
    }
    private fun getTime(hour: Int, minute: Int, day: Int, month: Int, year: Int): Long {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, hour, minute)
        return calendar.timeInMillis
    }
    private fun showAlert(time: Long, title: String, message: String) {
        val date = Date(time)
        val dateFormat = android.text.format.DateFormat.getLongDateFormat(requireActivity().applicationContext)
        val timeFormat = android.text.format.DateFormat.getTimeFormat(requireActivity().applicationContext)

        AlertDialog.Builder(requireContext()).setTitle("Notification Scheduled")
            .setMessage(
                "Title: $title \nMessage $message \nAt: ${dateFormat.format(date)} ${timeFormat.format(date)}")
            .setPositiveButton("Okay"){_,_ ->}
            .show()
    }

    //    private lateinit var
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReminderBinding.inflate(layoutInflater)

        var timeWalk: String = ""
        binding.tvWalk.setOnClickListener {view: View ->
            timeWalk = takeTime(view)
            binding.tvWalk.text = timeWalk
        }
        binding.switchWalk.setOnClickListener {
            if (binding.switchWalk.isChecked) {
//                createNotificationChannel()
//                binding.
            } else {

            }
        }
        return binding.root
    }
    private fun takeTime(view: View): String {
        val clock = Calendar.getInstance()
        var hour = clock.get(Calendar.HOUR)
        var minute = clock.get(Calendar.MINUTE)
        TimePickerDialog(requireContext(), TimePickerDialog.OnTimeSetListener { view, hour, minute ->
            binding.tvWalk.text = "$hour:$minute"
        }, hour, minute, true)
            .show()
        return "$hour:$minute"
    }
}