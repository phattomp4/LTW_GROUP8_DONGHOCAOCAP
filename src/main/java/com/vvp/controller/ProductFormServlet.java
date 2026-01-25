package com.vvp.controller;

import com.vvp.dao.AdminDAO;
import com.vvp.model.Product;
import com.vvp.model.ProductSpecification;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "ProductFormServlet", urlPatterns = {"/admin/product-form"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class ProductFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idRaw = request.getParameter("id");

        if (idRaw != null) {
            // --- CHẾ ĐỘ SỬA: LẤY DỮ LIỆU CŨ ---
            try {
                int pid = Integer.parseInt(idRaw);
                AdminDAO dao = new AdminDAO();

                // 1. Lấy thông tin cơ bản (Tên, giá, ảnh đại diện...)
                Product p = dao.getProductById(pid);
                request.setAttribute("product", p);

                // 2. Lấy danh sách ảnh phụ
                List<String> detailImages = dao.getDetailImages(pid);
                request.setAttribute("detailImages", detailImages);

                // 3. Lấy thông số kỹ thuật (Dạng Map)
                java.util.Map<String, String> specMap = dao.getProductSpecsMap(pid);
                request.setAttribute("specMap", specMap);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        request.getRequestDispatcher("/admin/product-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");

            // 1. NHẬN THÔNG TIN CƠ BẢN
            String name = request.getParameter("name");
            String sku = request.getParameter("sku");
            double price = Double.parseDouble(request.getParameter("price"));
            double originalPrice = Double.parseDouble(request.getParameter("originalPrice"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            String desc = request.getParameter("description");
            boolean isLuxury = request.getParameter("isLuxury") != null;

            // Tạo đối tượng Product
            Product p = new Product();
            p.setName(name);
            p.setSku(sku);
            p.setCurrentPrice(price);
            p.setOriginalPrice(originalPrice);
            p.setStockQuantity(stock);
            p.setDescription(desc);
            p.setLuxury(isLuxury);

            // 2. XỬ LÝ ẢNH
            String uploadPath = getServletContext().getRealPath("") + File.separator + "assets" + File.separator + "img" + File.separator + "products";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdir();

            // A. Ảnh Đại Diện (Lưu vào bảng Products)
            Part mainPart = request.getPart("mainImage");
            if (mainPart != null && mainPart.getSize() > 0) {
                String fileName = getFileName(mainPart);
                String saveName = System.currentTimeMillis() + "_main_" + fileName;
                mainPart.write(uploadPath + File.separator + saveName);

                // Set đường dẫn ảnh cho đối tượng Product -> Để DAO lưu vào cột ImageURL
                p.setImageUrl("assets/img/products/" + saveName);
            }

            // B. 5 Ảnh Chi Tiết (Lưu vào bảng ProductImages)
            List<String> detailImages = new ArrayList<>();
            Collection<Part> parts = request.getParts();
            for (Part part : parts) {
                if (part.getName().equals("detailImages") && part.getSize() > 0) {
                    String fileName = getFileName(part);
                    String saveName = System.currentTimeMillis() + "_detail_" + fileName;
                    part.write(uploadPath + File.separator + saveName);
                    detailImages.add("assets/img/products/" + saveName);
                }
            }

            // 3. XỬ LÝ 10 THÔNG SỐ KỸ THUẬT
            List<ProductSpecification> listSpecs = new ArrayList<>();
            String[] specNames = request.getParameterValues("specName");
            String[] specValues = request.getParameterValues("specValue");

            if (specNames != null && specValues != null) {
                for (int i = 0; i < specNames.length; i++) {
                    if (!specValues[i].trim().isEmpty()) { // Chỉ lưu nếu có nhập giá trị
                        ProductSpecification spec = new ProductSpecification();
                        spec.setName(specNames[i]);
                        spec.setValue(specValues[i]);
                        listSpecs.add(spec);
                    }
                }
            }

            // 4. LƯU VÀO DATABASE
            AdminDAO dao = new AdminDAO();
            dao.insertFullProduct(p, detailImages, listSpecs);

            response.sendRedirect("product-manager");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("product-form?error=1");
        }
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        for (String token : contentDisp.split(";")) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return "";
    }
}