package com.controller;
import com.Service.AccountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.model.Account;
import java.io.IOException;

@WebServlet("/login")
public class AccountController extends  HttpServlet{
    private Account account;
    private AccountService accountService = new AccountService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Account acc = accountService.findUserByUsername(username);
        if(acc != null){
            HttpSession session = request.getSession();
            session.setAttribute("user", acc);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }
}
