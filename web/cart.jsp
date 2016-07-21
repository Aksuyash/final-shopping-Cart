<%-- 
    Document   : cart
    Created on : May 24, 2016, 6:40:18 PM
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
        <h1>Here is the item in your cart:</h1>
        <table>
        <tr>
            <th>Quantity</th>
            <th>Description</th>
            <th>Price</th>
            <th>Amount</th>
            <th></th>
        </tr>
          <c:forEach var="item" items="${cart.getItem()}">
          <tr>
            <td>
                <form action="Cart" method="post">
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
                <form action="Cart" method="post">
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

        <p><b>To change the quantity</b>, enter the new quantity 
        and click on the Update button.</p>
        <form action="ContinueShopping.jsp" method="get">
            <input type="hidden" name="action" value="shopping">
            <input type="submit" value="Continue Shopping">
        </form>
        <form action="Cart" method="get">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Log Out">
        </form>
        <form action="Cart" method="post">
            <input type="hidden" name="action" value="checkout">
            <input type="submit" value="Checkout">
        </form>
        <div class="footer" > 
             <%@include file="footer.jsp" %> 
        </div>
    </body>
</html>
