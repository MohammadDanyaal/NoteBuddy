<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>
    <%@include file="all_component/allcss.jsp" %>
</head>
<body>
    <%@include file="all_component/navbar.jsp" %>

    <style type="text/css"> 
        <%@include file="css/style.css" %> 
    </style>

    <div class="container-fluid div-color">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card mt-4">
                    <div class="card-header text-center text-white bg-custom">
                        <i class="fa fa-user fa-3x" aria-hidden="true"></i>
                        <h4>Login Page</h4>
                    </div>
                    
                    <% 
                        String failedMsg = (String) session.getAttribute("failed-msg");
                        if (failedMsg != null) {
                    %>
                        <div class="alert alert-danger" role="alert">
                            <%= failedMsg %>
                        </div>
                    <%
                        session.removeAttribute("failed-msg");
                        }
                    %>

				<%
				String withoutLogin=(String)session.getAttribute("Login-error");
				if(withoutLogin!=null)
				{%>
				
					  <div class="alert alert-danger" role="alert">
                            <%=withoutLogin %>
                        </div>
				
				<%
				 session.removeAttribute("Login-error");
				}
				%>


				<%
				
				String lgMsg =(String)session.getAttribute("logoutMsg");
				if(lgMsg!=null)
				{%>
					
					  <div class="alert alert-success" role="alert">
                            <%=lgMsg %>
                        </div>
					
				<% 
				 session.removeAttribute("logoutMsg");
				}
				%>

                    <div class="card-body">
                        <form action="LoginServlet" method="post">
                            <div class="form-group">
                                <label>Enter Email</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" name="uemail" required>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Enter Password</label>
                                <input type="password" class="form-control" id="exampleInputPassword1" name="upassword" required>
                            </div>
                            <button type="submit" class="btn btn-primary badge-pill btn-block">Login</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@include file="all_component/footer.jsp" %>
</body>
</html>
