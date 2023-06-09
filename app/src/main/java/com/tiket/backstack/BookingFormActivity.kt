package com.tiket.backstack

import android.app.PendingIntent
import android.app.PendingIntent.CanceledException
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.app.TaskStackBuilder


class BookingFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_form)

        findViewById<AppCompatButton>(R.id.btn_back).setOnClickListener {
            backToPDP1()
        }
    }

    private fun backToPDP1() {
        val targetInstanceIdentifier = "PDPActivity_Instance1"
        val srp1InstanceIdentifier = "SRPActivity_Instance1"

        val stackBuilder: TaskStackBuilder = TaskStackBuilder.create(this)
        stackBuilder.addNextIntentWithParentStack(Intent(this, MainActivity::class.java))

        val targetIntent = Intent(this, PDPActivity::class.java)
        targetIntent.putExtra("INSTANCE_IDENTIFIER", targetInstanceIdentifier)

        val srp1 = Intent(this, SRPActivity::class.java)
        srp1.putExtra("INSTANCE_IDENTIFIER", srp1InstanceIdentifier)

        stackBuilder.addNextIntent(srp1)
        stackBuilder.addNextIntent(targetIntent)

        val pendingIntent: PendingIntent? =
            stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        try {
            pendingIntent?.send()
        } catch (e: CanceledException) {
            e.printStackTrace()
        }
    }
}