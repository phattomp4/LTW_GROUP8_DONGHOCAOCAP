package com.vvp.controller;

import com.vvp.utils.Mailer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Random;

@WebServlet("/forgot-password")
public class ForgotPasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/forgot-password.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String toEmail = request.getParameter("email");

        if (toEmail != null && !toEmail.isEmpty()) {
            // 1. Generate 6-digit OTP
            Random rand = new Random();
            int otp = 100000 + rand.nextInt(900000);

            // 2. Store OTP and Email in session
            HttpSession session = request.getSession();
            session.setAttribute("generatedOTP", otp);
            session.setAttribute("email", toEmail);

            // 3. Prepare Email Content
            String subject = "Password Reset Request";
            String body = "<h3>Your OTP Code is: <span style='color:blue;'>" + otp + "</span></h3>"
                    + "<p>This code is valid for 5 minutes.</p>";

            // This email should match the username in your Mailer class configuration
            String fromEmail = "nguyentruongvu11a9@gmail.com";

            // 4. Send Email using your Mailer utility
            // NOTE: This runs on the main thread. In production, consider using a separate thread/worker.
            try {
                Mailer.sendEmail(fromEmail, toEmail, subject, body);
                request.setAttribute("message", "OTP sent successfully to " + toEmail);
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "Failed to send OTP. Please check your internet or email settings.");
            }

            // 5. Forward to verification page
            request.getRequestDispatcher("verifyOTP.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Email is required.");
            request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
        }
    }
}
