package main;

import java.util.ArrayList;
import java.util.Random;

public class Board {
	public ArrayList<Tile> tiles = new ArrayList<Tile>();

	public Board() {
		System.out.println("Board Created");
		addTiles();
	}
	
	public Tile getTile(int i) {
		return tiles.get(i);
	}
	
	public int getBoardSize() {
		return tiles.size();
	}
	
	public void addTiles() {
		Random r = new Random();
		
		for(int i = 0; i < 40; i++ ) {
			tiles.add(new Tile(Math.abs((r.nextInt() % 20) * 10) + 30,i));
		}
		
		tiles.add(new Jail(0));
	}

}
