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
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.util.Map;

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

            // Cấu hình Cloudinary (Nên để 3 cái này ra file config riêng hoặc biến tĩnh)
            Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", "dnrpxyuwo",
                    "api_key", "261138144329333",
                    "api_secret", "beBh1tv2UJYTuS8CWkVmKS48CO4"
            ));

// --- XỬ LÝ ẢNH ĐẠI DIỆN ---
            Part mainPart = request.getPart("mainImage");
            if (mainPart != null && mainPart.getSize() > 0) {
                try {
                    // Lấy dữ liệu file
                    byte[] fileBytes = mainPart.getInputStream().readAllBytes();

                    // Upload lên Cloudinary
                    Map uploadResult = cloudinary.uploader().upload(fileBytes, ObjectUtils.asMap(
                            "folder", "vvp_store_products" // Gom ảnh vào thư mục cho gọn
                    ));

                    // Lấy URL trả về (Đây chính là cái ta cần!)
                    String secureUrl = (String) uploadResult.get("secure_url");

                    // Lưu URL này vào đối tượng Product
                    p.setImageUrl(secureUrl);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // B. 5 Ảnh Chi Tiết (Detail Images)
            List<String> detailImages = new ArrayList<>();
            Collection<Part> parts = request.getParts();

            for (Part part : parts) {
                // Kiểm tra nếu part này là input có name="detailImages" và có dữ liệu
                if (part.getName().equals("detailImages") && part.getSize() > 0) {
                    try {
                        byte[] fileBytes = part.getInputStream().readAllBytes();

                        // Upload từng ảnh lên Cloudinary
                        Map uploadResult = cloudinary.uploader().upload(fileBytes, ObjectUtils.asMap(
                                "folder", "vvp_store_products"
                        ));

                        // Lấy URL và thêm vào danh sách
                        detailImages.add((String) uploadResult.get("secure_url"));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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

            // 4. LƯU VÀO DATABASE (LOGIC MỚI)
            AdminDAO dao = new AdminDAO();

            // Lấy ID từ form (được gửi từ input hidden name="id")
            String idRaw = request.getParameter("id");

            if (idRaw != null && !idRaw.trim().isEmpty() && !idRaw.equals("0")) {
                // --- TRƯỜNG HỢP CẬP NHẬT (UPDATE) ---
                int pid = Integer.parseInt(idRaw);
                p.setId(pid); // Set ID vào đối tượng Product để DAO biết sửa dòng nào

                dao.updateFullProduct(p, detailImages, listSpecs);
            } else {
                // --- TRƯỜNG HỢP THÊM MỚI (INSERT) ---
                dao.insertFullProduct(p, detailImages, listSpecs);
            }

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