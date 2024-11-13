package com.example.memorycardgameattempt1

import android.widget.TextView

class BlackJackGame(val deck:Deck, val sucker:Player) {
//    Views
   lateinit var dealerSecondCard:TextView;
    lateinit var playerScoreTextView : TextView
//    Data
    val score:Int = 0;
    var gameNotOver:Boolean = true;
    //initialize Dealer
    lateinit var dealer:Dealer;
    fun startGame(player:Player){
//        Dealer draws their cards.
        dealer= Dealer(score,deck)
        dealer.initDealer()
//        Player draws their cards
//        Prompt user to hit or fold
//          Display who won or lost depending on conditional
            if(score > 21 || dealer.getScore() > 21 ){
                toggleGameNotOVer()
            }

    }
    fun toggleGameNotOVer(){
        this.gameNotOver = !this.gameNotOver
    }
}