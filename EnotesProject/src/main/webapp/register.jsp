<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registration Page</title>
    <%@include file="all_component/allcss.jsp"%>
</head>
<body>
    <%@include file="all_component/navbar.jsp"%>
    
    <style type="text/css"> 
        <%@include file="css/style.css" %> 
    </style>

    <div class="container-fluid div-color">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card mt-4">
                    <div class="card-header text-center text-white bg-custom">
                        <i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
                        <h4>Registration</h4>
                    </div>

                    <% 
                        String regMsg = (String) session.getAttribute("reg-success");
                        if (regMsg != null) {
                    %>
                        <div class="alert alert-success" role="alert">
                            <%= regMsg %> Login 
                            <a href="login.jsp">Click Here</a>
                        </div>
                    <%
                        session.removeAttribute("reg-success");
                        }
                    %>

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

                    <div class="card-body">
                        <form action="UserServlet" method="post">
                            <div class="form-group">
                                <label>Enter Full Name</label>
                                <input type="text" class="form-control" name="fname" required>
                            </div>
                            <div class="form-group">
                                <label>Enter Email</label>
                                <input type="email" class="form-control" name="uemail" required>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Enter Password</label>
                                <input type="password" class="form-control" id="exampleInputPassword1" name="upassword" required>
                            </div>
                            <button type="submit" class="btn btn-primary badge-pill btn-block">Register</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@include file="all_component/footer.jsp" %>
</body>
</html>
