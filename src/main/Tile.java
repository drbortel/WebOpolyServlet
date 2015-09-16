package main;

public class Tile {

	private Player ownedBy = null;

	private int costToBuy = -1;

	private int tileId = -1;

	private int houses = 0;

	public int calculateRent() {
		return (int)(costToBuy * 0.1) * (houses + 1);
	}

	public Tile(int cost,int id) {
		System.out.println("Tile created cost: " + cost + " id: " + id);
		costToBuy = cost;
		tileId = id;
	}

	public int getCost() {
		return costToBuy;
	}

	public Player getOwnedBy() {
		return ownedBy;
	}

	public void action() {

	}
	
	public void vacate() {
		ownedBy = null;
	}
	
	public boolean visitedBy(Player p) {
		if(p.getId() != ownedBy.getId()) {
			p.charge(calculateRent(), ownedBy);
		} else {
			houses++;
		}
		
		
		return false;
	}

	public boolean buy(Player p,Bank b) {
		//Available and able to buy
		if(p.getNetworth() >= costToBuy ) {
			ownedBy = p;
			p.charge(costToBuy,b);
			return true;
		} 

		return false;
	}

}
