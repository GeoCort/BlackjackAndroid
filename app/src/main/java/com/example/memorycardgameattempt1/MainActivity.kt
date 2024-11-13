package com.example.memorycardgameattempt1

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.animation.doOnEnd
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn = findViewById<CardView>(R.id.cardCenter)
        val context  = this;
        btn.setOnClickListener( ){
            Toast.makeText(this, "Clciekd card",Toast.LENGTH_SHORT ).show();
            val anim: Animator? = AnimatorInflater.loadAnimator(context, R.animator.flipping)
            anim?.setTarget(btn)
            anim?.setDuration(1500)
            anim?.start()
            anim?.doOnEnd {
                val anim2: Animator? = AnimatorInflater.loadAnimator(context, R.animator.flipping2)
                anim2?.setTarget(btn)
                anim2?.setDuration(1500)
                anim2?.start()
                this.findViewById<ImageView>(R.id.cardView).setImageResource(R.drawable.hearts_six)

                anim2?.doOnEnd {
                    this.findViewById<ImageView>(R.id.cardView).setImageResource(R.drawable.hearts_six)

                }
            }
        }

    }

}
