package com.servlet;

import java.io.IOException;
import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.User.UserDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String name = request.getParameter("fname");
        String email = request.getParameter("uemail");
        String password = request.getParameter("upassword");

        UserDetails us = new UserDetails();
        us.setNameString(name);
        us.setEmailString(email);
        us.setPassword(password);

        UserDAO dao = new UserDAO(DBConnect.getconn());
        boolean f = dao.addUser(us);
        HttpSession session = request.getSession();

        if (f) {
            session.setAttribute("reg-success", "Registration Successful");
            response.sendRedirect("register.jsp");
        } else {
            session.setAttribute("failed-msg", "Something went wrong on the server");
            response.sendRedirect("register.jsp");
        }
    }
}
