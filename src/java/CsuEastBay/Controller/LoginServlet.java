package CsuEastBay.Controller;

import CsuEastBay.Service.LoginService;
import CsuEastBay.Util.DataBase;
import CsuEastBay.model.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/"})
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        //LoginService loginService = new LoginService();
        //boolean result = loginService.authenticateUser(userId, password);
        //User user = loginService.getUserByUserId(userId);
        
            
        User user = DataBase.SelectUser(userId);
       
        if (user.getUserId().equals(userId) && user.getPassword().equals(password)) 
        {
            request.getSession().setAttribute("user", user);
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUserId());
            session.setAttribute("userId", user.getUserId());
//            String path = request.getContextPath() +"/users";
            response.sendRedirect("ShoppingCart.jsp");
              
        } 
        else 
        {
            response.sendRedirect("error.jsp");
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);
    }
}
