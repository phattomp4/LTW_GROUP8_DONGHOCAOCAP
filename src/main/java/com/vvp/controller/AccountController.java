package com.vvp.controller; // Thêm 'vvp' vào tên góiimport com.Service.AccountService;
import com.vvp.model.Account;
import com.vvp.service.AccountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class AccountController extends  HttpServlet{
    private AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Account acc = accountService.login(username, password);
        if(acc != null){
            HttpSession session = request.getSession();
            session.setAttribute("user", acc);
//            request.getRequestDispatcher("index.jsp").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/index");
        }
        else {
            request.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không chính xác!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }
}
