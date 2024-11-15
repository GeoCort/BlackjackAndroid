package com.example.memorycardgameattempt1

import android.animation.Animator
import android.animation.AnimatorInflater
import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.animation.doOnEnd

class Dealer(var deck:Deck, dealerView : ImageView, context:Context, dealerScore: TextView){
    var score:Int = 0
    var visibleCard:Card;
    lateinit var cardContext:Context;
    var dealerCardResource:Int =R.drawable.card_back
    var dealerScoreTextView = dealerScore
    var toggle = false;
    // the dealer gets his cards
    // Blackjack rules state the second card is visible
    init{
        cardContext = context
        val card1 = deck.dealCard();
        score += card1.getCardValue()
        visibleCard = deck.dealCard()
        this.dealerCardResource = getResource()
        animateCard(dealerView,context,visibleCard)
        dealerScoreTextView.setText(visibleCard.getCardValue().toString())
        score += visibleCard.getCardValue();
    }
    fun deal():Card{
        val card = deck.dealCard()
        return card
    }
    fun animateCard(btn : ImageView, context: Context, card :Card) {
        val anim: Animator? = AnimatorInflater.loadAnimator(context, R.animator.flipping)
        anim?.setTarget(btn)
        anim?.setDuration(500)
        anim?.start()
        anim?.doOnEnd{
            val anim2: Animator? = AnimatorInflater.loadAnimator(context, R.animator.flipping2)
            anim2?.setTarget(btn)
            anim2?.setDuration(500)
            btn.setImageResource(dealerCardResource)
            anim2?.start()
            anim2?.doOnEnd {
                btn.setImageResource(currentAnim())
            }
        }
    }
    fun toggleAnim():Int{
        if(toggle){
            toggle = !toggle
            println("Card_BACK is " + R.drawable.card_back)
            return R.drawable.card_back
        }
        toggle = !toggle
        return dealerCardResource
    }
    fun currentAnim():Int{
        return dealerCardResource
    }
    fun getResource():Int{
        var result = when (visibleCard.value){
            "2" -> "two"
            "3" -> "three"
            "4" -> "four"
            "5" -> "five"
            "6" -> "six"
            "7" -> "seven"
            "8" -> "eight"
            "9" -> "nine"
            "10" -> "ten"
            "Q" -> "queen"
            "J" -> "jack"
            "K" -> "king"
            "A" -> "ace"
            else -> {visibleCard.value}
        }
        val resourceString = visibleCard.suit +"_"+ result
        return  cardContext.getResources().getIdentifier(resourceString, "drawable", cardContext.packageName)
    }

}
