
public class Trader implements Observer {
	
	private String trader;
	
	public Trader(String name) {
		
		trader = name;
	}
	
	public String getName() {
		
		return trader;
	}
	
	public void update(Object newState) {
		Stock latestChange = (Stock) newState;
		display(latestChange);
	}
	
	public void display(Stock latestStock) {
		System.out.println(latestStock);
	}
}
