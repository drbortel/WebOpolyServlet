package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class GUI extends JFrame
{

	private static final long serialVersionUID = -7751729052798952859L;

	public GUI()
	{
		setTitle("DallOpoly");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1,1);
		setVisible(true);

		setLayout(new GridLayout(0,12));
		
	}
	
	public void draw(Board b,ArrayList<Player> players) {
		int[] maper = {0,1,2,3,4,5,6,7,8,9,10,11,39,12,38,13,37,14,36,15,35,16,34,17,33,18,32,19,31,30,29,28,27,26,25,24,23,22,21,20};		
		
		this.getContentPane().removeAll();
		int counter = 0;
		String markers;
		String ownerColor = "";
		for(int i = 0; i < 120; i++) {
			markers = "";
			
			for(Player p : players) {
				if(p.getPosition() == maper[counter] && !p.isOut) {
					markers += "<span style=\"color: " + p.getColor() + "; \">•" + p.getName() + "</span><br>";
				}
			}
			
			if(b.getTile(maper[counter]).getOwnedBy() != null ) {
				ownerColor = b.getTile(maper[counter]).getOwnedBy().getColor();
			} else {
				ownerColor = "#cccccc";
			}
			
			if((i < 12) || (i > 107 && i < 120) || (0 == i % 12) || (0 == (i - 11) % 12)) {
				JLabel l = new JLabel("<html><div style=\"text-align: center; border: 4px solid " + ownerColor + "; width: 65px; height: 65px;\">" 
			+ maper[counter] + "<br>"
		    + "$" + b.getTile(maper[counter]).getCost() + "<br>"
			+ markers +  "</div></html>");
				
				add(l);
				counter++;
			}
			
			else
				add(new JLabel());
			
			
		}
		
		setSize(1050,900);
		this.getContentPane().revalidate();
	}
	
	
}
