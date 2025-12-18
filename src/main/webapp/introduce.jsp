<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Giới thiệu</title>
    <!-- CSS IntroDuce -->
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/introduce.css">
    <link rel="stylesheet" href="Share/css/footer.css">
    <link rel="stylesheet" href="Share/css/header.css">
    <!-- Linking Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
</head>
<body>
    <!-- Phat -->

    <button id="btnScrollToTop" onclick="scrollToTop()">
        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
            <path d="M18 15l-6-6-6 6" />
        </svg>
    </button>

    <!-- Header -->
    <header class="main-header">

        <!--Logo-->
        <div class="logo-container-header">
            <a href="index.jsp" class="logo-header">
                <h1 class="logo-text" style="font-weight: 900; font-size: 35px;">VVP</h1>
            </a>
        </div>


        <!--Links dieu huong-->
        <div class="nav-item">
            <nav class="main-nav">
                <ul>
                    <li class="nav-item-has-dropdown">
                        <a href="DongHo.html" class="link-yellow">Đồng hồ<i class="fa-solid fa-chevron-down"></i></a>
                        <div class="megamenu megamenu-dongho">
                            <div class="megamenu-column">
                                <ul>
                                    <li><a href="DongHo.html">Giống Rolex, Hublot</a></li>
                                    <li><a href="DongHo.html">Giống Patek, Richard</a></li>
                                    <li><a href="DongHo.html">Giá dưới 1 triệu</a></li>
                                    <li><a href="DongHo.html">Giá từ 1 - 3 triệu</a></li>
                                    <li><a href="DongHo.html">Giá từ 3 - 6 triệu</a></li>
                                    <li><a href="DongHo.html">Giá từ 6 - 9 triệu</a></li>
                                    <li><a href="DongHo.html">Giá từ 9 - 15 triệu</a></li>
                                    <li><a href="DongHo.html">Giá trên 15 triệu</a></li>
                                </ul>
                            </div>
                            <div class="megamenu-column">
                                <ul>
                                    <li><a href="DongHo.html">Casio, G-Shock</a></li>
                                    <li><a href="DongHo.html">Olym Pianus</a></li>
                                    <li><a href="DongHo.html">Bentley</a></li>
                                    <li><a href="DongHo.html">Carnival, I&W Carnival</a></li>
                                    <li><a href="DongHo.html">Orient</a></li>
                                    <li><a href="DongHo.html">Tissot</a></li>
                                    <li><a href="DongHo.html">Seiko</a></li>
                                    <li><a href="DongHo.html">Citizen</a></li>
                                    <li><a href="DongHo.html">Bonest Gatti</a></li>
                                    <li><a href="DongHo.html">SRWatch</a></li>
                                    <li><a href="DongHo.html">Daniel Wellington</a></li>
                                    <li><a href="DongHo.html">Oblvlo</a></li>
                                </ul>
                            </div>
                            <div class="megamenu-column">
                                <ul>
                                    <li><a href="DongHo.html">Frederique Constant</a></li>
                                    <li><a href="DongHo.html">Longines</a></li>
                                    <li><a href="DongHo.html">Omega</a></li>
                                    <li><a href="DongHo.html">Orient Star</a></li>
                                    <li><a href="DongHo.html">Certina</a></li>
                                    <li><a href="DongHo.html">Maurice Lacroix</a></li>
                                    <li><a href="DongHo.html">Movado</a></li>
                                </ul>
                            </div>
                            <div class="megamenu-column">
                                <ul>
                                    <li><a href="DongHo.html">Kiểu dáng công sở</a></li>
                                    <li><a href="DongHo.html">Đồng hồ quân đội</a></li>
                                    <li><a href="DongHo.html">Đồng hồ cơ/automatic</a></li>
                                    <li><a href="DongHo.html">Đồng hồ lướt 99%</a></li>
                                    <li><a href="DongHo.html">Đồng hồ Luxury</a></li>
                                    <li><a href="DongHo.html">Đồng hồ để bàn</a></li>
                                    <li><a href="DongHo.html">Đồng hồ treo tường</a></li>
                                    <li><a href="DongHo.html">Đồng hồ Nhật</a></li>
                                    <li><a href="DongHo.html">Đồng hồ Thụy Sỹ</a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li><a href="DongHo.html">Nam</a></li>
                    <li><a href="DongHo.html">Nữ</a></li>
                    <li class="nav-item-has-dropdown">
                        <a href="PhuKien.html">Phụ kiện<i class="fa-solid fa-chevron-down"></i></a>
                        <div class="megamenu megamenu-phukien">
                            <div class="megamenu-column-phukien">
                                <ul>
                                    <li><a href="DongHo.html">Dây đồng hồ</a></li>
                                    <li><a href="DongHo.html">Hộp xoay đồng hồ</a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                </ul>
            </nav>
        </div>

        <!--Tim kiem, gio hang-->
        <div class="header-action">
            <ul class="ul-header-action">
                <!-- Tim kiem -->
                <li>
                    <div class="search-bar">
                        <input type="text" placeholder="Tìm là thấy">
                        <i class="fa-solid fa-magnifying-glass search-icon"></i>
                    </div>
                </li>
                <!-- Gio hang -->
                <li>
                    <a href="" class="action-icon cart-icon">
                        <i class="fa-solid fa-bag-shopping"></i>
                        <span class="cart-badge">3</span>
                    </a>
                </li>
                <!-- Yêu thích -->
                <li>
                    <a href="FavoritesList.html" class="action-icon">
                        <i class="fa-regular fa-heart"></i>
                        <span class="wishlist-count">(5)</span>
                    </a>
                </li>
                <!-- Nút đăng nhập -->
                <li>
                    <div class="container-button-login" style="text-align:center">
                        <a href="login.html" class="button button-login">
                            <span style="color: #fff">Đăng nhập</span>
                        </a>
                    </div>

                </li>
            </ul>
        </div>
    </header>

    <body>
        <!--Phần hình ảnh đầu trang  -->
        <div class="top" id="top">
            <div> <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/10/watchstore-dai-ly-ban-dong-ho-chinh-hang-uy-tin.jpg"> </div>
        </div>
        <!-- Phần slide show hình ảnh khách hàng tại cửa hàng -->
        <div class="slideshow-gallery-section">
            <button class="gallery-button prev-gallery" onclick="scrollSlider(-1)">❮</button>

            <div class="new-store-gallery-container" id="slide-list-img-new">
                <!-- TÔI ĐÃ XÓA class "full-row-gallery" khỏi tất cả các ảnh -->
                <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/tai-cua-hang-5.webp" alt="Bộ sưu tập ảnh cửa hàng VVP" class="gallery-image">
                <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/tai-cua-hang-5.webp" class="gallery-image">
                <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/tai-cua-hang.webp" class="gallery-image">
                <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/tai-cua-hang-3.webp" class="gallery-image">
                <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/tai-cua-hang-2.webp" class="gallery-image">
                <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/tai-cua-hang-3.webp" class="gallery-image">
                <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/tai-cua-hang-2.webp" class="gallery-image">
                <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/tai-cua-hang.webp" class="gallery-image">
                <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/tai-cua-hang-2.webp" class="gallery-image">
                <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/tai-cua-hang-5.webp" alt="Bộ sưu tập ảnh cửa hàng VVP" class="gallery-image">
                <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/tai-cua-hang.webp" class="gallery-image">
                <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/tai-cua-hang-3.webp" class="gallery-image">
                <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/tai-cua-hang-2.webp" class="gallery-image">
                <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/tai-cua-hang-3.webp" class="gallery-image">
                <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/tai-cua-hang-2.webp" class="gallery-image">
                <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/tai-cua-hang.webp" class="gallery-image">
            </div>

            <button class="gallery-button next-gallery" onclick="scrollSlider(1)">❯</button>
        </div>
        <!-- Nơi hội tụ những thương hiệu nổi tiếng -->
        <div class="thuonghieu">
            <div class="title-thuong-hieu"><a>NƠI HỘI TỤ NHỮNG THƯƠNG HIỆU ĐỒNG HỒ DANH TIẾNG</a></div>
            <div class="gioi-thieu-thuong-hieu">
                <div class="gioi-thieu-thuong-hieu-note">
                    <p>
                        Giữa thị trường đồng hồ đang phát triển sôi động, nơi chất lượng và
                        uy tín trở thành thước đo giá trị, WatchStore.vn đã khẳng định vị thế là đơn vị phân phối đồng hồ chính
                        hãng, đại lý ủy quyền cấp 1 của nhiều thương hiệu danh tiếng tại Việt Nam.
                    </p>
                </div>
                <div class="gioi-thieu-thuong-hieu-note">
                    <p>
                        Thành lập năm 2020, WatchStore mang sứ mệnh đem đến cho người tiêu
                        dùng Việt những mẫu đồng hồ minh bạch, đẳng cấp và chính hãng 100%. Ngay từ những ngày đầu, thương hiệu đã
                        chọn hướng đi bền vững, lấy chất lượng và niềm tin làm trọng tâm. Sau gần 5 năm phát triển, WatchStore đã
                        trở thành đại lý ủy quyền cấp 1 của nhiều thương hiệu đồng hồ quốc tế, được hàng trăm nghìn khách hàng tin
                        tưởng.
                    </p>
                </div>
            </div>
            <!--Hành trình Watch-store-->
        </div>
        <div class="hanh-trinh">
            <div class="hanh-trinh-title"><a>HÀNH TRÌNH PHÁT TRIỂN & SỨ MỆNH KHẲNG ĐỊNH GIÁ TRỊ THẬT</a></div>
            <div class="hanh-trinh-note">
                <a>
                    Được Anh Khuê Watch (nhà phân phối Casio tại Việt Nam) cấp giấy ủy quyền bán lẻ,
                    đánh dấu bước khởi đầu hành trình chính hãng.
                </a>
            </div>
            <div class="nam-phat-trien">
                <div class="cac-nam">
                    <div class="nam-title"><a>Năm 2021</a></div>
                    <div class="nam-note">
                        <p>
                            Trở thành đại lý ủy quyền của Orient và Seiko, khẳng định uy tín trong phân
                            khúc đồng hồ Nhật Bản.
                        </p>
                    </div>
                </div>
                <div class="cac-nam">
                    <div class="nam-title"><a>Năm 2022</a></div>
                    <div class="nam-note">
                        <p>
                            Mở rộng hợp tác cùng Frederique Constant, SRWatch, Freelook, Daniel Klein, đa
                            dạng hóa danh mục sản phẩm.
                        </p>
                    </div>
                </div>
                <div class="cac-nam">
                    <div class="nam-title"><a>Năm 2023</a></div>
                    <div class="nam-note">
                        <p>
                            Trở thành đối tác của Citizen, Ogival, Bentley, Olym Pianus, Olympia Star, I&W
                            Carnival, củng cố vị thế hàng đầu trong ngành.
                        </p>
                    </div>
                </div>
            </div>

        </div>
        <!--giá trị cốt lõi-->
        <div class="gia-tri">
            <div class="gia-tri-cot-loi-title"><a>GIÁ TRỊ CỐT LÕI – NỀN TẢNG VỮNG CHẮC CỦA UY TÍN WATCHSTORE</a></div>
            <div class="gia-tri-all">
                <div class="gia-tri-one">
                    <div class="gia-tri-a">
                        <div class="gia-tri-logo">
                            <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/08/ICON-CHAT-LUONG.jpg">
                        </div>
                        <div class="gia-tri-tile"><a>Chất lượng hàng đầu</a></div>
                        <div class="gia-tri-note"><p>Luôn mang đến cho khách hàng sản phẩm chất lượng tốt nhất</p></div>
                    </div>
                </div>
                <div class="gia-tri-three">
                    <div class="gia-tri-a">
                        <div class="gia-tri-logo">
                            <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/08/ICON-CHAT-LUONG.jpg">
                        </div>
                        <div class="gia-tri-tile"><a>Cam kết luôn tận tâm</a></div>
                        <div class="gia-tri-note">
                            <p>
                                Luôn đặt khách hàng là trung tâm trong mọi việc, có trách nhiệm với
                                những sản phẩm bán ra
                            </p>
                        </div>
                    </div>
                    <div class="gia-tri-a">
                        <div class="gia-tri-logo">
                            <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/08/ICON-CHAT-LUONG.jpg">
                        </div>
                        <div class="gia-tri-tile"><a>Luôn hoàn thiện & đổi mới</a></div>
                        <div class="gia-tri-note"><p>Luôn nỗ lực đổi mới đổi mới, hoàn thiện dịch vụ khách hàng</p></div>
                    </div>
                    <div class="gia-tri-a">
                        <div class="gia-tri-logo">
                            <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/08/ICON-CHAT-LUONG.jpg">
                        </div>
                        <div class="gia-tri-tile"><a>Phát triển bền vững</a></div>
                        <div class="gia-tri-note">
                            <p>
                                Luôn hợp tác với những đại lý, nhà phân phối, xây dựng thị trường đồng
                                hồ chính hãng trong sạch
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Danh sách cửa hàng -->
        <div class="dscuahang-title">
            <h1>DANH SÁCH CỬA HÀNG</h1>
        </div>

        <div class="grid-container">
            <div class="store-box">
                <h3>WatchStore Trần Đại Nghĩa</h3>
                <p>97 Trần Đại Nghĩa, HBT, Hà Nội</p>
                <a href="#">Xem chỉ đường</a>
            </div>
            <div class="store-box">
                <h3>WatchStore Trần Bằng Ninh</h3>
                <p>58 Trần Bằng Ninh, Q. Hai Bà Trưng, Hà Nội</p>
                <a href="#">Xem chỉ đường</a>
            </div>
            <div class="store-box">
                <h3>WatchStore Đà Nẵng</h3>
                <p>339 Lê Duẩn, Thanh Khê, Đà Nẵng</p>
                <a href="#">Xem chỉ đường</a>
            </div>
            <div class="store-box">
                <h3>WatchStore Bình Dương</h3>
                <p>642 CMT8, Thủ Dầu Một, Bình Dương</p>
                <a href="#">Xem chỉ đường</a>
            </div>
            <div class="store-box">
                <h3>WatchStore Lê Văn Sỹ</h3>
                <p>96 Lê Văn Sỹ, P11, Phú Nhuận, TPHCM</p>
                <a href="#">Xem chỉ đường</a>
            </div>
            <div class="store-box">
                <h3>WatchStore Quang Trung</h3>
                <p>9 Quang Trung, P10, Gò Vấp, TPHCM</p>
                <a href="#">Xem chỉ đường</a>
            </div>
        </div>

        <!-- Online Store -->
        <div class="kenh-mua-sam-online">
            <div class="kenh-mua-sam"><a>KÊNH MUA SẮM ONLINE CHÍNH THỨC</a></div>
            </br>
            <div class="kenh-mua-sam-note">
                <a>
                    Để phục vụ khách hàng trên toàn quốc, WatchStore.vn phát triển hệ thống mua
                    sắm trực tuyến đa nền tảng, đảm bảo mua hàng nhanh, nhận hàng chính hãng, bảo hành toàn quốc.
                </a>
            </div>
            <ul class="list-shop">
                <li> Facebook:<a href="#"> https://www.facebook.com/watchstore.vn</a></li>
                <li>Instagram:<a href="#"> https://www.instagram.com/watchstore.vietnam/#</a></li>
                <li>Shopee:<a href="#"> https://shopee.vn/watchstore.vn</a></li>
                <li>Tiktok Shop:<a href="#"> https://vt.tiktok.com/ZSUGoLeAo/?page=TikTokShop</a></li>
            </ul>
            <div class="kenh-mua-sam-note">
                <a>
                    Các kênh online của WatchStore thường xuyên cập nhật ưu đãi độc quyền, giảm
                    giá theo mùa và quà tặng chính hãng, giúp khách hàng dễ dàng sở hữu chiếc đồng hồ yêu thích dù ở bất kỳ
                    đâu.
                </a>
            </div>
        </div>

    </body>


    <footer>
        <div class="thongtintong">
            <div class="thongtin">
                <p>VỀ CHÚNG TÔI</p>
                <ul class="list-tt">
                    <li><a href="introduce.html"> Giới thiệu về WatchStore</a></li>
                    <li><a href="#"> Phản ánh - Khiếu nại</a></li>
                    <li><a href="#"> Chứng nhận đại lý</a></li>
                    <li><a href="#"> Tin tức công ty</a></li>
                    <li><a href="#"> Top list đồng hồ</a></li>
                    <li><a href="#"> Kiến thức đồng hồ</a></li>
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
                    <li><a href="#">Thông tin các trang TMĐT</a></li>
                </ul>
            </div>

            <div class="thongtin">
                <p>Cửa hàng Miền Bắc</p>
                <ul class="list-tt">
                    <li><a href="#">97 Trần Đại Nghĩa, P.Bạch Mai, Hà Nội</a></li>
                    <li><a href="#">58 Trần Đăng Ninh, P.Cầu Giấy, Hà Nội</a></li>
                </ul>
                <p>Cửa hàng Miền Trung</p>
                <ul class="list-tt">
                    <li><a href="#">339 Lê Duẩn, P.Thanh Khê, Đà Nẵng</a></li>
                </ul>
                <p>Cửa hàng Miền Nam</p>
                <ul class="list-tt">
                    <li><a href="#">642 CMT8, P.Thủ Dầu Một, HCM</a></li>
                    <li><a href="#">90 Lê Văn Sỹ, P.Phú Nhuận, HCM</a></li>
                    <li><a href="#">61 Quang Trung, P.Gò Vấp, HCM</a></li>
                </ul>
            </div>

            <div class="thongtin">
                <p>Liên hệ hỗ trợ</p>
                <ul class="list-tt">
                    <li><a href="#">Hotline 1: 093 189 222</a></li>
                    <li><a href="#">Hotline 2: 097 189 3333</a></li>
                    <li><a href="#">Hotline 3: 096 139 5555</a></li>
                </ul>
            </div>
        </div>
    </footer>
    <script src="js/index.js"></script>
    <script src="js/introduce.js"></script>
</body>
</html>