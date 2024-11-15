package com.example.memorycardgameattempt1

import android.content.Context

class Card(val suit:String, val value:String){
    //    get card value
    fun getCardValue(): Int{
        return when (this.value) {
            "A" -> {
                11;
            }

            "J", "Q", "K" -> {
                10
            }
            else -> {
                this.value.toInt()
            }
        }
    }
}
