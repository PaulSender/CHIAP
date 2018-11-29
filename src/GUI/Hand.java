package GUI;

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
