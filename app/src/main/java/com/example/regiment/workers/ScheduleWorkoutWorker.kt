package com.example.regiment.workers

import android.app.Notification
import android.content.Context
import androidx.core.app.NotificationCompat
import java.util.Calendar
import java.util.Date

class ScheduleWorkoutWorker (private val ctx: Context, date: Date){

    private fun createNotification(): Notification {
        val notification = NotificationCompat.Builder(
            this.ctx,
            CHANNEL_ID
        )
            .setSmallIcon(android.R.drawable.ic_partial_secure)
            .setContentTitle("Regiment")
            .setContentText("Opened Calendar app to schedule workout")
            .build()
    return notification
    }


    companion object{
        val CHANNEL_ID = "com.example.regiment.channel"
    }
}