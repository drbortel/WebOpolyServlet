package main;

import java.util.ArrayList;

//import com.sun.prism.paint.Color;

public class Player {

	public static final int DEFAULT_START_VALUE = 200;

	private String color;

	private String name;

	private int playerId = -1;

	protected int money;

	private int position;

	private DieCup die;
	
	private ArrayList<DieCup> rollHistory;
	
	public boolean isOut;

	public Player(String n,int i,String colorIn) {
		rollHistory = new ArrayList<DieCup>();
		isOut = false;
		color = colorIn;
		playerId = i;
		name = n;
		money = DEFAULT_START_VALUE;
		position = 0;
		die = new DieCup();


		System.out.println(name + " created.");
	}

	public String getColor() {
		return color;
	}
	
	public ArrayList<DieCup> getRollHistory() {
		return rollHistory;
	}

	// jenna
	public void charge(int m, Player to) {
		money -= m;
		to.pay(m);
	}

	// jenna
	public void pay(int m) {
		money = money + m;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return playerId;
	}

	public int getNetworth() {
		return money;
	}

	public int getPosition() {
		return position;
	}

	public void takeTurn() {
		int roll = die.roll();
		rollHistory.add(die);
		position = (position + roll) % 40; 
	}

}

