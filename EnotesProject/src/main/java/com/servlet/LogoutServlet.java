package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LogoutServlet
 */

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			HttpSession session = request.getSession();
			session.removeAttribute("userD");
			
			HttpSession session2 = request.getSession();
			session.setAttribute("logoutMsg","Logout Sucessfully....");
			response.sendRedirect("login.jsp");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
