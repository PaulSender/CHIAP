package GUI;


import GUI.Card;


public interface CardListInterface {

	/**
	 * Adds a new Card to the list
	 * 
	 * @param A
	 *            Card
	 */
	public void push(Card newCard);

	/**
	 * Adds a new card at a specified position
	 * 
	 * @param An
	 *            integer for position and a Card
	 */

	public void remove(int givenPosition);

	/**
	 * removes all cards from the list
	 */
	public void clear();

	/**
	 * Gets a Card at a given position
	 * 
	 * @param int
	 *            givenPosition
	 * @return the Card at that position
	 */
	public Card getCard(int givenPosition);

	/**
	 * See if a given card is in the list
	 * 
	 * @param aCard
	 * @return true if the card is found, false otherwise
	 */
	public boolean contains(Card aCard);

	/**
	 * Gets the length of the card list
	 * 
	 * @return the length
	 */
	public int getLength();

	/**
	 * Determines if the list is empty
	 * 
	 * @return true if the list is empty, false otherwise
	 */
	public boolean isEmpty();

}
