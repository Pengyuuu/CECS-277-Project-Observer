import java.util.ArrayList;

// This is the product
public class Stock implements Subject {

	private ArrayList<Observer> observers;
	private String name;
	private String state;
	private double price;
	private String owner;
	
	public Stock () {
		name = "";
		owner = "";
		price = 0.0;
		observers = new ArrayList<>();
	}
	
	public Stock(String name, double price) {
		
		this.name = name;
		this.price = price;
		observers = new ArrayList<>();
	}
	
	public String getName() {
		
		return name;
	}
	
	public String getState() {
		
		return state;
	}
	
	public double getPrice() {
		
		return price;
	}
	
	public void buyStock(Trader trader) {
		owner = trader.getName();
		state = "bought";
		notifyObservers();
	}
	
	public void sellStock(Trader trader) {
		owner = trader.getName();
		state = "sold";
		notifyObservers();
	}
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o ) {
		observers.remove(o);
	}
	
	public void notifyObservers() {
		
		for (int i = 0; i <observers.size(); i++) {
			Observer obs = observers.get(i);
			obs.update(obs);
			System.out.print(" Notified " + observers.get(i));
		}
	}
	
	@Override
	public String toString() {
		
		return owner + " has " + state + " $" + price + " of " + name;
	}
}
