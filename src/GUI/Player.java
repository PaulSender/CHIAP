package GUI;


import GUI.Hand;

/**
 * This class creates a player that can be assigned for a card game.
 * A player can have a name, and a hand of cards.
 * 
 * @author Jeff Gore, Randy Ryan, Kyle Mcdevitt
 *
 */
public class Player {
	private String name;
	private Hand hand;

	public Player(String name, Hand hand){
		this.hand = hand;
		this.name = name;
	}
	public Player(String name){
		hand = new Hand();
		this.name = name;
	}
	public Player(){
		
	}

	public Hand getHand(){
		return this.hand;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}
	public void setHand(Hand hand){
		this.hand = hand;
	}

	}


