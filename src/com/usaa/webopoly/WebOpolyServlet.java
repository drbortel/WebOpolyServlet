package com.usaa.webopoly;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.GameController;

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

    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	
    	String numPlayers = request.getParameter("numPlayers");
    	String startMoney = request.getParameter("startMoney");
    	
    	out.println("<HTML>");
    	out.println("<HEAD><TITLE>Start Info for Game</TITLE></HEAD>");
    	out.println("<BODY style='background-color: navy';><BR><BR><BR>");
       	out.println("<h3 style='color: white;font-family: cursive;text-align: left;'>You have " + numPlayers + " players!<BR>");
    	out.println("<h3 style='color: white;font-family: cursive;text-align: left;'>Players have " + startMoney + " starting money!<BR><BR>");
     	out.println("<IMG SRC='man1.jpg'><BR>");
     	//out.println("<a href='game.html' style='color:red';>Launch Game</a><BR>");
     	
     	/* Launch Game */
     	GameController game = new GameController();
		game.playGame();
     	
    	//out.println("or <a href='index.html' style='color:red';>Go Back</a><BR>");
    	out.println("<h2 style='color: white;font-weight: bolder;text-align: center;'>WebOpoly Game Progress</h2>");
    	out.println("<BR><BR><h3><TABLE align=center style='width:75%'>");
    	out.println("<TR><TD style='color: white;font-family: cursive;text-align: center;'>");
    	out.println("Player 1 Balance: </TD><TD style='color: red;font-family: cursive;text-align: left;'>500</TD>");
    	out.println("<TD style='color: white;font-family: cursive;text-align: center;'>");
    	out.println("Player 2 Balance: </TD><TD style='color: red;font-family: cursive;text-align: left;'>600</TD></TR><TR>");
    	out.println("<TD style='color: white;font-family: cursive;text-align: center;'>");
    	out.println("Player 3 Balance: </TD><TD style='color: red;font-family: cursive;text-align: left;'>400</TD>");
    	out.println("<TD style='color: white;font-family: cursive;text-align: center;'>");
    	out.println("Player 4 Balance: </TD><TD style='color: red;font-family: cursive;text-align: left;'>550</TD></TR>");
    	out.println("</TABLE></h3><BR><BR>");
    	out.println("<h3 style='color: white;font-weight: bolder;text-align: center;'>");
    	out.println("Balance Updates every 10 seconds</h3>");
     	out.println("</BODY></HTML>");
     	out.close();
    }
  
}
