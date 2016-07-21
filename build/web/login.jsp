<%-- 
    Document   : Login
    Created on : May 21, 2016, 8:51:43 PM
    Author     : suyashadhikary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    </head>
    <body>
          <%@include file="header.jsp" %>
        <br>
       <div class="container">
        <form method="post">
            <div style="padding: 100px 0 0 250px;">
                <div id="login-box">
                    <h2>Login Page</h2>
                    Please provide your credential to use this website. Please register if you are not a member.
                    <br>
                    <br>
                    
                    <div class="form-group" style="margin-top:20px;">
                    
                        <label> User ID</label>
                   
                        <input name="userId" class="form-control" title="Username" value="" size="30" maxlength="50" required="required"/>                  
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input name="password" type="password" class="form-control" title="Password" value="" size="30" maxlength="48"required="required" />
                    </div>
                    
                    <!--<input  type="submit" value="Login" />-->
                    <button type="submit" value="Login" class="btn btn-success">Submit</button>
                    <br />
                    <br>
                    <span class="login-box-options">
                        New User ?  <a href="register.jsp" style="margin-left:30px;">
                            <a class="btn btn-primary" href="<%=request.getContextPath()%>/register">Register Here</a>
                    </span>
                    <br />
                    <br />
<!--                    <form action="ShoppingCart.jsp" method="get">
                <input type="hidden" name="action" value="join">
                <input type="submit" value="shopping">
                </form>-->
                </div>
            </div>
        </form>
       </div>
         <%@include file="footer.jsp" %>
    </body>
</html>
