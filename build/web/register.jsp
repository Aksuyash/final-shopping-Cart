<%-- 
    Document   : index
    Created on : May 21, 2016, 8:52:53 AM
    Author     : welcome
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
       

    </head>
    <body>
         <%@include file="header.jsp" %>
         <div class="header">
            <h3 style="margin: 80px 0 0 10px;">Members Registration Form</h3>
        <div>
        <div class="container">
        <form method="POST">
            
                  <div class="form-group">
                    <label>First Name</label>
                     <input class="form-control" type="text" name="firstName" maxlength="30" required/>
                        (max 30 characters a-z and A-Z)
                    
                </div>
               <div class="form-group">
                    <label>Middle Name</label>
                    <input class="form-control" type="text" name="middleName" maxlength="30"/>
                        (max 30 characters a-z and A-Z)
                    
                </div>
                 <div class="form-group">
                    <label>Last Name</label>
                    <input class="form-control" type="text" name="lastName" maxlength="30" required=""/>
                        (max 30 characters a-z and A-Z)
                    
                </div>
                 <div class="form-group">
                    <label>Email</label>
                    <input class="form-control" type="email" name="email" maxlength="100" required />
                </div>
                 <div class="form-group">
                    <label>User ID</label>
                     <input class="form-control" type="text" name="userId" maxlength="100" required/>
                </div>
                 <div class="form-group">
                    <label>Password</label>
                   <input class="form-control" type="text" name="password" class="form-control" maxlength="100" required/></td>
                </div>
                <div>
                    
                        <input type="submit" value="Submit">
                        <input type="reset" value="Reset">
                       
                     
                </div>
            </div>
        </form>
        </div>
             <%@include file="footer.jsp" %>
    </body>
</html>
</tr>
</table>
</form>
</body>
</html>
