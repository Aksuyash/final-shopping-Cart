/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CsuEastBay.model;

import CsuEastBay.Util.DataBase;
import CsuEastBay.Util.FileIO;
import CsuEastBay.Util.Product;
import CsuEastBay.bean.Cart;
import CsuEastBay.bean.LineItem;
import CsuEastBay.bean.UserAccount;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author welcome
 */
public class CartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        ServletContext sc = getServletContext();
        LineItem lineItem = new LineItem();
        System.out.println("helooooooo");
            
        String url = "/ShoppingCart.jsp";
        // get current action
        String action = request.getParameter("action");
        String quantityString;
        String productCode;
        if (action == null)
        {
            action = "shopping";
        }

        // perform action and set URL to appropriate page
        if (action.equals("shopping"))
        {
            // "shopping" page
            url = "/ShoppingCart.jsp";
        }
        else if (action.equals("cart"))
        {
            // get parameters from the request
            productCode = request.getParameter("productCode");
            quantityString = request.getParameter("quantity");
            
            HttpSession session = request.getSession();
            //session.setAttribute("firstName", login);
            //session.setAttribute("lastName", login);

            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
            }
            System.out.println("heoooooooooooooooo");
               System.out.println(productCode);
            //if the user enters a negative or invalid quantity,
            //the quantity is automatically reset to 1.
            int quantity;
            try {
                quantity = Integer.parseInt(quantityString);
                if (quantity < 0) {
                    quantity = 1;
                }
            } catch (NumberFormatException nfe) {
                quantity = 1;
            }
            
            
            FileIO readfile = new FileIO();
            Product product = readfile.getProduct("/Users/suyashadhikary/Downloads/final/web/META-INF/product.txt", productCode);
            //UserAccount userAccount = new UserAccount();
            //HashMap <String, User> account = new HashMap(); 
            //account.putAll(userAccount.getAccount());
            //ArrayList<Product> product = ;
            //for (int i = 0; i < product.size(); i++)
            
           // System.out.println(product.getDescription());
            {
                lineItem.setProduct(product);
                lineItem.setQuantity(quantity);
   
                if (quantity > 0){
                    //DataBase.UpdateUser(user);
                        cart.addItem(lineItem);
                }else if (quantity == 0){
                    //DataBase.DeleteUser(user);
                    cart.removeItem(lineItem);
                }
            }
            
            /**
            //UserAccount userAccount = new UserAccount();
            User user = null;
            
            ArrayList<LineItem> item = (ArrayList<LineItem>) cart.getItem();
            //ArrayList<Item> item = DataBase.SelectItem(Double.valueOf(productCode));
            for (int i = 0; i < item.size(); i++)
            {
                Item items = item.get(i).getProduct();
                                System.out.println(items.getDescription());

                if (items.getId() == Double.valueOf(productCode))
                {
                    lineItem.setProduct(items);
                    lineItem.setQuantity(quantity);
   
            if (quantity > 0){
                //DataBase.InsertItem(items);
                cart.addItem(lineItem);
                
            }else if (quantity == 0){
                //DataBase.DeleteItem(items);
                cart.removeItem(lineItem);
                
            }
                }
                    
                
            }
            * */
            
            
            
            session.setAttribute("cart", cart);
            url = "/ViewCart.jsp";
        }
        else if (action.equals("checkout")){
            url = "/CheckOut.jsp";
        }
        /**
        else if (action.equals("join")){
            HttpSession session = request.getSession();
            UserName userName = new UserName();
            userName.setUserName("");
            session.setAttribute("userName", userName.getUserName());
            url = "/login.jsp";
        }
        */

        sc.getRequestDispatcher(url)
                .forward(request, response);
   
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
