package com.example.pjapp.whackamole

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.support.constraint.ConstraintLayout
import android.widget.ImageButton
import android.widget.TextView

class GameActivity : AppCompatActivity() {

    var score = 0
    var playerScore: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        playerScore = findViewById(R.id.score)
        startGame()

    }

    fun startGame() {
        if (score >= 10) {
            startActivity(Intent(this, WinActivity::class.java))

        } else {

            val image = pickImage()
            clickable(image).start()
        }
    }

    fun pickImage(): ImageButton {

        val images = findViewById<ConstraintLayout>(R.id.gameLayout).touchables
        //touchables return all elements by arraylist

        images.shuffle()
        //shuffle is random items

        val randomImage = images[0] as ImageButton
        // using as and ensure we have the correct return type

        randomImage.setImageResource(R.drawable.ic_active)

        return randomImage


    }

    fun clickable(image: ImageButton): CountDownTimer {
        image.setOnClickListener {

            image.setImageResource(R.drawable.ic_success)
            score++
            playerScore?.text = score.toString()
        }
        return object : CountDownTimer(1000, 100) {

            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                image.setImageResource(R.drawable.ic_inactive)
                image.setOnClickListener(null)
                startGame()

            }


        }
    }
}


