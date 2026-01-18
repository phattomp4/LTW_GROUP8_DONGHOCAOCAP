<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh mục sản phẩm</title>
    <link rel="stylesheet" href="css/DongHo.css">
    <link rel="stylesheet" href="Share/css/ProductCards.css">
    <link rel="stylesheet" href="Share/css/header.css">
    <link rel="stylesheet" href="Share/css/footer.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
          crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

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
                    <a href="login.jsp" class="action-icon cart-icon">
                        <i class="fa-solid fa-bag-shopping"></i>
                    </a>
                </li>
                <!-- Yêu thích -->
                <li>
                    <a href="login.jsp" class="action-icon">
                        <i class="fa-regular fa-heart"></i>
                    </a>
                </li>
                <!-- Nút đăng nhập -->
                <li>
                    <div class="container-button-login" style="text-align:center">
                        <a href="login.jsp" class="button button-login">
                            <span style="color: #fff">Đăng nhập</span>
                        </a>
                    </div>

                </li>
            </ul>
        </div>
    </header>

    <div class="Container-page">
        <h2 class="Tittle-page">Đồng hồ</h2>
        <div class="overlay" id="pageOverlay"></div>
        <div class="Filter">
            <button class="filter-button" id="filterButton"><i class="fa-solid fa-filter fa-2xs"></i>Bộ lọc</button>
            <div class="filter-dropdown" id="filterDropdown">

                <div class="filter-section brand-filter">
                    <h4>Hãng 🏷️</h4>
                    <label class="brand-item"><input type="checkbox" name="brand" value="Casio"> <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/03/cs-1362181789-1668935694-1712398047.jpg" alt="Casio"></label>
                    <label class="brand-item"><input type="checkbox" name="brand" value="Seiko"> <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/logo-seiko_1712552756.webp" alt="Seiko"></label>
                    <label class="brand-item"><input type="checkbox" name="brand" value="Olym"> <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/ov_1712552756.webp" alt="Olym Pianus"></label>
                    <label class="brand-item"><input type="checkbox" name="brand" value="Longines"> <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/lg_1712552756.webp" alt="Longines"></label>
                    <label class="brand-item"><input type="checkbox" name="brand" value="Bentley"> <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/bl_1712552756.webp" alt="Bentley"></label>
                    <label class="brand-item"><input type="checkbox" name="brand" value="Orient"> <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/om_1712552756.webp" alt="Orient"></label>
                    <label class="brand-item"><input type="checkbox" name="brand" value="Citizen"> <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/ct_1712552756.webp" alt="Citizen"></label>
                    <label class="brand-item"><input type="checkbox" name="brand" value="Hublot"> <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/hb_1712552838.webp" alt="Hublot"></label>
                    <label class="brand-item"><input type="checkbox" name="brand" value="SR"> <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/logo-srwatch_1712552756.webp" alt="SRWatch"></label>
                    <label class="brand-item"><input type="checkbox" name="brand" value="G-shock"> <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/op_1712552838.webp" alt="OP"></label>
                    <label class="brand-item"><input type="checkbox" name="brand" value="Tissot"> <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/logo-tissot_1712552859.webp" alt="Tissot"></label>
                </div>

                <hr>

                <div class="filter-section">
                    <h4>Giá (VNĐ) 💰</h4>
                    <label><input type="radio" name="price" value="under_1m"> Dưới 1 Triệu</label><br>
                    <label><input type="radio" name="price" value="1m_to_5m"> Từ 1 Triệu - 5 Triệu</label><br>
                    <label><input type="radio" name="price" value="over_5m"> Từ 6 - 9 Triệu</label><br>
                    <label><input type="radio" name="price" value="over_5m"> Từ 9 - 15 Triệu</label><br>
                    <label><input type="radio" name="price" value="over_5m"> Từ 15 - 30 Triệu</label><br>
                    <label><input type="radio" name="price" value="over_5m"> Từ 30 - 50 Triệu</label><br>
                    <label><input type="radio" name="price" value="over_5m"> Từ 50 - 80 Triệu</label><br>
                    <label><input type="radio" name="price" value="over_5m"> Từ 80 - 120 Triệu</label><br>
                    <label><input type="radio" name="price" value="over_5m"> Từ 120 - 150 Triệu</label><br>
                    <label><input type="radio" name="price" value="over_5m">150 Triệu</label><br>

                </div>

                <hr>
                <button class="apply-button">Áp dụng</button>
            </div>

        </div>

        <div class="Items-area">
            <div href="" class="link-product">
                <div class="Product">
                    <a href="login.jsp" class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                        <i class="fa-regular fa-heart"></i>
                    </a>
                    <a href="TrangChiTietSanPham.html" class="img-product" ><img src="https://www.watchstore.vn/wp-content/uploads/2023/11/8907g-vt-d-1-1173700471-248243325-1712668536-400x400.jpg" alt=""></a>
                    <br />
                    <a href="TrangChiTietSanPham.html"><p class="Item">Carnival 40mm Nam 8907G-VT-D</p></a>
                    <p class="PriceOfPoduct">3.801.000₫</p>
                    <div class="Discount-row">
                        <p class="Discount">5.430.000₫</p>
                        <p class="DiscountPercent">-30%</p>
                    </div>
                    <p class="Sold">Đã bán 88</p>
                </div>
            </div>
            <div class="link-product">
                <div class="Product">
                    <a href="login.jsp" class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                        <i class="fa-regular fa-heart"></i>
                    </a>
                    <a href="TrangChiTietSanPham.html" class="img-product" ><img src="https://www.watchstore.vn/wp-content/uploads/2023/11/8907g-vt-t-1-348948390-593092946-1712668541-400x400.jpg" alt=""></a>
                    <br />
                    <a href="TrangChiTietSanPham.html"><p class="Item">Carnival 40mm Nam 8907G-VT-T</p></a>
                    <p class="PriceOfPoduct">3.801.000₫</p>
                    <div class="Discount-row">
                        <p class="Discount">5.430.000₫ </p>
                        <p class="DiscountPercent">-30%</p>
                    </div>
                    <p class="Sold">Đã bán 114</p>
                </div>
            </div>
            <div class="link-product">
                <div class="Product">
                    <a href="login.jsp" class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                        <i class="fa-regular fa-heart"></i>
                    </a>
                    <a href="TrangChiTietSanPham.html" class="img-product" ><img src="https://www.watchstore.vn/wp-content/uploads/2025/06/carnival-8907g-vt-tf-400x400.jpg" alt=""></a>
                    <br />
                    <a href="TrangChiTietSanPham.html"><p class="Item">Carnival 40mm Nam 8907G-VT-XT</p></a>
                    <p class="PriceOfPoduct">3.801.000₫</p>
                    <div class="Discount-row">
                        <p class="Discount">5.430.000₫</p>
                        <p class="DiscountPercent">-30%</p>
                    </div>

                    <p class="Sold">Đã bán 1</p>
                </div>
            </div>
            <div class="link-product">
                <div class="Product">
                    <a href="login.jsp" class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                        <i class="fa-regular fa-heart"></i>
                    </a>
                    <a href="TrangChiTietSanPham.html" class="img-product" ><img src="https://www.watchstore.vn/wp-content/uploads/2023/11/8907g-vt-t-1-348948390-593092946-1712668541-400x400.jpg" alt=""></a>
                    <br />
                    <a href="TrangChiTietSanPham.html"><p class="Item">Carnival 41mm Nam 8110G-VH-DD-N</p></a>
                    <p class="PriceOfPoduct">4.851.000₫</p>
                    <div class="Discount-row">
                        <p class="Discount">6930.000₫</p>
                        <p class="DiscountPercent">-30%</p>
                    </div>
                    <p class="Sold">Đã bán 51</p>
                </div>
            </div>
            <div class="link-product">
                <div class="Product">
                    <a href="login.jsp" class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                        <i class="fa-regular fa-heart"></i>
                    </a>
                    <a href="TrangChiTietSanPham.html" class="img-product" ><img src="https://www.watchstore.vn/wp-content/uploads/2020/11/1-khung-sp-6676612-1785849039-1712554705-400x400.jpg" alt=""></a>
                    <br />
                    <a href="TrangChiTietSanPham.html"><p class="Item">Casio 45 X 42.1mm Nam AE-1200WHD-1A</p></a>
                    <p class="PriceOfPoduct">1.204.800₫</p>
                    <div class="Discount-row">
                        <p class="Discount">1.506.000₫</p>
                        <p class="DiscountPercent">-20%</p>
                    </div>
                    <p class="Sold">Đã bán 1,4k</p>
                </div>
            </div>
            <div class="link-product">
                <div class="Product">
                    <a href="login.jsp" class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                        <i class="fa-regular fa-heart"></i>
                    </a>
                    <a href="TrangChiTietSanPham.html" class="img-product" ><img src="https://www.watchstore.vn/wp-content/uploads/2020/11/1-khung-sp-1-1818542633-1853976209-1712563883-400x400.jpg" alt=""></a>
                    <br />
                    <a href="TrangChiTietSanPham.html"><p class="Item">Casio MTP-1374L-1A</p></a>
                    <p class="PriceOfPoduct">1.816.000₫</p>
                    <div class="Discount-row">
                        <p class="Discount">2.270.000₫ </p>
                        <p class="DiscountPercent">-20%</p>
                    </div>

                    <p class="Sold">Đã bán 1,2k</p>
                </div>
            </div>
            <div class="link-product">
                <div class="Product">
                    <a href="login.jsp" class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                        <i class="fa-regular fa-heart"></i>
                    </a>
                    <a href="TrangChiTietSanPham.html" class="img-product" ><img src="https://www.watchstore.vn/wp-content/uploads/2022/05/op990-45adgs-gl-d-1-1655171724651-1712585288-400x400.jpg" alt=""></a>
                    <br />
                    <a href="TrangChiTietSanPham.html"><p class="Item">Olym Pianus 42mm Nam OP990-45ADGS-GL-D</p></a>
                    <p class="PriceOfPoduct">6.776.000₫</p>
                    <div class="Discount-row">
                        <p class="Discount">8.800.000₫</p>
                        <p class="DiscountPercent">-23%</p>
                    </div>
                    <p class="Sold">Đã bán 348</p>
                </div>
            </div>
            <div class="link-product">
                <div class="Product">
                    <a href="login.jsp" class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                        <i class="fa-regular fa-heart"></i>
                    </a>
                    <a href="TrangChiTietSanPham.html" class="img-product" ><img src="https://cdn.watchstore.vn/wp-content/uploads/2022/05/t137-679443174-610497435-1712585231-400x400.jpg" alt=""></a>
                    <br />
                    <a href="TrangChiTietSanPham.html"><p class="Item">Tissot 40mm Nam T137.407.11.041.00</p></a>
                    <p class="PriceOfPoduct">17.900.000₫</p>
                    <div class="Discount-row">
                        <p class="Discount">20.610.000₫</p>
                        <p class="DiscountPercent">-13%</p>
                    </div>

                    <p class="Sold">Đã bán 118</p>
                </div>
            </div>
            <div class="link-product">
                <div class="Product">
                    <a href="login.jsp" class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                        <i class="fa-regular fa-heart"></i>
                    </a>
                    <a href="TrangChiTietSanPham.html" class="img-product" ><img src="https://www.watchstore.vn/wp-content/uploads/2023/11/bg5605-a2-1-322274342-559280603-1712669076-400x400.jpg" alt=""></a>
                    <br />
                    <a href="TrangChiTietSanPham.html"><p class="Item">Bonest Gatti 47mm Nam BG5605-A2</p></a>
                    <p class="PriceOfPoduct">7.035.000₫</p>
                    <div class="Discount-row">
                        <p class="Discount">10.500.000₫</p>
                        <p class="DiscountPercent">-33%</p>
                    </div>
                    <p class="Sold">Đã bán 32</p>
                </div>
            </div>
            <div class="link-product">
                <div class="Product">
                    <a href="login.jsp" class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                        <i class="fa-regular fa-heart"></i>
                    </a>
                    <a href="TrangChiTietSanPham.html" class="img-product" ><img src="https://www.watchstore.vn/wp-content/uploads/2023/10/8113g-vt-dcs-t-1-213290406-1626795257-1712667500-400x400.jpg" alt=""></a>
                    <br />
                    <a href="TrangChiTietSanPham.html"><p class="Item">Carnival 41mm Nam 8113G-VT-DCS-T</p></a>
                    <p class="PriceOfPoduct">3.801.000₫</p>
                    <div class="Discount-row">
                        <p class="Discount">5.430.000₫</p>
                        <p class="DiscountPercent">-30%</p>
                    </div>

                    <p class="Sold">Đã bán 34</p>
                </div>
            </div>
            <div class="link-product">
                <div class="Product">
                    <a href="login.jsp" class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                        <i class="fa-regular fa-heart"></i>
                    </a>
                    <a href="TrangChiTietSanPham.html" class="img-product" ><img src="https://www.watchstore.vn/wp-content/uploads/2025/06/z6676116817384_61de97491cbb4ca1c7731896b9c800cc_1749192353-400x445.jpg" alt=""></a>
                    <br />
                    <a href="TrangChiTietSanPham.html"><p class="Item">Carnival 41mm Nam 8113G-CH-D</p></a>
                    <p class="PriceOfPoduct">4.480.000₫</p>
                    <div class="Discount-row">
                        <p class="Discount">6.400.000₫</p>
                        <p class="DiscountPercent">-30%</p>
                    </div>
                    <p class="Sold">Đã bán 2</p>
                </div>
            </div>
            <div class="link-product">
                <div class="Product">
                    <a href="login.jsp" class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                        <i class="fa-regular fa-heart"></i>
                    </a>
                    <a href="TrangChiTietSanPham.html" class="img-product" ><img src="https://www.watchstore.vn/wp-content/uploads/2024/06/8131g-ch-n-1_1724295646-400x400.jpg" alt=""></a>
                    <br />
                    <a href="TrangChiTietSanPham.html"><p class="Item">Carnival 41mm Nam 8113G-CH-N</p></a>
                    <p class="PriceOfPoduct">4.347.000₫</p>
                    <div class="Discount-row">
                        <p class="Discount">6.210.000₫</p>
                        <p class="DiscountPercent">-30%</p>
                    </div>
                    <p class="Sold">Đã bán 53</p>
                </div>
            </div>
        </div>
        <div class="pagination">
            <a href="#">&laquo;</a>
            <a class="active" href="#">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <a href="#">4</a>
            <a href="#">5</a>
            <a href="#">6</a>
            <a href="#">&raquo;</a>
        </div>
    </div>
    <script src="js/DongHo.js"></script>
    <script src="js/index.js"></script>
</body>
</html>