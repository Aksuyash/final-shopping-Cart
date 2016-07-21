<%-- 
    Document   : CheckOut
    Created on : May 24, 2016, 7:30:28 PM
    Author     : welcome
--%>

<%@page import="CsuEastBay.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <header>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="main.css" type="text/css">
        <title>CheckOut</title>
    </header>
    
    <body>
        <div>
            <%@include file="header.jsp" %>
        </div>
        <h1 style="margin-top: 60px; text-align: center;">Checkout:</h1>
        
        <h3> Thank you for shopping at our online store 
       
        <%
                User user = (User) session.getAttribute("user");
            %>     
            <b> <%= user.getFirstName() + " " + user.getLastName()%></b> </h3> 
            <h2>Hope to see you soon!!</h2>
        <form action="login.jsp" method="get">
            <input type="submit" value="Log Out">
        </form>
        <div class="footer" > 
             <%@include file="footer.jsp" %> 
        </div>
    </body>
</html>
