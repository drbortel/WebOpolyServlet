package com.usaa.webopoly;

import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    	out.println("<a href='game.html' style='color:red';>Launch Game</a><BR>");
    	out.println("or <a href='index.html' style='color:red';>Go Back</a><BR>");
     	out.println("</BODY></HTML>");
     	out.close();
    }
  
}
