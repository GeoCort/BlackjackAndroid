package com.example.memorycardgameattempt1

import android.animation.Animator
import android.animation.AnimatorInflater
import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.animation.doOnEnd

class Dealer(var score:Int, var deck:Deck, dealerView : ImageView, context:Context){
     var visibleCard:Card;
    var toggle = false;
    // the dealer gets his cards
    // Blackjack rules state the second card is visible
    init{
        val card1 = deck.dealCard();
        score += card1.getCardValue()

        visibleCard = deck.dealCard()
        animateCard(dealerView,context,visibleCard)
        score += visibleCard.getCardValue();
    }
    fun deal():Int{
        val card = deck.dealCard()
        return card.getCardValue()
    }
    fun reset(){
        this.deck = Deck()
        this.score+= deck.dealCard().getCardValue() + deck.dealCard().getCardValue()
    }

    fun animateCard(btn : ImageView, context: Context, card :Card) {
        val anim: Animator? = AnimatorInflater.loadAnimator(context, R.animator.flipping)
        anim?.setTarget(btn)
        anim?.setDuration(500)
        anim?.start()
        anim?.doOnEnd {
            val anim2: Animator? = AnimatorInflater.loadAnimator(context, R.animator.flipping2)
            anim2?.setTarget(btn)
            anim2?.setDuration(500)
            anim2?.start()
            btn.findViewById<ImageView>(R.id.cardView).setImageResource(toggleAnim())

            anim2?.doOnEnd {
                btn.findViewById<ImageView>(R.id.cardView).setImageResource(currentAnim())

            }
        }
    }
    fun toggleAnim():Int{
        if(toggle){
            toggle = !toggle
            return R.drawable.card_back
        }
        toggle = !toggle
        return R.drawable.hearts_ten
    }
    fun currentAnim():Int{
        if(toggle){
            return R.drawable.card_back
        }
        return R.drawable.hearts_ten
    }
//    fun getScore():Int{
//        return this.score;
//    }
////    return the visible card
//    fun getVisibleCard():Card{
//        return this.visibleCard
//    }
}
