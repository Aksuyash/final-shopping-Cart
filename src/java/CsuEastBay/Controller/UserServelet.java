/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CsuEastBay.Controller;

import CsuEastBay.Service.LoginService;
import CsuEastBay.Service.RegisterService;
import CsuEastBay.model.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author suyashadhikary
 */
@WebServlet(urlPatterns = {"/users"})
public class UserServelet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userId = request.getParameter("userId");

        LoginService loginService = new LoginService();

        User user = loginService.getUserByUserId(userId);
        RegisterService sv = new RegisterService();
        sv.deleteUser(user);

        String path = request.getContextPath() + "/users";
        response.sendRedirect(path);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("users.jsp");
        view.forward(request, response);
    }
}
