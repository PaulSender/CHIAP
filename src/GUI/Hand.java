package GUI;

/**
 * This class creates a Hand for a Player.
 * The hand has a Pile variable and is used to give the player the ability to hold cards
 * @author Jeff Gore, Randy Ryan, Kyle Mcdevitt
 *
 */
public class Hand extends Pile {
	
	private Pile cards;
	
	public Hand(Pile cards){
		this.cards = cards;
	}
	
	public Hand(){
		cards = new Pile();
	}
	
	public Pile getCards(){
		return this.cards;
	}
	
	public void setCards(Hand cards){
		this.cards = cards;
	}
}
