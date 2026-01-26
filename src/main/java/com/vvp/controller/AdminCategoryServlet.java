package com.vvp.controller;

import com.vvp.dao.CategoryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "AdminCategoryServlet", urlPatterns = {"/admin/category-manager"})
public class AdminCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        CategoryDAO dao = new CategoryDAO();

        // 1. XÓA DANH MỤC
        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteCategory(id);
            clearMenuCache(request); // Xóa cache
            response.sendRedirect("category-manager");
        }
        // 2. XÓA KHOẢNG GIÁ (MỚI - SỬA LỖI)
        else if ("deletePrice".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deletePriceRange(id);
            clearMenuCache(request); // Xóa cache
            response.sendRedirect("category-manager");
        }
        // 3. LOAD DỮ LIỆU
        else {
            request.setAttribute("listCats", dao.getAllCategories());
            request.setAttribute("menuPrices", dao.getAllPriceRanges()); // Load danh sách giá
            request.getRequestDispatcher("category-manager.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        CategoryDAO dao = new CategoryDAO();

        // --- XỬ LÝ DANH MỤC ---
        if ("add".equals(action)) {
            String name = request.getParameter("name");
            int parentId = Integer.parseInt(request.getParameter("parentId"));
            dao.addCategory(name, parentId);
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            int parentId = Integer.parseInt(request.getParameter("parentId"));
            dao.updateCategory(id, name, parentId);
        }

        // --- XỬ LÝ KHOẢNG GIÁ (MỚI - SỬA LỖI) ---
        else if ("addPrice".equals(action)) {
            String label = request.getParameter("label");
            double min = Double.parseDouble(request.getParameter("min"));
            double max = Double.parseDouble(request.getParameter("max"));
            dao.addPriceRange(label, min, max);
        }
        else if ("updatePrice".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String label = request.getParameter("label");
            double min = Double.parseDouble(request.getParameter("min"));
            double max = Double.parseDouble(request.getParameter("max"));
            dao.updatePriceRange(id, label, min, max);
        }

        clearMenuCache(request); // Xóa cache để menu trang chủ cập nhật ngay
        response.sendRedirect("category-manager");
    }

    // Hàm phụ để xóa cache menu
    private void clearMenuCache(HttpServletRequest request) {
        request.getServletContext().removeAttribute("menuBrands");
        request.getServletContext().removeAttribute("menuCollections");
        request.getServletContext().removeAttribute("menuAccessories");
        request.getServletContext().removeAttribute("menuPrices");
    }
}