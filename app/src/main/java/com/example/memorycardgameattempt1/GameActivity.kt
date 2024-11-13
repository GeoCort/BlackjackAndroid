package com.example.memorycardgameattempt1

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val currentScore: TextView = findViewById<TextView>(R.id.cardScore)
        val hitMeBtn: Button = findViewById(R.id.HitButton)
        val gameOverBtn: Button = findViewById(R.id.gameOverBtn)
        val game:BlackJackGame = BlackJackGame(Player(),this,currentScore)
        hitMeBtn.setOnClickListener(){
            game.deal()
        }
        gameOverBtn.setOnClickListener(){
            game.gameOver()
        }
    }
}