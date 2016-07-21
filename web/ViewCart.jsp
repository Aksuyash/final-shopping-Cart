<%-- 
    Document   : ViewCart
    Created on : May 24, 2016, 7:20:00 PM
    Author     : welcome
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <header>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
        <link rel="stylesheet" href="main.css" type="text/css">
    </header>
    
    <body>
        <div>
            <%@include file="header.jsp" %>
        </div>
        <h1 style="margin-top: 60px;">Here is the item in your cart:</h1>
        <table class="table table-hover">
        <tr>
            <th>Description</th>  
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
            <th></th>
        </tr>
        <tr>
            <td>Phone : It is a smart phone, most reliable ever</td>
            <td class="right">$1.99</td>
            <td> <select id = "myList">
               <option value = "1">one</option>
               <option value = "2">two</option>
               <option value = "3">three</option>
               <option value = "4">four</option>
             </select></td>
             <td>$1.99</td>
             
        </tr><!--
        <tr>
           
            <td>Car : It is an automobile that can take you from point A to point B</td>
            <td class="right">$2.99</td>
             
        </tr>
             <td>Book : It is a five subjects notebook</td>
            <td class="right">$0.99</td>
           
         </tr>-->
          <c:forEach var="item" items="${cart.getItem()}">
          <tr>
            <td>
                <form action="CartServlet" method="post">
                    <input type="hidden" name="productCode" 
                           accept=""value="<c:out value='${item.product.name}'/>">
                    <input type="hidden" name="action" value="cart">
                    <input type=text name="quantity" 
                           accept=""value="<c:out value='${item.quantity}'/>" name="quantity">
                    <input type="submit" value="Update">
                </form>
            </td>
            <td>
                <c:out value='${item.product.description}'/>
            </td>
            <td>${item.product.priceCurrencyFormat}</td>
            <td>${item.totalCurrencyFormat}</td>
            <td>
                <form action="CartServlet" method="post">
                    <input type="hidden" name="productCode" 
                        accept=""value="<c:out value='${item.product.name}'/>">
                    <input type="hidden" name="action" value="cart">
                    <input type="hidden" name="quantity" value="0">
                    <input type="submit" value="Remove Item">
                </form>
            </td>      
        </tr>
        </c:forEach>
        </table>

<!--        <p><b>To change the quantity</b>, enter the new quantity 
        and click on the Update button.</p>-->
        <form action="ShoppingCart.jsp" method="get">
            <input type="hidden" name="action" value="shopping">
            <input type="submit" value="Continue Shopping">
        </form>
        <form action="CartServlet" method="get">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Log Out">
        </form>
        <form action="CheckOut.jsp" method="get">
            <input type="hidden" name="action" value="checkout">
            <input type="submit" value="Checkout">
        </form>
        <div class="footer" > 
             <%@include file="footer.jsp" %> 
        </div>
    </body>
</html>
