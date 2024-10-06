<%@page import="com.Db.DBConnect"%>
<%@page import="com.DAO.PostDAO"%>
<%@page import="com.User.Post"%>
<%@page import="com.User.UserDetails"%>
<%@page import="java.util.List"%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
    UserDetails user3 = (UserDetails) session.getAttribute("userD");
    if (user3 == null) {
        session.setAttribute("Login-error", "Please login...");
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Show Notes</title>
    <%@include file="all_component/allcss.jsp"%>
</head>
<body>
    <%@include file="all_component/navbar.jsp"%>
	
	<%
	String updateMsg = (String) session.getAttribute("updateMsg");
	if (updateMsg != null) {
	%>
		<div class="alert alert-success" role="alert">
            <%= updateMsg %>
        </div>
	<% 
	session.removeAttribute("updateMsg");
	}
	%>

	<%
	String wrongMsg = (String) session.getAttribute("wrongMsg");
	if (wrongMsg != null) { // Corrected this line
	%>
	<div class="alert alert-danger" role="alert">
		<%= wrongMsg %>
	</div>
	<%
	session.removeAttribute("wrongMsg");
	}
	%>

	<div class="container">
        <h2 class="text-center">All Notes:</h2>
        <div class="row">
            <div class="col-md-12">
                <%
                    PostDAO postDAO = new PostDAO(DBConnect.getconn());
                    List<Post> postList = postDAO.getData(user3.getId());
                    for(Post po : postList) {
                %>
                    <div class="card mt-3">
                       <img alt="Note image" src="img/paper.jpeg" class="card-img-top mt-2 mx-auto" style="width: 100px; height: 100px; border-radius: 50%; object-fit: cover;">

                        <div class="card-body p-4">
                            <h5 class="card-title"><%= po.getTitle() %></h5>
                            <p><%= po.getContent() %></p>
                            <p>
                                <b class="text-success">Published By: <%= user3.getNameString() %></b><br>
                                <b class="text-success">Published Date: <%= po.getpDate() %></b>
                            </p>
                            
                            <div class="container text-center mt-2">
                                <a href="deleteServlet?note_id=<%= po.getId() %>" class="btn btn-danger">Delete</a>
                                <a href="edit.jsp?note_id=<%= po.getId() %>" class="btn btn-primary">Edit</a>
                            </div>
                        </div>
                    </div>
                <%
                    } // End of for loop
                %>
            </div>
        </div>
    </div>
</body>
</html>
