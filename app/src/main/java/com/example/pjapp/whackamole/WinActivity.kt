package com.example.pjapp.whackamole

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WinActivity : AppCompatActivity() {

    var winner: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)
        winner = findViewById(R.id.winText)
        winner?.text = "Congratulations"
    }
}
