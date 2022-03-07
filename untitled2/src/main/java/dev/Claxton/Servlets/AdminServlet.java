package dev.Claxton.Servlets;

import Models.Reimbursement;
import Models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jfr.internal.Repository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        User author = (User) session.getAttribute("user");
        if (author == null || "EMPLOYEE".equals(author.getRole())) {
            response.sendRedirect("/login");
        }


        List<Reimbursement> reimbursements = Repository.getRepository(ReimbursementDAO.getAll());
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(reimbursements);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}
