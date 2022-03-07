package dev.Claxton.Servlets;

import Models.User;
import Repository.UserDAO;
import Service.AuthService;
import Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User u = new User();
        u.setUsername(username);
        u.setPassword(password);

        try {
            // check if user is valid
            User userAuth = AuthService.login(username, password);
            if(userAuth != null) {
                // Create an http session with that user info
                HttpSession session = request.getSession();

                // Set the session object
                User user = UserDAO.getByUsername(username);
                session.setAttribute("user", user);

                User userRole = UserDAO.getByUsername(username);
                String role = userRole.getRole();
                if(role.equals("EMPLOYEE")) {
                    response.sendRedirect("employee.html");
                } else {
                    response.sendRedirect("manager.html");
                }
            } else {
                response.sendRedirect("login.html");
            }
        } catch (Exception e) {
            System.out.println("Invalid username or password");
        }
    }
}
