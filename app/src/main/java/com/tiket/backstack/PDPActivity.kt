package com.tiket.backstack

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class PDPActivity : AppCompatActivity() {

    lateinit var localIndex: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdpactivity)

        localIndex = "PDP ${Index.index + 1}"
        findViewById<TextView>(R.id.tv_pdp).text = localIndex
        findViewById<AppCompatButton>(R.id.btn_book).setOnClickListener {
            if (Index.index == 1) {
                Index.index = 0
                startActivity(Intent(this, BookingFormActivity::class.java))
            } else {
                Index.index = 1
                startActivity(Intent(this, SRPActivity::class.java))
            }

        }
    }
}