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
    	//response.getWriter().append("<h4 style='color: silver;text-align: left;'>Served at: ").append(request.getContextPath());
    	response.setContentType("text/html");
    	response.setIntHeader("Refresh", 5);

    	// Get current time
    	Calendar calendar = new GregorianCalendar();
    	String am_pm;
    	int hour = calendar.get(Calendar.HOUR);
    	int minute = calendar.get(Calendar.MINUTE);
    	int second = calendar.get(Calendar.SECOND);
    	String minuteStr = String.format("%02d", minute);
    	String secondStr = String.format("%02d", second);

    	if(calendar.get(Calendar.AM_PM) == 0)
    		am_pm = "AM";
    	else
    		am_pm = "PM";

    	String CT = hour+":"+ minuteStr +":"+ secondStr +" "+ am_pm;

    	//		  PrintWriter out = response.getWriter();
    	//	      String title = "Auto Page Refresh using Servlet";
    	//	      String docType =
    	//	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
    	//	      "transitional//en\">\n";
    	//	      out.println(docType +
    	//	        "<html>\n" +
    	//	        "<head><title>" + title + "</title></head>\n"+
    	//	        "<body bgcolor=\"#f0f0f0\">\n" +
    	//	        "<h1 align=\"center\">" + title + "</h1>\n" +
    	//	        "<p>Current Time is: " + CT + "</p>\n");

    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();

    	String numPlayers = request.getParameter("numPlayers");
    	String startMoney = request.getParameter("startMoney");

    	/* Launch Game */
    	GameController game = new GameController();
    	game.playGame();
    	ArrayList<Player> players = new ArrayList<>();
    	players = game.getPlayers();
    	
    	out.println("<HTML>");
    	out.println("<HEAD><TITLE>WebOpoly Game</TITLE></HEAD>");
    	out.println("<BODY style='background-color: navy;color: white;'>");
    	response.getWriter().append("<h4 style='color: silver;text-align: left;'>Served at: ").append(request.getContextPath());
    	out.println("<BR><BR><BR>");
    	out.println("<h3 style='color: white;font-family: cursive;text-align: left;'>You have " + numPlayers + " players!</h3>");
    	out.println("<h3 style='color: white;font-family: cursive;text-align: left;'>Players have " + startMoney + " starting money!</h3><BR><BR>");
    	out.println("<IMG SRC='images/man1.jpg'><BR>");
    	
    	out.println("<h2 style='color: white;font-weight: bolder;text-align: center;'>WebOpoly Game Progress</h2>");
    	out.println("<BR><h2 style='color:white; text-align: left;'>Current Time is: " + CT + "</h2><BR><BR>");

    	out.println("<TABLE align=center style='width:75%'>");
    	out.println(
    			"<TR><TD style='color: white;font-family: cursive;text-align: center;'>" +
    			"Balance for " + players.get(0).getName() +
    			": "
    			//);
    			+ "</TD>");
   		out.println(
   				"<TD style='color: red;font-family: cursive;text-align: left;'>" +
   				"$ " + players.get(0).getNetworth()
   				+ "</TD></TR>"
   				);
   		out.println(
   				"<TR><TD style='color: white;font-family: cursive;text-align: center;'>" +
   				"Balance for " + players.get(1).getName() +
    			": "
    			//);
    			+ "</TD>");
   		out.println(
   				"<TD style='color: red;font-family: cursive;text-align: left;'>" +
   				"$ " + players.get(1).getNetworth()
   				+ "</TD></TR>"
   				);  		
   		out.println(
   				"<TR><TD style='color: white;font-family: cursive;text-align: center;'>" +
   				"Balance for " + players.get(1).getName() +
    			": "
    			//);
    			+ "</TD>");
   		out.println(
   				"<TD style='color: red;font-family: cursive;text-align: left;'>" +
   				"$ " + players.get(1).getNetworth()
   				+ "</TD></TR>"
   				);	
     	out.println("</TABLE>");
     	
    	out.println("<BR><BR><h3 style='color: white;font-weight: bolder;text-align: center;'>");
    	out.println("Balance Updates every 10 seconds</h3>");
    	out.println("</BODY></HTML>");
    	out.close();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
  
}
