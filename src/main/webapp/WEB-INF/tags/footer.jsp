<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<footer>
    <div class="thongtintong">
        <div class="thongtin">
            <p>VỀ CHÚNG TÔI</p>
            <ul class="list-tt">
                <li><a href="introduce.jsp">Giới thiệu về VVP Watch</a></li>
                <li><a href="#">Phản ánh - Khiếu nại</a></li>
                <li><a href="#">Chứng nhận đại lý</a></li>
                <li><a href="#">Tin tức công ty</a></li>
            </ul>
        </div>

        <div class="thongtin">
            <p>CHÍNH SÁCH CHUNG</p>
            <ul class="list-tt">
                <li><a href="#">Điều khoản thanh toán</a></li>
                <li><a href="#">Chính sách bảo hành</a></li>
                <li><a href="#">Chính sách bảo mật</a></li>
                <li><a href="#">Chính sách vận chuyển</a></li>
                <li><a href="#">Chính sách đổi trả</a></li>
            </ul>
        </div>

        <div class="thongtin">
            <p>CỬA HÀNG MIỀN BẮC</p>
            <ul class="list-tt">
                <li><a href="#">97 Trần Đại Nghĩa, P.Bạch Mai, Hà Nội</a></li>
                <li><a href="#">58 Trần Đăng Ninh, P.Cầu Giấy, Hà Nội</a></li>
            </ul>
            <p>CỬA HÀNG MIỀN TRUNG</p>
            <ul class="list-tt">
                <li><a href="#">339 Lê Duẩn, P.Thanh Khê, Đà Nẵng</a></li>
            </ul>
            <p>CỬA HÀNG MIỀN NAM</p>
            <ul class="list-tt">
                <li><a href="#">642 CMT8, P.Thủ Dầu Một, HCM</a></li>
                <li><a href="#">90 Lê Văn Sỹ, P.Phú Nhuận, HCM</a></li>
            </ul>
        </div>

        <div class="thongtin">
            <p>LIÊN HỆ HỖ TRỢ</p>
            <ul class="list-tt">
                <li><a href="#">Hotline 1: 093 189 222</a></li>
                <li><a href="#">Hotline 2: 097 189 3333</a></li>
                <li><a href="contact.jsp" style="color: #ffcc00; font-weight: bold;">LIÊN HỆ TƯ VẤN</a></li>
            </ul>
        </div>
    </div>
    <div class="footer-bottom" style="text-align: center; padding: 20px; border-top: 1px solid rgba(255,255,255,0.1);">
        <p>&copy; 2024 VVP WATCH - All Rights Reserved. Thiết kế bởi LTW_GROUP8.</p>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.js"></script>

<script src="assets/js/index.js"></script>
<script src="assets/js/ProductCards.js"></script>

<script>
    function scrollToTop() {
        window.scrollTo({
            top: 0,
            behavior: 'smooth'
        });
    }

    window.onscroll = function() {
        const btn = document.getElementById("btnScrollToTop");
        if (btn) {
            if (document.body.scrollTop > 300 || document.documentElement.scrollTop > 300) {
                btn.style.display = "flex";
            } else {
                btn.style.display = "none";
            }
        }
    };
</script>