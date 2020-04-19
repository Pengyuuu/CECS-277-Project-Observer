import java.util.ArrayList;

/**
 * 
 * @author Erina Lara, Eric Truong
 * Date: April 23, 2020
 * Program: Creates a stock in the stock market that a trader could buy or sell
 *
 */

// This is the product
public class Stock implements Subject {

	/**
	 * List of observers
	 */
	private ArrayList<Observer> observers;
	
	/**
	 * Name of the stock
	 */
	private String name;
	
	/**
	 * Labels if the stock is being bought or sold
	 */
	private String state;
	
	/**
	 * Current price of the stock
	 */
	private double price;
	
	/**
	 * Trader that owns part of the stock
	 */
	private String owner;
	
	/**
	 * Default constructor for the stock
	 */
	public Stock () {
		name = "";
		state = "";
		owner = "";
		price = 0.0;
		observers = new ArrayList<>();
	}
	
	/**
	 * Creates a new stock
	 * @param name	name of the stock
	 * @param price	stock's current price
	 */
	public Stock(String name, double price) {
		
		this.name = name;
		state = "";
		owner = "";
		this.price = price;
		observers = new ArrayList<>();
	}
	
	/**
	 * Gets the name of the stock
	 * @return	stock's name
	 */
	public String getName() {
		
		return name;
	}
	
	/**
	 * Gets the state of the stock
	 * @return	whether the stock is being bought or sold
	 */
	public String getState() {
		
		return state;
	}
	
	/**
	 * Gets current price of the stock
	 * @return	stock's current price
	 */
	public double getPrice() {
		
		return price;
	}
	
	/**
	 * Allows a trader to buy a portion of the stock
	 * @param trader	person buying the stock
	 */
	public void buyStock(Trader trader) {
		
		// Give the stock a owner and set it's state to bought
		owner = trader.getName();
		state = "bought";
		
		// Send out an update to everyone who has subscribed to the stock
		notifyObservers();
	}
	
	/**
	 * Allows a trader to sell their portion of the stock
	 * @param trader	person selling the stock
	 */
	public void sellStock(Trader trader) {
		
		// Give the stock a owner and set it's state to sold
		owner = trader.getName();
		state = "sold";
		
		// Send out an update to everyone who has subscribed to the stock
		notifyObservers();
	}
	
	/**
	 * Adds a trader to the subscription list
	 */
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	/**
	 * Removes a trader from the subscription list
	 */
	public void removeObserver(Observer o ) {
		observers.remove(o);
	}
	
	/**
	 * Notifies subscribers of a stock of any updates
	 */
	public void notifyObservers() {
		
		// For every person subscribed to the stock
		for (int i = 0; i <observers.size(); i++) {
			
			// Get the trader at the current index and call their update function
			Observer obs = observers.get(i);
			obs.update(this);
			
			// Show what person has been notified
			System.out.println(" Notified " + observers.get(i));
		}
	}
	
	/**
	 * Prints out a statement of the trader that has bought or sold a stock
	 */
	@Override
	public String toString() {
		
		return " " + owner + " has " + state + " $" + price + " of " + name;
	}
}
