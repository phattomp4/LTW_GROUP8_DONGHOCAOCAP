package com.vvp.filter;

import com.vvp.dao.CategoryDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "MenuFilter", urlPatterns = {"/*"})
public class MenuFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // Kiểm tra nếu chưa có dữ liệu menu thì mới gọi Database (Tối ưu hiệu năng)
        if (request.getServletContext().getAttribute("menuBrands") == null) {
            CategoryDAO dao = new CategoryDAO();

            // 1. Load Thương hiệu (ParentID = 1 theo SQL của bạn)
            request.getServletContext().setAttribute("menuBrands", dao.getCategoriesByParent(1));

            // 2. Load Bộ sưu tập (ParentID = 2 theo SQL của bạn)
            request.getServletContext().setAttribute("menuCollections", dao.getCategoriesByParent(2));

            // 3. Load Phụ kiện (Nếu có - ParentID = 3)
            request.getServletContext().setAttribute("menuAccessories", dao.getCategoriesByParent(25));

            // 4. Load Khoảng giá (Nếu bạn đã làm bước trước)
            request.getServletContext().setAttribute("menuPrices", dao.getAllPriceRanges());
        }
        chain.doFilter(request, response);
    }
}