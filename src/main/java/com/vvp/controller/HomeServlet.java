package com.vvp.controller;

import com.vvp.dao.ProductDAO;
import com.vvp.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();

        // 1. Lấy dữ liệu
        List<Product> listFeatured = dao.getFeaturedProducts();
        List<Product> listMen = dao.getMenProducts();
        List<Product> listWomen = dao.getWomenProducts();
        List<Product> listLuxury = dao.getLuxuryProducts();

        // 2. Đẩy dữ liệu sang JSP
        request.setAttribute("listFeatured", listFeatured);
        request.setAttribute("listMen", listMen);
        request.setAttribute("listWomen", listWomen);
        request.setAttribute("listLuxury", listLuxury);

        // 3. Chuyển hướng
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}