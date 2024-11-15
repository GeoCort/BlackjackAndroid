package com.example.memorycardgameattempt1

import android.content.Context
import android.media.Image
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
class BlackJackGame(val sucker:Player, context: Context, scoreContainer:TextView, dealerCard: ImageView, dealerScore:TextView) {
    private var context: Context = context
    private var hand: MutableList<Card> = mutableListOf<Card>()
    private var scoreContainer:TextView = scoreContainer
//    Data
    var score:Int = 0;
    var gameNotOver:Boolean = true;
//    Dealer
    var dealer:Dealer;
    var dealerCard =dealerCard
    var dealerScore:TextView = dealerScore
    var scoreView = scoreContainer
   init{
//        Dealer draws their cards.
           dealer= Dealer(Deck(),dealerCard, context,dealerScore)
//        Player draws their cards
       deal()
       deal()
//        Prompt user to hit or fold
   }
    fun deal(){
        var dealt = dealer.deal();
        hand.add(dealt)
        score += dealt.getCardValue();
        updateScore()
        checkGame()
    }
    fun updateScore(){
        try{
            this.scoreContainer.setText("Current score is : " + score.toString())
        }catch ( e :Exception){
            println("Error occured reaching Textview")
        }
    }
    fun gameOver(){
        if(score <= 21 && dealer.score < score){
            Toast.makeText(context,"You WIN", Toast.LENGTH_SHORT).show()
        }
        Toast.makeText(context,"You lost", Toast.LENGTH_SHORT).show()
        resetGame()
    }
    fun resetGame(){
        this.score = 0; // reset game score to 0
        this.dealer = Dealer(Deck(), this.dealerCard, this.context,this.dealerScore) // start a new dealer animation
        hand.clear(); // clear our cards
        deal()
        deal()
    }
    fun checkGame(){
        if(score >= 21){
            gameOver()
        }
    }
    fun getDealerScore(){
        Toast.makeText(this.context, ""+dealer.score, Toast.LENGTH_SHORT).show()
    }
    fun getResource():Int{
        return 0;
    }
}