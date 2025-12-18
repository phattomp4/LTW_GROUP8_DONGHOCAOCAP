package com.vvp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/verifyOTP")
public class VerifyOTPController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userOtp = Integer.parseInt(request.getParameter("otp"));
        HttpSession session = request.getSession();
        int generatedOtp = (int) session.getAttribute("generatedOTP");

        if (userOtp == generatedOtp) {
            // Success: Redirect to reset password page
            request.getRequestDispatcher("newPassword.jsp").forward(request, response);
        } else {
            // Failure
            request.setAttribute("error", "Invalid OTP. Please try again.");
            request.getRequestDispatcher("verifyOTP.jsp").forward(request, response);
        }
    }
}
