package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.DAO.PostDAO;
import com.Db.DBConnect;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Integer noteid = Integer.parseInt(request.getParameter("note_id"));
        PostDAO dao = new PostDAO(DBConnect.getconn());
        
        boolean f = dao.deleteNotes(noteid);
        HttpSession session = request.getSession();
        if (f) {
            session.setAttribute("updateMsg", "Notes deleted successfully...");
        } else {
            session.setAttribute("wrongMsg", "Something went wrong on the server");
        }
        response.sendRedirect("showNotes.jsp");
    }
}
