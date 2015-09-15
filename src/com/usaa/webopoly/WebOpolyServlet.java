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
    	response.getWriter().append("Served at: ").append(request.getContextPath());

    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();

    	String numPlayers = request.getParameter("numPlayers");
    	String startMoney = request.getParameter("startMoney");
    	
    	out.println("<HTML>");
    	out.println("<HEAD><TITLE>Start Info for Game</TITLE></HEAD>");
    	out.println("<BODY>");
       	out.println("You will have " + numPlayers + " players!</TITLE></HEAD>");
    	out.println("You will have " + startMoney + " starting money!</TITLE></HEAD>");
    	out.println("</BODY></HTML>");

    }
	
	
}
