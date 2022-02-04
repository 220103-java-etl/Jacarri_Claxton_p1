package dev.Claxton.Servlets;

import Models.User;
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


        // Retrieving the form data sent by one.html to this servlet
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Create a new User Object from these values

        User u = new User();
        u.setfName(fname);
        u.setlName(lname);
        u.setEmail(email);
        u.setContact(contact);
        u.setUsername(username);

        //create an Http session with that user info

        HttpSession session = request.getSession();

        // 'Save' the user details in the session object
        session.setAttribute("user",u);
        response.sendRedirect("reimbursement.html");


    }
    UserService userService = new UserService();

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> users = userService.getAll();

        String responseBody = objectMapper.writeValueAsString(users);

        response.getWriter().write(objectMapper.writeValueAsString(responseBody));

        response.sendRedirect("login.html");
    }
}


