<%-- 
    Document   : home
    Created on : May 21, 2016, 9:03:24 PM
    Author     : suyashadhikary
--%>
<%@page import="CsuEastBay.Service.LoginService"%>
<%@page import="CsuEastBay.model.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
        <title>Member Page</title>
    </head></>
    <body>
    <center>
        <div id="container">
            <h1>Welcome</h1>
            <b></b><br/>
            <%=new Date()%></br>
            <%
                User user = (User) session.getAttribute("user");
            %>     
            <b>Welcome <%= user.getFirstName() + " " + user.getLastName()%></b>     
            <br/>
            <a href="logout.jsp">Logout</a>
            </p>
            <form method="post">

                <table>
                    <thead>
                        <tr>
                            <th>User ID</th>
                            <th>First Name</th>
                            <th>Middle Name</th>
                            <th>Last Name</th>
                            <th>email</th>                
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            LoginService loginService = new LoginService();
                            List<User> list = loginService.getListOfUsers();
                            for (User u : list) {
                        %>
                        <tr>
                            <td><%=u.getUserId()%></td>
                            <td><%=u.getFirstName()%></td>
                            <td><%=u.getMiddleName()%></td>
                            <td><%=u.getLastName()%></td>
                            <td><%=u.getEmail()%></td>
                            <td> 
                                <input type="hidden" name="userId" value="<%=u.getUserId()%>" />
                                <button class="btn btn-danger" value="<%=u.getUserId()%>" >Remove</button></td>
                            <td><button value="<%=u.getFirstName()%>">Update</button></td>
                        </tr>
                        <%}%>
                    <tbody>
                </table>    
            </form> 
            <br/>
        </div>
    </center>
</body>
</html>
