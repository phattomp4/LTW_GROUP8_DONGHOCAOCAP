package com.vvp.controller;

import com.vvp.dao.ProductDAO;
import com.vvp.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        if(keyword == null || keyword.trim().isEmpty()){
            resp.setContentType("application/json; charset=UTF-8");
            resp.getWriter().print("[]");
            return;
        }
        List<Product> list = productDAO.search(keyword);
        resp.setContentType("application/json; charset=UTF-8");

        PrintWriter printWriter = resp.getWriter();
        printWriter.print("[");
        for (int i = 0; i < list.size(); i++){
            printWriter.print("\"" + list.get(i).getName() + "\"");
            if(i<list.size() - 1){
                printWriter.print(",");
            }
        }
        printWriter.print("]");
        printWriter.flush();

    }
}
