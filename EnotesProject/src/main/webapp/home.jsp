<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
UserDetails user2 = (UserDetails) session.getAttribute("userD");

if (user2 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error", "please Login...");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_component/allcss.jsp" %>
</head>
<body>



<div class="container.fluid">
<%@include file="all_component/navbar.jsp" %>
<div class="card py-5">

<div class="card-body text-center">

<img src="img/paper.jpeg" style="width: 300px; height: 300px; border-radius: 50%; object-fit: cover;">

<h1>START TAKING UR NOTES</h1>
<a href="addNotes.jsp" class="btn btn-outline-primary">Start here</a>

</div>


</div>



</div>

<%@include file="all_component/footer.jsp" %>

</body>
</html>




