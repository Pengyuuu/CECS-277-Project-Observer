/**
 * 
 * @author Erina Lara, Eric Truong
 *
 */
public class Tester {
	
	public static void main (String[] args) {
		
		Trader julie = new Trader("Julie");
		Trader amy = new Trader("Amy");
		Trader john = new Trader("John");
		Trader michael = new Trader("Michael");
		Trader krisna = new Trader("Krisna");
		Stock apple = new Stock("AAPL", 282.80);
		Stock google = new Stock("GOOG", 1283.25);
		Stock starbucks = new Stock("SBUX", 77.10);
		
		apple.addObserver(julie);
		apple.addObserver(amy);
		apple.addObserver(john);
		google.addObserver(julie);
		google.addObserver(amy);
		starbucks.addObserver(julie);
		starbucks.addObserver(amy);
		starbucks.addObserver(krisna);
		
		starbucks.buyStock(krisna);
	}

}
