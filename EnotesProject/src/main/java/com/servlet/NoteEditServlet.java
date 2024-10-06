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

@WebServlet("/NoteEditServlet")
public class NoteEditServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		try {
			
			Integer noteid=Integer.parseInt(request.getParameter("noteid"));
			String Title= request.getParameter("title");
			String Content = request.getParameter("content");
			
			PostDAO dao= new PostDAO(DBConnect.getconn());
			boolean f=	dao.postUpdate(noteid,Title,Content);
			
			if(f)
			{
				System.out.println("Data Updated Successfully");
				HttpSession session = request.getSession();
				session.setAttribute("updateMsg", "Notes Updated Successfully");
				response.sendRedirect("showNotes.jsp");
			}
			else {
				System.out.println("Data not updated");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
