package GUI;

import GUI.CardListInterface;
import GUI.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class Pile implements CardListInterface {

	Node topCard;
	Node bottomCard;

	private class Node {
		Card data;
		Node prev;
		Node next;

		public Node(Card c) {
			data = c;
		}

		public Card getData() {
			return data;
		}

		public Node getNext() {
			return this.next;
		}

		public Node getPrev() {
			return this.prev;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

	}

	public void push(Card data) {
		Node newNode = new Node(data);
		newNode.next = topCard;
		newNode.prev = null;
		if (topCard != null) {
			topCard.prev = newNode;
		}
		topCard = newNode;

	}

	public void push(Node prevNode, Card data) {
		if (prevNode == null) {
			System.out.println("The previous node cant be null");
			return;
		}
		Node newNode = new Node(data);
		newNode.next = prevNode.next;
		prevNode.next = newNode;
		newNode.prev = prevNode;
		if (newNode.next != null) {
			newNode.next.prev = newNode;
		}
	}

	public void append(Card data) {
		Node newNode = new Node(data);
		Node last = topCard;
		newNode.next = null;
		if (topCard == null) {
			newNode.prev = null;
			topCard = newNode;
			return;
		}
		while (last.next != null) {
			last = last.next;
		}
		last.next = newNode;
		newNode.prev = last;

	}

	public void printlist(Node node) {
		Node last = null;
		System.out.println("Traversal in forward Direction");
		while (node != null) {
			System.out.print(node.data + " ");
			last = node;
			node = node.next;
		}
		System.out.println();
		System.out.println("Traversal in reverse direction");
		while (last != null) {
			System.out.print(last.data + " ");
			last = last.prev;
		}
	}

	public void deleteNode(Node head_ref, Node del) {

		/* base case */
		if (topCard == null || del == null) {
			return;
		}

		/* If node to be deleted is head node */
		if (topCard == del) {
			topCard = del.next;
		}

		/* Change next only if node to be deleted is NOT the last node */
		if (del.next != null) {
			del.next.prev = del.prev;
		}

		/* Change prev only if node to be deleted is NOT the first node */
		if (del.prev != null) {
			del.prev.next = del.next;
		}

		/* Finally, free the memory occupied by del */
		return;
	}

	public int getLength() {
		int numEntries = 0;
		Node currNode;
		for (currNode = topCard; currNode != null; currNode = currNode.next) {
			numEntries++;
		}
		return numEntries;
	}

	public Card getCard(int givenPosition) {
		if (givenPosition < 0 || givenPosition >= this.getLength())
			throw new IndexOutOfBoundsException();

		Node currNode = topCard;
		for (int i = 0; i <= givenPosition; i++) {
			if (i == givenPosition)
				return currNode.getData();

			currNode = currNode.getNext();
		}
		return null;
	}

	public void remove(int index) {
		int i = 0;
		// negative indexes are always invalid
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		for (Node current = topCard.getNext(); current != topCard; current = current.getNext()) {
			if (i == index) {
				Node previous = current.getPrev();
				Node next = current.getNext();

				previous.setNext(next);
				next.setPrev(previous);
				// maybe you need count for something else, but not for this
				// count -= 1;

			}

			i += 1;
		}

		// If control reaches here then the given index is invalid
		throw new IndexOutOfBoundsException();
	}

	public Node removeBack() {
		if (this.getLength() == 0)
			throw new NoSuchElementException();
		Node tmp = bottomCard;
		bottomCard = bottomCard.prev;
		bottomCard.next = null;

		System.out.println("deleted: " + tmp);
		return tmp;
	}

	public Node removeFront() {
		Node result = null;
		if (topCard != null) {

			result = bottomCard;
			if (topCard.next != null) {
				topCard.next.prev = null;
				topCard = topCard.next;
			} else {
				topCard = null;
				bottomCard = null;
			}
		}
		return result;
	}

	public boolean contains(Card anEntry) {
		Node currNode = topCard;
		for (; currNode != null; currNode = currNode.next) {
			if (currNode.data == anEntry) {
				return true;
			}
		}
		return false;
	}

	public void clear() {
		while (!this.isEmpty()) {
		}
	}

	public boolean isEmpty() {
		return topCard == null;
	}

	/**
	 * Shuffles the deck of cards
	 * 
	 * @param Pile
	 *            (full deck of cards)
	 * @return the shuffled deck of cards
	 */
	public static Pile shuffle(Pile p) {
		// Random r = new Random();
		Pile newPile = new Pile();
		ArrayList<Card> list = new ArrayList<Card>();

		for (int i = 0; i < p.getLength(); i++) {
			list.add(p.getCard(i));
		}
		Collections.shuffle(list);
		for (int i = 0; i < list.size(); i++) {
			newPile.push(list.get(i));
		}
		return newPile;

	}

	/**
	 * Method is used to compare the values of cards
	 * 
	 * @param Dealer
	 *            value of card(s)
	 * @param Player
	 *            value of card(s)
	 * @return Player wins if dealer busts and player does not,
	 */
	public static String whoWon(Pile dealer, Pile player) {
		if (player.bust() == true && dealer.bust() == false) {
			return ("You bust, Dealer wins!");
		} else if (player.bust() == false && dealer.bust() == true) {
			return ("Dealer bust, You win!");
		} else if (dealer.valueOfHand() > player.valueOfHand() && dealer.bust() == false) {
			return ("Dealer won!");
		} else if (player.valueOfHand() > dealer.valueOfHand() && player.bust() == false) {
			return ("You won!");
		}

		else if (player.valueOfHand() == dealer.valueOfHand()) {
			return ("Push!");
		}

		return ("Both you and the Dealer bust!");
	}

	/**
	 * Gets the value of the players hand
	 * 
	 * @param Pile
	 *            (player or dealers hand)
	 * @return the total of all the cards in the hand
	 */
	public int valueOfHand() {
		int total = 0;
		for (int i = 0; i < this.getLength(); i++) {
			total += this.getCard(i).getValue();
		}
		return total;
	}

	/**
	 * This class returns whether or not the player/dealer has busted(over 21)
	 * 
	 * @return true if the hand is over 21, false otherwise
	 */
	public boolean bust() {
		return this.valueOfHand() > 21;
	}

	public static void main(String[] args) {

		// Creating piles for deck dealer and player, as well
		// as a few cards just for testing
		Pile pile = new Pile();
		Pile player = new Pile();
		Pile dealer = new Pile();
		Card c1 = new Card(Card.Suit.Clubs, Card.Rank.Ace, 1);
		Card c2 = new Card(Card.Suit.Hearts, Card.Rank.Jack, 11);
		Card c3 = new Card(Card.Suit.Spades, Card.Rank.Three, 3);
		Card c4 = new Card(Card.Suit.Hearts, Card.Rank.Queen, 12);
		Card c5 = new Card(Card.Suit.Diamonds, Card.Rank.Ten, 10);
		// push the cards into the deck
		pile.push(c1);
		pile.push(c2);
		pile.push(c3);
		pile.push(c4);
		pile.push(c5);

		// Shuffle the deck before deal
		pile = Pile.shuffle(pile);
		System.out.println("Deck after shuffle: ");
		for (int i = 0; i < pile.getLength(); i++) {
			System.out.println(pile.getCard(i));
		}

		// deal one card to each player for testing

		player.push(pile.getCard(0));
		pile.removeFront();
		dealer.push(pile.getCard(0));
		pile.removeFront();
		System.out.println("Players Card: ");
		System.out.println(player.getCard(0));
		System.out.println("Dealers Card: ");
		System.out.println(dealer.getCard(0));
		System.out.println("Who had the higher card? ");
		System.out.println(Pile.whoWon(dealer, player));

	}
}
