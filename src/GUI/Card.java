package GUI;

public class Card {
	enum Suit{
		Hearts, Spades, Clubs, Diamonds;
	}
	
	enum Rank{
		Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King;
	}
	
	private Suit suit;
	private Rank rank;
	private int value;
	public Card(){
		
	}
	
	public Card(Suit s, Rank r, int v){
		suit = s;
		rank = r;
		value = v;
		
	}
	
	public Suit getSuit(){
		return this.suit;
	}
	
	public Rank getRank(){
		return this.rank;
	}
	
	public int getValue(){
		return this.value;
	}
	public void setSuit(Suit s){
		this.suit = s;
	}
	public void setRank(Rank r){
		this.rank = r;
	}
	public void setValue(int v){
		this.value = v;
	}
	
	public String toString(){
		return rank+" of "+suit;
	}
}
