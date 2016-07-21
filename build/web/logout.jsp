<%-- 
    Document   : logout
    Created on : May 21, 2016, 9:15:59 PM
    Author     : suyashadhikary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>logout Page</title>
    </head>
    <body>
        <%
            session.removeAttribute("userId");
            session.removeAttribute("username");
            session.invalidate();
        %>
    <center>
        <h1>You have successfully logged out</h1>
        To login again <a href="<%=request.getContextPath()%>">click here</a>.
    </center>
</body>
</html>
