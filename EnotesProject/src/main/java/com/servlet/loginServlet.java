package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.User.UserDetails;

@WebServlet("/LoginServlet")
public class loginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("uemail");
        String password = request.getParameter("upassword");

        UserDetails us = new UserDetails();
        us.setEmailString(email);
        us.setPassword(password);

        UserDAO dao = new UserDAO(DBConnect.getconn());
        UserDetails user= dao.loginUser(us);

        
        if (user!=null) {
          
            HttpSession session = request.getSession();
            session.setAttribute("userD", user);
            response.sendRedirect("home.jsp");
        } else {
        	HttpSession session = request.getSession();
            session.setAttribute("failed-msg", "Invalid Username or password");
            response.sendRedirect("login.jsp");
        }
    }
}
