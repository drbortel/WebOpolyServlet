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
	GameController game = new GameController();
	ArrayList<Player> players = new ArrayList<>();
    /**
     * Default constructor. 
     */
    public WebOpolyServlet() {
        // TODO Auto-generated constructor stub
    }

    public void init() 
    {    	
    	players = game.getPlayers();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	//response.getWriter().append("<h4 style='color: silver;text-align: left;'>Served at: ").append(request.getContextPath());
    	response.setContentType("text/html");
    	response.setIntHeader("Refresh", 3);
    	
    	String CT = getTimeInfo();

    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();

    	String numPlayers = setPlayerLimit(request);

    	String startMoney = request.getParameter("startMoney");
    	int startMoneyInt = Integer.parseInt(startMoney);
    	System.out.println("startMoney is " +startMoneyInt);
    	
    	setPlayerStartMoney(players, startMoneyInt);

    	game.playGame();    	
    	
    	buildPageHeader(request, response, out, numPlayers, startMoney);
    	
    	generateTimeStamp(CT, out);
    	
    	buildProgressTable(out, players);
    	
    	game.setRefreshFlag(false);
    	/*if (game.isGameWinner()) {
    		request.getRequestDispatcher(getServletInfo()).forward (request, "./game.html");
    	}*/
    }

	private void buildProgressTable(PrintWriter out, ArrayList<Player> players) {
		int playerLimit;
		out.println("<TABLE align=center style='width:75%'>");
    	//debug setting
    	playerLimit = 3;
    	for(int i=0; i<playerLimit; i++){
        	out.println(
        			"<TR><TD style='color: white;font-family: cursive;text-align: center;'>" +
        			"Balance for " + players.get(i).getName() +
        			": "
        			//);
        			+ "</TD>");
        	if (players.get(i).getNetworth() > 0) {
           		out.println(
           				"<TD style='color: red;font-family: cursive;text-align: left;'>" +
           				"$ " + players.get(i).getNetworth()
           				+ "</TD></TR>"
           				);        		
        	}
        	else
        	{
       		out.println(
       				"<TD style='color: red;font-family: cursive;text-align: left;'>" +
       				"Bankrupt!"
       				+ "</TD></TR>"
       				);
        	}
        	if ( game.isGameWinner()) {
        		out.println("<TR><TD>Congrats " + players.get(0).getName() + " !</TD></TR>");
            }
    	}
     	out.println("</TABLE>");
     	out.println("<BR><BR></BODY></HTML>");
    	out.close();
	}

	private void generateTimeStamp(String CT, PrintWriter out) {
		out.println("<h2 style='color: white;font-weight: bolder;text-align: center;'>WebOpoly Game Progress</h2>");
    	out.println("<BR><h2 style='color:white; text-align: left;'>Current Time is: " + CT + "</h2><BR><BR>");
    	out.println("<h3>Balance Updates every 5 seconds</h3>");
	}

	private void buildPageHeader(HttpServletRequest request, HttpServletResponse response, PrintWriter out,
			String numPlayers, String startMoney) throws IOException {
		out.println("<HTML>");
    	out.println("<HEAD><TITLE>WebOpoly Game</TITLE></HEAD>");
    	out.println("<BODY style='background-color: navy;color: white;'>");
    	response.getWriter().append("<h4 style='color: silver;text-align: left;'>Served at: ").append(request.getContextPath());
    	out.println("<BR><BR><BR>");
    	out.println("<h3 style='color: white;font-family: cursive;text-align: left;'>You have " + numPlayers + " players!</h3>");
    	out.println("<h3 style='color: white;font-family: cursive;text-align: left;'>Players have " + startMoney + " starting money!</h3><BR><BR>");
    	out.println("<IMG SRC='images/man1.jpg'><BR>");
	}

	private String setPlayerLimit(HttpServletRequest request) {
		@SuppressWarnings("unused")
		int playerLimit = 4;
		String numPlayers = request.getParameter("numPlayers");
    	switch (numPlayers) {
    	case "2":
    		playerLimit = 2;
    		break;
    	case "3":
    		playerLimit = 3;
    		break;
    	case "4":
    		playerLimit = 4;
    		break;
    	case "missing":
    		playerLimit = 3;
    		break;    	}
		return numPlayers;
	}

	private String getTimeInfo() {
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
		return CT;
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    
    public void setPlayerStartMoney(ArrayList<Player> players, int money)
    {
    	for (Player player: players)
    	{
    		player.setDEFAULT_START_VALUE(money);
    		System.out.println("Player has " + player.getNetworth() +" money.");
    	}
    }
  
}
