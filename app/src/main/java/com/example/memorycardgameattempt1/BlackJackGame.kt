package com.example.memorycardgameattempt1

import android.content.Context
import android.media.Image
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
class BlackJackGame(val sucker:Player, context: Context, scoreContainer:TextView, dealerCard: ImageView) {
    private var context: Context = context
    private var scoreContainer:TextView = scoreContainer
//    Data
var score:Int = 0;
    var gameNotOver:Boolean = true;
    //initialize Dealer
    var dealer:Dealer;
   init{
//        Dealer draws their cards.
           dealer= Dealer(score,Deck(),dealerCard, context)
//        Player draws their cards
        deal()
       deal()
//        Prompt user to hit or fold
   }
    fun deal():Int{
        var dealt = dealer.deal();
        score+=dealt;
        updateScore()
        checkGame()
        return score
    }
    fun updateScore(){
        try{
            this.scoreContainer.setText(score.toString())
        }catch ( e :Exception){
            println("Error occured reaching Textview")
        }
    }
    fun gameOver(){
        if(score <= 21 && dealer.score > score){
            Toast.makeText(context,"You WIN", Toast.LENGTH_SHORT).show()
        }
        Toast.makeText(context,"You lost", Toast.LENGTH_SHORT).show()
        resetGame()
    }
    fun resetGame(){
        this.score = 0;
        this.dealer.reset();
        scoreContainer.setText("0")
    }
    fun checkGame(){
        if(score >= 21){
            gameOver()
        }
    }
    fun toggleGameNotOVer(){
        this.gameNotOver = !this.gameNotOver
    }
    fun getDealerScore(){
        Toast.makeText(this.context, ""+dealer.score, Toast.LENGTH_SHORT).show()
    }
    fun getResource():Int{
        return 0;
    }
}