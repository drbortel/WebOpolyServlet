package main;

public class DieCup {
	public final static int MIN_TOTAL = 2;
	public final static int MAX_TOTAL = 12;
	
	private int roll1;
	private int roll2;

	private Die die;

	public DieCup() {
		
	}
	
	public int getRoll1() {
		return roll1;
	}
	
	public int getRoll2() {
		return roll2;
	}

	public int roll() {
		int total = 0;
		
		try {
			Die die = new Die();
			roll1 = die.roll();
			roll2 = die.roll();
			total = roll1 + roll2;
		} catch (TooFewDieFacesException e) {
			e.printStackTrace();
		}
		
		return total;
	}

}