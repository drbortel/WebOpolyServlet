package main;

import java.util.Random;

public class Die {
	public final static int DEFAULT_NUMBER_OF_FACES = 6;
	public final static int MINIMUM_NUMBER_OF_FACES = 2;
	
	private int numberOfFaces = -1;

	public Die() throws TooFewDieFacesException {
		setNumberOfFaces(DEFAULT_NUMBER_OF_FACES);
	}
	
	public void setNumberOfFaces(int i) {
		numberOfFaces = i;
	}
	
	public int roll() {
		Random r = new Random();
		
		return Math.abs(r.nextInt() % numberOfFaces) + 1;
	}
	
	public int roll(int rolls) {
		int total = 0;
		
		for(int i = 0; i < i; i++ ) {
			total += roll();
		}
		
		return total;
	}

}

