package com.example.memorycardgameattempt1

class Deck(val deck:List<Card>) {
    //    Four types of Suits for cards
    private val suits : List<String> = listOf("Hearts","Diamonds", "Clubs", "Spades")
    //    Defined values that are available for a cards
    private val values = listOf("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A")
    private lateinit var cards : MutableList<Card>

    //    initialize a Deck object with cards
    init{
        for(suit in suits){
            for(cardValue in values ){
                cards.add(Card(suit,cardValue))
            }
        }
    }
    fun shuffle(){
//        built in shuffle function
     cards.shuffle()
    }
//    Return the card list, presumably to user
    fun getCards() : MutableList<Card> {
        return cards
    }
//    Return the list of suits available
    fun getSuits() : List<String>{
        return suits
    }
//    Remove card
    fun dealCard(): Card {
        return cards.removeFirst()
    }
}