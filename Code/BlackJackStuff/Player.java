package GUI;


import GUI.Hand;

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


