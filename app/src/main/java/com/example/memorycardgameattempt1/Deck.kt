package com.example.memorycardgameattempt1

class Deck() {
    //    Four types of Suits for cards
    var suits : List<String> = listOf("Hearts","Diamonds", "Clubs", "Spades")
    //    Defined values that are available for a cards
    private val values = listOf("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A")
    private var cards : MutableList<Card> = mutableListOf<Card>()
    //    initialize a Deck object with cards
    init{
        val suits : List<String> = listOf("Hearts","Diamonds", "Clubs", "Spades")
        //    Defined values that are available for a cards
        val values = listOf("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A")
        for(suit in suits){
            for(cardValue in values ){
                cards.add(Card(suit,cardValue))
            }
        }
        shuffle();
    }
    fun shuffle(){
//        built in shuffle function
     cards.shuffle()
    }
//    Return the card list, presumably to user
    fun getAllCards() : MutableList<Card> {
        return cards
    }
//    Return the list of suits available
    fun getAllSuits() : List<String>{
        return suits
    }
//    Remove card
    fun dealCard(): Card {
        return cards.removeFirst()
    }
}