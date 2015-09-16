package main;

public class Bank extends Player {
	
	private static final int DEFAULT_START_VALUE = 10000;
	
	public Bank(String n,int i,String colorIn) {
		super(n,i,colorIn);
		super.money = DEFAULT_START_VALUE;
	}
	
}
