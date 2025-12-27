<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../assets/css/header.css">
    <link rel="stylesheet" href="../assets/css/footer.css">
    <link rel="stylesheet" href="../assets/css/GioHang.css">
    <!-- Linking Font Awesome-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
    <title>Giỏ hàng</title>
</head>

<body>

    <header class="main-header">

        <!--Logo-->
        <div class="logo-container-header">
            <a href="index.html" class="logo-header">
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
                    <a href="GioHang.html" class="action-icon cart-icon">
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
                    <div class="profile-dropdown">

                        <button class="profile-avatar-btn" id="profile-btn">
                            <img src="https://icons.veryicon.com/png/o/miscellaneous/standard/avatar-15.png" alt="User Avatar">
                        </button>

                        <div class="dropdown-menu" id="profile-menu">
                            <div class="menu-header">
                                TÔ TẤN PHÁT
                            </div>
                            <a href="ProfileUser.html"><i class="fa-solid fa-user"></i><span>Hồ sơ</span></a>
                            <div class="divider"></div>
                            <a href="../index.html"><i class="fa-solid fa-sign-out"></i><span>Đăng xuất</span></a>
                        </div>

                    </div>

                </li>
            </ul>
        </div>
    </header>

    <div class="cart-container">
        <!-- Danh sách sản phẩm -->
        <div class="product-list">
            <div class="cart-header">
                <span>Sản phẩm</span>
                <span>Tổng</span>
            </div>

            <c:if test="${empty sessionScope.cart}">
                <p style="text-align: center; padding: 20px;">Giỏ hàng của bạn đang trống!</p>
            </c:if>

            <c:forEach items="${sessionScope.cart}" var="item">
                <div class="product-item">
                    <div class="item-main">
                        <img src="${item.product.imageUrl}" alt="${item.product.name}">

                        <div class="item-details">
                            <a href="detail?id=${item.product.id}" class="product-name">${item.product.name}</a>

                            <div class="price-info">
                        <span class="old-price">
                             <fmt:formatNumber value="${item.product.originalPrice}" type="currency" currencySymbol="₫"/>
                        </span>
                                <span class="new-price">
                             <fmt:formatNumber value="${item.product.currentPrice}" type="currency" currencySymbol="₫"/>
                        </span>
                            </div>
                        </div>
                    </div>

                    <div class="item-total">
                <span>
                    <fmt:formatNumber value="${item.totalPrice}" type="currency" currencySymbol="₫"/>
                </span>
                    </div>

                    <div class="item-actions">
                        <div class="quantity-selector">
                            <button type="button">-</button>
                            <input type="text" value="${item.quantity}" readonly>
                            <button type="button">+</button>
                        </div>
                        <a href="cart?action=remove&id=${item.product.id}" class="remove-link">Xóa sản phẩm</a>
                    </div>
                </div>
            </c:forEach>
        </div>

        <!-- Tổng tiền giỏ hàng -->
        <div class="order-summary">
            <h3>TỔNG CỘNG GIỎ HÀNG</h3>
            <!-- Chọn mã giảm giá -->
            <div class="summary-row">
                <select>
                    <option value="">Thêm mã giảm giá</option>
                    <option value="GIAMGIA10">GIAMGIA10</option>
                    <option value="MIENPHIVC">MIENPHIVC</option>
                </select>
            </div>
            <!-- Chi tiết mã giảm giá -->
            <div class="summary-row">
                <span>Miễn phí vận chuyển</span>
                <span>MIỄN PHÍ</span>
            </div>
            <!-- Tổng tiền -->
            <div class="summary-total">
                <span>Tổng ước tính</span>
                <span class="total-price">
    <fmt:formatNumber value="${sessionScope.totalCartPrice != null ? sessionScope.totalCartPrice : 0}" type="currency" currencySymbol="₫"/>
</span>
            </div>
            <!-- Nút thanh toán -->
            <a href="ThanhToan.html" class="checkout-button"><span style="color: #fff">Tiến hành thanh toán</span></a>

        </div>
    </div>

    <footer>
        <div class="thongtintong">
            <div class="thongtin">
                <p>VỀ CHÚNG TÔI</p>
                <ul class="list-tt">
                    <li><a href="#"> Giới thiệu về WatchStore</a></li>
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

    <script src="../js/index.js"></script>
</body>
</html>