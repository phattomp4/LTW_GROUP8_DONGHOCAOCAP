package com.vvp.controller;

import com.vvp.dao.UserDAO;
import com.vvp.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddressServlet", urlPatterns = {"/address"})
public class AddressServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User acc = (User) session.getAttribute("acc");

        // Bắt buộc đăng nhập
        if (acc == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        UserDAO dao = new UserDAO();

        try {

            if ("set-default".equals(action)) {
                int addressId = Integer.parseInt(request.getParameter("id"));


                dao.setDefaultAddress(acc.getId(), addressId);


                response.sendRedirect("profile");
            }


            else if ("delete".equals(action)) {
                int addressId = Integer.parseInt(request.getParameter("id"));
                dao.deleteAddress(addressId); // Đảm bảo UserDAO có hàm deleteAddress
                response.sendRedirect("profile");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("profile");
        }
    }
}