package com.tiket.backstack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class SRPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_srpactivity)

        findViewById<TextView>(R.id.tv_pdp).text = "SRP ${Index.index+1}"
        findViewById<AppCompatButton>(R.id.btn_select).setOnClickListener {
            startActivity(Intent(this, PDPActivity::class.java))
        }
    }
}