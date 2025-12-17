package com.vvp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/newPassword")
public class NewPasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/newPassword.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        // Retrieve the email stored during the OTP process
        String email = (String) session.getAttribute("email");

        // Security check: Ensure the flow wasn't bypassed
        if (email == null || session.getAttribute("generatedOTP") == null) {
            request.setAttribute("error", "Session expired. Please start the process again.");
            request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
            return;
        }

        // Check if passwords match
        if (newPassword != null && newPassword.equals(confirmPassword)) {

           //Logic...

        } else {
            request.setAttribute("error", "Passwords do not match.");
            request.getRequestDispatcher("newPassword.jsp").forward(request, response);
        }
    }
}
