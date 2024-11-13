package com.example.memorycardgameattempt1

class Dealer(var score:Int, val deck:Deck){
    lateinit var visibleCard:Card;

    // the dealer gets his cards
    // Blackjack rules state the second card is visible
    fun initDealer():Int{
        val card1 = deck.dealCard();
        score += card1.getCardValue()

        visibleCard = deck.dealCard()
        score += visibleCard.getCardValue();
        return score;
    }
    fun getScore():Int{
        return this.score;
    }
//    return the visible card
    fun getVisibleCard():Card{
        return this.visibleCard
    }
}
