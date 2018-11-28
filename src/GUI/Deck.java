package GUI;


import GUI.Card;

/**
 * This class creates a standard deck of 52 cards to be used for any 
 * multitude of card games.
 * @author Jeff Gore, Randy Ryan, Kyle Mcdevitt
 *
 */
public class Deck extends Pile {
	private static Pile deck;

	public Deck(){
		deck = new Pile();
		Card c1 = new Card(Card.Suit.Hearts, Card.Rank.Ace, 1);
		Card c2 = new Card(Card.Suit.Diamonds, Card.Rank.Ace, 1);
		Card c3 = new Card(Card.Suit.Spades, Card.Rank.Ace, 1);
		Card c4 = new Card(Card.Suit.Clubs, Card.Rank.Ace, 1);
		Card c5 = new Card(Card.Suit.Hearts, Card.Rank.Two, 2);
		Card c6 = new Card(Card.Suit.Diamonds, Card.Rank.Two, 2);
		Card c7 = new Card(Card.Suit.Spades, Card.Rank.Two, 2);
		Card c8 = new Card(Card.Suit.Clubs, Card.Rank.Two, 2);
		Card c9 = new Card(Card.Suit.Hearts, Card.Rank.Three, 3);
		Card c10 = new Card(Card.Suit.Diamonds, Card.Rank.Three, 3);
		Card c11 = new Card(Card.Suit.Spades, Card.Rank.Three, 3);
		Card c12 = new Card(Card.Suit.Clubs, Card.Rank.Three, 3);
		Card c13 = new Card(Card.Suit.Hearts, Card.Rank.Four, 4);
		Card c14 = new Card(Card.Suit.Diamonds, Card.Rank.Four, 4);
		Card c15 = new Card(Card.Suit.Spades, Card.Rank.Four, 4);
		Card c16 = new Card(Card.Suit.Clubs, Card.Rank.Four, 4);
		Card c17 = new Card(Card.Suit.Hearts, Card.Rank.Five, 5);
		Card c18 = new Card(Card.Suit.Diamonds, Card.Rank.Five, 5);
		Card c19 = new Card(Card.Suit.Spades, Card.Rank.Five, 5);
		Card c20 = new Card(Card.Suit.Clubs, Card.Rank.Five, 5);
		Card c21 = new Card(Card.Suit.Hearts, Card.Rank.Six, 6);
		Card c22 = new Card(Card.Suit.Diamonds, Card.Rank.Six, 6);
		Card c23 = new Card(Card.Suit.Spades, Card.Rank.Six, 6);
		Card c24 = new Card(Card.Suit.Clubs, Card.Rank.Six, 6);
		Card c25 = new Card(Card.Suit.Hearts, Card.Rank.Seven, 7);
		Card c26 = new Card(Card.Suit.Diamonds, Card.Rank.Seven, 7);
		Card c27 = new Card(Card.Suit.Spades, Card.Rank.Seven, 7);
		Card c28 = new Card(Card.Suit.Clubs, Card.Rank.Seven, 7);
		Card c29 = new Card(Card.Suit.Hearts, Card.Rank.Eight, 8);
		Card c30 = new Card(Card.Suit.Diamonds, Card.Rank.Eight, 8);
		Card c31 = new Card(Card.Suit.Spades, Card.Rank.Eight, 8);
		Card c32 = new Card(Card.Suit.Clubs, Card.Rank.Eight, 8);
		Card c33 = new Card(Card.Suit.Hearts, Card.Rank.Nine, 9);
		Card c34 = new Card(Card.Suit.Diamonds, Card.Rank.Nine, 9);
		Card c35 = new Card(Card.Suit.Spades, Card.Rank.Nine, 9);
		Card c36 = new Card(Card.Suit.Clubs, Card.Rank.Nine, 9);
		Card c37 = new Card(Card.Suit.Hearts, Card.Rank.Ten, 10);
		Card c38 = new Card(Card.Suit.Diamonds, Card.Rank.Ten, 10);
		Card c39 = new Card(Card.Suit.Spades, Card.Rank.Ten, 10);
		Card c40 = new Card(Card.Suit.Clubs, Card.Rank.Ten, 10);
		Card c41 = new Card(Card.Suit.Hearts, Card.Rank.Jack, 10);
		Card c42 = new Card(Card.Suit.Diamonds, Card.Rank.Jack, 10);
		Card c43 = new Card(Card.Suit.Spades, Card.Rank.Jack, 10);
		Card c44 = new Card(Card.Suit.Clubs, Card.Rank.Jack, 10);
		Card c45 = new Card(Card.Suit.Hearts, Card.Rank.Queen, 10);
		Card c46 = new Card(Card.Suit.Diamonds, Card.Rank.Queen, 10);
		Card c47 = new Card(Card.Suit.Spades, Card.Rank.Queen, 10);
		Card c48 = new Card(Card.Suit.Clubs, Card.Rank.Queen, 10);
		Card c49 = new Card(Card.Suit.Hearts, Card.Rank.King, 10);
		Card c50 = new Card(Card.Suit.Diamonds, Card.Rank.King, 10);
		Card c51 = new Card(Card.Suit.Spades, Card.Rank.King, 10);
		Card c52 = new Card(Card.Suit.Clubs, Card.Rank.King, 10);
		
		deck.push(c1);
		deck.push(c2);
		deck.push(c3);
		deck.push(c4);
		deck.push(c5);
		deck.push(c6);
		deck.push(c7);
		deck.push(c8);
		deck.push(c9);
		deck.push(c10);
		deck.push(c11);
		deck.push(c12);
		deck.push(c13);
		deck.push(c14);
		deck.push(c15);
		deck.push(c16);
		deck.push(c17);
		deck.push(c18);
		deck.push(c19);
		deck.push(c20);
		deck.push(c21);
		deck.push(c22);
		deck.push(c23);
		deck.push(c24);
		deck.push(c25);
		deck.push(c26);
		deck.push(c27);
		deck.push(c28);
		deck.push(c29);
		deck.push(c30);
		deck.push(c31);
		deck.push(c32);
		deck.push(c33);
		deck.push(c34);
		deck.push(c35);
		deck.push(c36);
		deck.push(c37);
		deck.push(c38);
		deck.push(c39);
		deck.push(c40);
		deck.push(c41);
		deck.push(c42);
		deck.push(c43);
		deck.push(c44);
		deck.push(c45);
		deck.push(c46);
		deck.push(c47);
		deck.push(c48);
		deck.push(c49);
		deck.push(c50);
		deck.push(c51);
		deck.push(c52);
	}

	public Pile getDeck(){
		return deck;
	}
	public void setDeck(Pile d){
		deck = d;
	}

	/**
	 * This method returns all the cards from the dealer and the 
	 * player to the deck, then shuffles the deck for a new hand
	 * @param Pile player (players hand)
	 * @param Pile dealer (dealers hand)
	 */
	public static Pile resetDeck(Pile player, Pile dealer){
		
		while(!player.isEmpty()){
			deck.push(player.getCard(0));
				player.removeFront();
		}
		
		while(!dealer.isEmpty()){
			deck.push(dealer.getCard(0));
				dealer.removeFront();
			
			
		}
		
		deck = Pile.shuffle(deck);
		return deck;
	}
		/**
		 * Distributes a card from the deck to a player 
		 * or the dealer.
		 * @param deck
		 * @param player
		 */
		public void dealCard(Pile player){
			if(deck.isEmpty())
				throw new NullPointerException();
			player.push(deck.getCard(0));
			deck.removeFront();
			
		}
}
