package com.usaa.webopoly;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.GameController;
import main.Player;

/**
 * Servlet implementation class WebOpolyServlet
 */
@WebServlet(name = "WebOpoly1Servlet", urlPatterns = { "/WebOpoly1Servlet" })
public class WebOpolyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WebOpolyServlet() {
        // TODO Auto-generated constructor stub
    }

    public void init() 
    {
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	response.getWriter().append("<h4 style='color: silver;text-align: left;'>Served at: ").append(request.getContextPath());
    	response.setIntHeader("UpdateTime", 5);
    	response.setContentType("text/html");
    	
	    PrintWriter out = response.getWriter();

    	response.setContentType("text/html");
    	//PrintWriter out = response.getWriter();
    	
    	String numPlayers = request.getParameter("numPlayers");
    	String startMoney = request.getParameter("startMoney");
    	
    	out.println("<HTML>");
    	out.println("<HEAD><TITLE>WebOpoly Game</TITLE></HEAD>");
    	out.println("<BODY style='background-color: navy';><BR><BR><BR>");
       	out.println("<h3 style='color: white;font-family: cursive;text-align: left;'>You have " + numPlayers + " players!<BR>");
    	out.println("<h3 style='color: white;font-family: cursive;text-align: left;'>Players have " + startMoney + " starting money!<BR><BR>");
     	out.println("<IMG SRC='man1.jpg'><BR>");
     	//out.println("<a href='game.html' style='color:red';>Launch Game</a><BR>");
     	
     	/* Launch Game */
     	GameController game = new GameController();
		game.playGame();
		
		ArrayList<Player> players = new ArrayList<>();
		players = game.getPlayers();
     	
    	//out.println("or <a href='index.html' style='color:red';>Go Back</a><BR>");
    	out.println("<h2 style='color: white;font-weight: bolder;text-align: center;'>WebOpoly Game Progress</h2>");
    	out.println("<BR><BR><h3><TABLE align=center style='width:75%'>");

    	if ( players.get(0).getNetworth() >= 0 ) {
        	out.println("<TR><TD style='color: white;font-family: cursive;text-align: center;'>Player 1 Balance: ");
        	out.println("</TD><TD style='color: red;font-family: cursive;text-align: left;'>" + players.get(0).getNetworth() + "</TD>");
    	}
    	if ( players.get(1).getNetworth() >= 0 ) {
        	out.println("<TR><TD style='color: white;font-family: cursive;text-align: center;'>");
        	out.println("<TD style='color: white;font-family: cursive;text-align: center;'>Player 2 Balance: ");
        	out.println("</TD><TD style='color: red;font-family: cursive;text-align: left;'>" + players.get(1).getNetworth() + "</TD></TR><TR>");
    	}
    	if ( players.get(2).getNetworth() >= 0 ) {
        	out.println("<TD style='color: white;font-family: cursive;text-align: center;'>Player 3 Balance: ");
        	out.println("</TD><TD style='color: red;font-family: cursive;text-align: left;'>" + players.get(2).getNetworth() + "</TD>");
    	}
    	out.println("<TD style='color: white;font-family: cursive;text-align: center;'>");
    	out.println("Player 4 Balance: </TD><TD style='color: red;font-family: cursive;text-align: left;'>Out</TD></TR>");
    	out.println("</TABLE></h3><BR><BR>");
    	out.println("<h3 style='color: white;font-weight: bolder;text-align: center;'>");
    	out.println("Balance Updates every 10 seconds</h3>");
     	out.println("</BODY></HTML>");
     	out.close();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
  
}
