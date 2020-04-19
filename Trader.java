/**
 * 
 * @author Erina Lara, Eric Truong
 * Date: April 23, 2020
 * Program: Creates a trader in the stock market who will be able to buy stocks, sell stocks, and be notified of other trader's activities
 *
 */
public class Trader implements Observer {
	
	/**
	 * Name of trader
	 */
	private String trader;
	
	/**
	 * Creates a trader
	 * @param name	name of the trader
	 */
	public Trader(String name) {
		
		trader = name;
	}
	
	/**
	 * Gets the name of the trader
	 * @return	trader's name
	 */
	public String getName() {
		
		return trader;
	}
	
	/**
	 * Get the stock that is being changed
	 */
	public void update(Object newState) {
		
		// Cast the parameter to a stock and call it's display function to show the message
		Stock latestChange = (Stock) newState;
		display(latestChange);
	}
	
	/**
	 * Display a message of what is happening to the stock
	 * @param latestStock	stock that has been changed
	 */
	public void display(Stock latestStock) {
		
		// Calls stock's toString to print the update message
		System.out.println(latestStock);
	}
	
	@Override
	public String toString() {
		
		return trader;
	}
}
