<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Trang chủ cửa hàng</title>
    <link rel="stylesheet" href="assets/css/index.css">
    <link rel="stylesheet" href="assets/css/ProductCards.css">
    <link rel="stylesheet" href="assets/css/header.css">
    <link rel="stylesheet" href="assets/css/footer.css">
    <!-- Linking SwiperJS CSS-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.css" />
    <!-- Linking Font Awesome-->
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
                                    <li><a href="PhuKien.html">Dây đồng hồ</a></li>
                                    <li><a href="PhuKien.html">Hộp xoay đồng hồ</a></li>
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
                    <a href="login.html" class="action-icon cart-icon">
                        <i class="fa-solid fa-bag-shopping"></i>
                    </a>
                </li>
                <!-- Yêu thích -->
                <li>
                    <a href="login.html" class="action-icon">
                        <i class="fa-regular fa-heart"></i>
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


    <!-- Slideshow container -->
    <div class="slideshow-container">

        <!-- Full-width images with number and caption text -->
        <div class="mySlides fade">
            <img src="https://www.watchstore.vn/wp-content/uploads/2025/07/carnivial-chi-tu-3-trieu.webp" style="width:100%">
        </div>
        <div class="mySlides fade">
            <img src="https://www.watchstore.vn/wp-content/uploads/2025/10/banner-dong-ho-20-10-1.jpg" style="width:100%">
        </div>

        <div class="mySlides fade">
            <img src="https://www.watchstore.vn/wp-content/uploads/2025/10/banner-tieu-rolex-pc.jpg" style="width:100%">
        </div>



        <!-- Next and previous buttons -->
        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
        <a class="next" onclick="plusSlides(1)">&#10095;</a>

        <!-- The dots/circles -->
        <div class="dots-container" style="text-align:center">
            <span class="dot" onclick="currentSlide(1)"></span>
            <span class="dot" onclick="currentSlide(2)"></span>
            <span class="dot" onclick="currentSlide(3)"></span>
        </div>
    </div>
    <br>



    <!-- Service-->
    <div class="service">
        <div class="icon-box">
            <div class="icon-box-img" style="width: 28px">
                <div class="icon">
                    <div class="icon-inner" style="color:#1b6e76;">
                        <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 32 32" fill="none"> <path d="M16 25C20.9706 25 25 20.9706 25 16C25 11.0294 20.9706 7 16 7C11.0294 7 7 11.0294 7 16C7 20.9706 11.0294 25 16 25Z" fill="white" stroke="white" stroke-width="2" stroke-miterlimit="10"></path> <path d="M16 11V16H21" stroke="#1b6e76" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path> <path d="M11 8.51597L11.851 3.82162C11.8928 3.5911 12.0142 3.38257 12.1941 3.23241C12.3739 3.08225 12.6007 3 12.835 3H19.165C19.3993 3 19.6261 3.08225 19.8059 3.23241C19.9858 3.38257 20.1072 3.5911 20.149 3.82162L21 8.516" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path> <path d="M11 23.484L11.851 28.1784C11.8928 28.4089 12.0142 28.6174 12.1941 28.7676C12.3739 28.9178 12.6007 29 12.835 29H19.165C19.3993 29 19.6261 28.9178 19.8059 28.7676C19.9858 28.6174 20.1072 28.4089 20.149 28.1784L21 23.484" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path> </svg>
                    </div>
                </div>
            </div>

            <div class="icon-box-text">
                <h4>Mẫu mã đa dạng nhất</h4>
                <p>Hoàn tiền nếu phát hiện bán hàng giả</p>
            </div>
        </div>

        <div class="icon-box">
            <div class="icon-box-img" style="width: 28px">
                <div class="icon">
                    <div class="icon-inner" style="color:rgb(255, 255, 255);">
                        <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 32 32" fill="none"> <path d="M5.72973 26.1991L5.71678 26.2834L10.8086 22.7549L10.8679 22.7747C10.8679 22.7747 10.8679 22.7747 10.8679 22.7747C10.9465 22.5388 11.1157 22.3438 11.3381 22.2326C11.5605 22.1214 11.8179 22.1031 12.0538 22.1817C12.2897 22.2603 12.4847 22.4295 12.5959 22.6519C12.7071 22.8742 12.7254 23.1317 12.6468 23.3676C11.9723 25.3906 10.3649 26.8805 7.98801 27.6728C6.92122 28.0255 5.80861 28.2204 4.68545 28.2512C4.43711 28.251 4.199 28.1523 4.02338 27.9766C3.84777 27.801 3.74902 27.5629 3.74878 27.3146C3.77965 26.1914 3.97453 25.0788 4.32725 24.012C5.1196 21.6351 6.60939 20.0276 8.63244 19.3533L8.63248 19.3532C8.7493 19.3142 8.87266 19.2986 8.99553 19.3073C9.11839 19.3159 9.23834 19.3487 9.34853 19.4038C9.45871 19.4588 9.55697 19.535 9.63769 19.628C9.71841 19.7211 9.78001 19.8291 9.81896 19.9459C9.85792 20.0628 9.87347 20.1862 9.86472 20.309C9.85598 20.4319 9.82311 20.5518 9.768 20.662C9.71289 20.7721 9.63661 20.8703 9.54353 20.951C9.45044 21.0317 9.34238 21.0932 9.22551 21.1321L9.22548 21.1321C7.97783 21.5479 7.16244 22.4328 6.63035 23.4029C6.09865 24.3723 5.84799 25.4298 5.72973 26.1991Z" fill="white" stroke="white" stroke-width="0.125"></path> <path d="M28.4514 5.22757C28.3899 4.80408 28.1932 4.4118 27.8906 4.10922C27.588 3.80664 27.1957 3.60995 26.7722 3.54849C25.3615 3.33798 21.6946 3.23434 18.1211 6.80765L16.9998 7.92898H9.34302C9.08027 7.92829 8.81998 7.9797 8.57722 8.08024C8.33446 8.18079 8.11404 8.32846 7.92872 8.51473L3.88599 12.5575C3.63004 12.8135 3.44836 13.1342 3.36033 13.4853C3.2723 13.8364 3.28122 14.2048 3.38613 14.5513C3.49104 14.8978 3.68802 15.2092 3.95605 15.4525C4.22408 15.6958 4.55312 15.8618 4.90809 15.9328L9.84995 16.9212L15.0787 22.1499L16.067 27.0918C16.1379 27.4469 16.3039 27.776 16.5472 28.0441C16.7905 28.3122 17.102 28.5093 17.4486 28.6142C17.7951 28.7191 18.1636 28.728 18.5148 28.6398C18.8659 28.5517 19.1866 28.3699 19.4425 28.1138L23.4852 24.071C23.6715 23.8857 23.8192 23.6653 23.9197 23.4226C24.0203 23.1799 24.0716 22.9196 24.0709 22.6569V15L25.1923 13.8787C28.7658 10.3052 28.662 6.63833 28.4514 5.22757ZM9.34302 9.92898H14.9998L10.0143 14.9145L5.3003 13.9717L9.34302 9.92898ZM22.0709 22.6569L18.0282 26.6996L17.0854 21.9856L22.0709 17.0001L22.0709 22.6569Z" fill="white"></path> </svg>
                    </div>
                </div>
            </div>

            <div class="icon-box-text">
                <h4>Miễn phí vận chuyển</h4>
                <p>Giao hàng nhanh, đóng gói cẩn thận</p>
            </div>
        </div>

        <div class="icon-box">
            <div class="icon-box-img" style="width: 28px">
                <div class="icon">
                    <div class="icon-inner" style="color:rgb(255, 255, 255);">
                        <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 32 32" fill="none"> <path d="M24 7.06252H24.0625V7.00002V5.00002C24.0625 4.81459 24.1175 4.63333 24.2205 4.47915C24.3236 4.32498 24.47 4.20481 24.6413 4.13386C24.8126 4.0629 25.0011 4.04434 25.183 4.08052C25.3648 4.1167 25.5319 4.206 25.663 4.33712L25.7071 4.29301L25.663 4.33712L28.663 7.33712C28.8388 7.51293 28.9376 7.75138 28.9376 8.00002C28.9376 8.24865 28.8388 8.4871 28.663 8.66291L25.663 11.6629C25.5319 11.794 25.3648 11.8833 25.183 11.9195C25.0011 11.9557 24.8126 11.9371 24.6413 11.8662C24.47 11.7952 24.3236 11.6751 24.2205 11.5209C24.1175 11.3667 24.0625 11.1854 24.0625 11V9.00002V8.93752H24H12H12C10.1275 8.93963 8.33241 9.68438 7.0084 11.0084C5.6844 12.3324 4.93964 14.1275 4.93753 15.9999V16C4.93753 16.2487 4.83876 16.4871 4.66295 16.6629C4.48713 16.8387 4.24867 16.9375 4.00003 16.9375C3.75139 16.9375 3.51294 16.8387 3.33712 16.6629C3.16131 16.4871 3.06254 16.2487 3.06253 16.0001C3.06521 13.6305 4.0077 11.3588 5.68323 9.68322C7.35878 8.00768 9.63053 7.06518 12.0001 7.06252H24ZM20 23.0625H20.0001C21.8725 23.0604 23.6677 22.3157 24.9917 20.9916C26.3157 19.6676 27.0604 17.8725 27.0625 16.0001V16C27.0625 15.7514 27.1613 15.5129 27.3371 15.3371C27.5129 15.1613 27.7514 15.0625 28 15.0625C28.2487 15.0625 28.4871 15.1613 28.6629 15.3371C28.8387 15.5129 28.9375 15.7513 28.9375 15.9999C28.9349 18.3695 27.9924 20.6413 26.3168 22.3168C24.6413 23.9924 22.3695 24.9348 20 24.9375H8.00003H7.93753V25V27C7.93753 27.1854 7.88255 27.3667 7.77953 27.5209C7.67651 27.6751 7.53009 27.7952 7.35878 27.8662C7.18746 27.9371 6.99896 27.9557 6.8171 27.9195C6.63523 27.8833 6.46819 27.794 6.33707 27.6629L3.33707 24.6629C3.16127 24.4871 3.0625 24.2486 3.0625 24C3.0625 23.7514 3.16127 23.5129 3.33707 23.3371L6.33707 20.3371C6.46819 20.206 6.63523 20.1167 6.8171 20.0805C6.99896 20.0443 7.18746 20.0629 7.35878 20.1339C7.53009 20.2048 7.67651 20.325 7.77953 20.4792C7.88255 20.6333 7.93753 20.8146 7.93753 21V23V23.0625H8.00003H20Z" fill="white" stroke="white" stroke-width="0.125"></path> </svg>
                    </div>
                </div>
            </div>

            <div class="icon-box-text">
                <h4>Đổi hàng 7 ngày</h4>
                <p>1 đổi 1 trong 7 ngày với sản phẩm lỗi</p>
            </div>
        </div>

        <div class="icon-box">
            <div class="icon-box-img" style="width: 28px">
                <div class="icon">
                    <div class="icon-inner" style="color:rgb(255, 255, 255);">
                        <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 32 32" fill="none"> <path d="M15.3991 29.7943L15.3987 29.7942C13.5007 29.1654 4.06262 25.4711 4.06262 14.333V7.00004C4.0633 6.48638 4.26765 5.99396 4.63086 5.63074C4.99409 5.26752 5.48653 5.06317 6.0002 5.0625L26.0001 5.0625C26.5137 5.06318 27.0062 5.26753 27.3694 5.63074C27.7326 5.99396 27.937 6.48641 27.9376 7.00008V14.333C27.9376 25.472 18.4985 29.1654 16.6016 29.7942L16.6011 29.7943C16.2114 29.9266 15.7889 29.9266 15.3991 29.7943ZM22.3322 13.6611C22.3885 13.5904 22.4357 13.5126 22.4724 13.4296C22.529 13.302 22.5598 13.1644 22.5631 13.0248C22.5665 12.8852 22.5423 12.7463 22.4919 12.6161C22.4415 12.4859 22.366 12.3668 22.2696 12.2658C22.1732 12.1648 22.0579 12.0837 21.9302 12.0273C21.8024 11.9709 21.6648 11.9402 21.5252 11.937C21.3856 11.9338 21.2468 11.9581 21.1166 12.0086C20.9864 12.0591 20.8674 12.1347 20.7665 12.2312L14.1661 18.5308L11.2337 15.7312C11.2337 15.7312 11.2337 15.7312 11.2337 15.7312C11.1328 15.6347 11.0138 15.5591 10.8836 15.5086C10.7535 15.4581 10.6146 15.4338 10.475 15.437C10.3354 15.4402 10.1978 15.4709 10.0701 15.5273C9.94236 15.5837 9.82701 15.6648 9.73062 15.7658C9.63423 15.8668 9.55869 15.9859 9.50833 16.1161C9.45797 16.2463 9.43377 16.3852 9.43711 16.5248C9.44045 16.6644 9.47127 16.802 9.5278 16.9296C9.58433 17.0573 9.66548 17.1726 9.76659 17.2689L13.4325 20.7688L13.4326 20.7689C13.6303 20.9574 13.893 21.0625 14.1661 21.0625C14.4393 21.0625 14.702 20.9574 14.8997 20.7689L14.8997 20.7688L22.2337 13.7688L22.3466 13.6611H22.3322Z" fill="white" stroke="white" stroke-width="0.125"></path> </svg>
                    </div>
                </div>
            </div>

            <div class="icon-box-text">
                <h4>Bảo hành 5 năm</h4>
                <p>Thụ tục nhanh gọn, thay pin miễn phí</p>
            </div>
        </div>

        <div class="icon-box">
            <div class="icon-box-img" style="width: 32px">
                <div class="icon">
                    <div class="icon-inner">
                        <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 32 32" fill="none"> <path d="M6.80761 25.1924C5.65711 24.0419 6.42019 21.6265 5.8346 20.2111C5.22755 18.744 3 17.5631 3 16C3 14.4368 5.22756 13.256 5.8346 11.7888C6.4202 10.3735 5.65711 7.95811 6.80761 6.80761C7.95811 5.65711 10.3735 6.42019 11.7889 5.8346C13.256 5.22755 14.4369 3 16 3C17.5632 3 18.744 5.22756 20.2112 5.8346C21.6265 6.4202 24.0419 5.65711 25.1924 6.80761C26.3429 7.95811 25.5798 10.3735 26.1654 11.7889C26.7725 13.256 29 14.4369 29 16C29 17.5632 26.7724 18.744 26.1654 20.2112C25.5798 21.6265 26.3429 24.0419 25.1924 25.1924C24.0419 26.3429 21.6265 25.5798 20.2111 26.1654C18.744 26.7725 17.5631 29 16 29C14.4368 29 13.256 26.7724 11.7888 26.1654C10.3735 25.5798 7.95811 26.3429 6.80761 25.1924Z" fill="white" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path> <path d="M21.5 13L14.1666 20L10.5 16.5" stroke="#1b6e76" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path> </svg>
                    </div>
                </div>
            </div>

            <div class="icon-box-text">
                <h4>Đeo trước trả sau</h4>
                <p>Hoàn tiền nếu phát hiện bán hàng giả</p>
            </div>
        </div>
    </div>


    <!-- Introduce -->
    <div class="introduce-text">
        <div class="introduce-section container-introduce-title" style="margin-left: auto; margin-right: auto; width: 80%">
            <h1 class="introduce-title" style="margin-bottom:0">
                <b aria-hidden="true" style="background-color: black; display: block; flex: 1; height: 2px; opacity: .1"></b>
                <span style="font-size: 90%; margin: 0 15px; font-weight: 500">ĐỒNG HỒ ĐEO TAY CHÍNH HÃNG</span>
                <b aria-hidden="true" style="background-color: black; display: block; flex: 1; height: 2px; opacity: .1"></b>
            </h1>
        </div>

        <div class="introduce-section">
            <p id="text-introduce">
                <a href="">VVP.VN</a> cung cấp đa dạng mẫu đồng hồ theo nhiều phong cách khác nhau.
            </p>
            <style>
                #text-introduce {
                    text-align: center;
                    font-size: 12px;
                }
            </style>
        </div>

        <div class="introduce-section container-button-introduce">
            <div class="button-introduce" style="text-align:center">
                <a href="" class="button button-flash-sales" style="border-radius:7px;">
                    <span style="color: #fff">CASIO MÙA HÈ 2025 GIẢM GIÁ SHOCK  45% - FLASH SALES</span>
                </a>
            </div>
        </div>

    </div>

    <div class="container-introduce-brand">
        <div class="introduce-brand">
            <div class="row-brand">
                <div class="brand">
                    <div class="container-img-brand">
                        <a href="" target="_blank" style="text-decoration: none">
                            <div class="img-brand">
                                <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/small-web-banner-xu-huong-2024_1725589299.webp" width="232" height="99">
                            </div>
                        </a>
                    </div>

                    <div class="text-brand">
                        <h4>Xu hướng 2025</h4>
                    </div>
                </div>

                <div class="brand">
                    <div class="container-img-brand">
                        <a href="" target="_blank" style="text-decoration: none">
                            <div class="img-brand">
                                <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/small-web-banner-baby-g_1725596682.webp" width="232" height="99">
                            </div>
                        </a>
                    </div>

                    <div class="text-brand">
                        <h4>Baby-G cá tính</h4>
                    </div>
                </div>

                <div class="brand">
                    <div class="container-img-brand">
                        <a href="" target="_blank" style="text-decoration: none">
                            <div class="img-brand">
                                <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/small-web-banner-g-shock_1725589299.webp" width="232" height="99">
                            </div>
                        </a>
                    </div>

                    <div class="text-brand">
                        <h4>G-Shock thể thao</h4>
                    </div>
                </div>

                <div class="brand">
                    <div class="container-img-brand">
                        <a href="" target="_blank" style="text-decoration: none">
                            <div class="img-brand">
                                <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/small-web-banner-quan-doi_1725598290.webp" width="232" height="99">
                            </div>
                        </a>
                    </div>

                    <div class="text-brand">
                        <h4>Quân đội mạnh mẽ</h4>
                    </div>
                </div>
            </div>
        </div>

        <div class="introduce-brand">
            <div class="row-brand">
                <div class="brand">
                    <div class="container-img-brand">
                        <a href="" target="_blank" style="text-decoration: none">
                            <div class="img-brand">
                                <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/small-web-banner-tissot_1725589299.webp" width="232" height="99">
                            </div>
                        </a>
                    </div>

                    <div class="text-brand">
                        <h4>Tissot sang trọng</h4>
                    </div>
                </div>

                <div class="brand">
                    <div class="container-img-brand">
                        <a href="" target="_blank" style="text-decoration: none">
                            <div class="img-brand">
                                <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/small-web-banner-casio-ltp_1725589299.webp" width="232" height="99">
                            </div>
                        </a>
                    </div>

                    <div class="text-brand">
                        <h4>Casio LTP nữ tính</h4>
                    </div>
                </div>

                <div class="brand">
                    <div class="container-img-brand">
                        <a href="" target="_blank" style="text-decoration: none">
                            <div class="img-brand">
                                <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/small-web-banner-casio-mtp_1725589299.webp" width="232" height="99">
                            </div>
                        </a>
                    </div>

                    <div class="text-brand">
                        <h4>Casio MTP thanh lịch</h4>
                    </div>
                </div>

                <div class="brand">
                    <div class="container-img-brand">
                        <a href="" target="_blank" style="text-decoration: none">
                            <div class="img-brand">
                                <img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/small-web-banner-giong-rolex_1725589710.webp" width="232" height="99">
                            </div>
                        </a>
                    </div>

                    <div class="text-brand">
                        <h4>Giống Rolex</h4>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Collection Luxury -->
    <div class="collection-luxury">
        <div class="luxury-title">
            <h2>BỘ SƯU TẬP HÀNG LUXURY</h2>
        </div>

        <div class="luxury-gallary">
            <a href="#"> <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/fc-luxury-banner_1711707751.webp" width="400" height="230"></a>
            <a href="#"> <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/omega-luxury-banner_1711707171.webp" width="400" height="230"></a>
            <a href="#"> <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/lg-giam-34-banner_1711707950.webp" width="400" height="230"></a>
        </div>

        <div class="luxury-cards">
            <div class="luxury-banner">
                <a href="#"> <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/banner-dong-ho-cao-cap_1714020205.webp" width="285" height="350"></a>
            </div>

            <!-- Additional required wrapper -->
            <div class="card-wrapper swiper">
                <ul class="ul-luxury-cards swiper-wrapper">
                    <li class="luxury-card swiper-slide">
                        <div class="Product">
                            <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                                <i class="fa-regular fa-heart"></i>
                            </button>
                            <a href="TrangChiTietSanPham.html"><img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/longines-l28215577-768x768.jpg" alt="" class="luxury-card-img"></a>
                            <br />
                            <a href="TrangChiTietSanPham.html"><p class="Item">Đồng Hồ Longines 40mm Nam L2.821.5.57.7</p></a>
                            <p class="PriceOfPoduct">52.500.000₫</p>
                            <div class="Discount-row">
                                <p class="Discount">104.000.000₫</p>
                                <p class="DiscountPercent">-50%</p>
                            </div>
                            <p class="Sold">Đã bán 3</p>
                        </div>
                    </li>

                    <li class="luxury-card swiper-slide">
                        <div class="Product">
                            <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                                <i class="fa-regular fa-heart"></i>
                            </button>
                            <a href="TrangChiTietSanPham.html"><img src="https://cdn.watchstore.vn/wp-content/uploads/2023/03/52-1679281029743-1712661790-768x768.jpg" alt=""></a>
                            <br />
                            <a href="TrangChiTietSanPham.html"><p class="Item">Đồng Hồ Omega 42mm Nam 310.63.42.50.10.001</p></a>
                            <p class="PriceOfPoduct">585.000.000₫</p>
                            <div class="Discount-row">
                                <p class="Discount">800.000.000₫</p>
                                <p class="DiscountPercent">-27%</p>
                            </div>
                            <p class="Sold">Đã bán 1</p>
                        </div>
                    </li>

                    <li class="luxury-card swiper-slide">
                        <div class="Product">
                            <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                                <i class="fa-regular fa-heart"></i>
                            </button>
                            <a href="TrangChiTietSanPham.html"><img src="https://cdn.watchstore.vn/wp-content/uploads/2022/08/231-55-39-21-55-001-1-1667272275263-1712587457-768x768.jpg" alt=""></a>
                            <br />
                            <a href="TrangChiTietSanPham.html"><p class="Item">Đồng Hồ Omega 38.5mm Nam 231.55.39.21.55.001</p></a>
                            <p class="PriceOfPoduct">439.000.000₫</p>
                            <div class="Discount-row">
                                <p class="Discount">560.000.000₫</p>
                                <p class="DiscountPercent">-22%</p>
                            </div>
                            <p class="Sold">Đã bán 1</p>
                        </div>
                    </li>

                    <li class="luxury-card swiper-slide">
                        <div class="Product">
                            <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                                <i class="fa-regular fa-heart"></i>
                            </button>
                            <a href="TrangChiTietSanPham.html"><img src="https://cdn.watchstore.vn/wp-content/uploads/2025/06/longines-37mm-nam-l48105577-768x768.jpg" alt=""></a>
                            <br />
                            <a href="TrangChiTietSanPham.html"><p class="Item">Đồng Hồ Longines 37mm Nam L4.810.5.57.7</p></a>
                            <p class="PriceOfPoduct">44.590.000₫</p>
                            <div class="Discount-row">
                                <p class="Discount">70.000.000₫</p>
                                <p class="DiscountPercent">-36%</p>
                            </div>
                            <p class="Sold">Đã bán 4</p>
                        </div>
                    </li>

                    <li class="luxury-card swiper-slide">
                        <div class="Product">
                            <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                                <i class="fa-regular fa-heart"></i>
                            </button>
                            <a href="TrangChiTietSanPham.html"><img src="https://cdn.watchstore.vn/wp-content/uploads/2023/05/42420372002001-1-1563018140-1310878340-1712663740-768x768.jpg" alt=""></a>
                            <br />
                            <a href="TrangChiTietSanPham.html"><p class="Item">Đồng Hồ Omega 36.8mm Nam 424.20.37.20.02.001</p></a>
                            <p class="PriceOfPoduct">108.000.000₫</p>
                            <div class="Discount-row">
                                <p class="Discount">260.000.000₫</p>
                                <p class="DiscountPercent">-58%</p>
                            </div>
                            <p class="Sold">Đã bán 1</p>
                        </div>
                    </li>

                    <li class="luxury-card swiper-slide">
                        <div class="Product">
                            <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                                <i class="fa-regular fa-heart"></i>
                            </button>
                            <a href="TrangChiTietSanPham.html"><img src="https://cdn.watchstore.vn/wp-content/uploads/2022/11/l2-401448266-1773899263-1712588988-768x768.jpg" alt=""></a>
                            <br />
                            <a href="TrangChiTietSanPham.html"><p class="Item">Đồng Hồ Longines 38.5mm Nam L2.628.8.77.3</p></a>
                            <p class="PriceOfPoduct">92.000.000₫</p>
                            <div class="Discount-row">
                                <p class="Discount">135.000.000₫</p>
                                <p class="DiscountPercent">-32%</p>
                            </div>
                            <p class="Sold">Đã bán 1</p>
                        </div>
                    </li>

                    <li class="luxury-card swiper-slide">
                        <div class="Product">
                            <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                                <i class="fa-regular fa-heart"></i>
                            </button>
                            <a href="TrangChiTietSanPham.html"><img src="https://cdn.watchstore.vn/wp-content/uploads/2021/12/fc-335mc4p4-1-1655105726596-1712579410-768x768.jpg" alt=""></a>
                            <br />
                            <a href="TrangChiTietSanPham.html"><p class="Item">Đồng Hồ Frederique Constant 40mm Nam FC-335MC4P4</p></a>
                            <p class="PriceOfPoduct">72.162.000₫</p>
                            <div class="Discount-row">
                                <p class="Discount">80.180.000₫</p>
                                <p class="DiscountPercent">-10%</p>
                            </div>
                            <p class="Sold">Đã bán 1</p>
                        </div>
                    </li>

                    <li class="luxury-card swiper-slide">
                        <div class="Product">
                            <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                                <i class="fa-regular fa-heart"></i>
                            </button>
                            <a href="TrangChiTietSanPham.html"><img src="https://cdn.watchstore.vn/wp-content/uploads/2022/01/l3-1637794812-873274979-1712579709-768x768.jpg" alt=""></a>
                            <br />
                            <a href="TrangChiTietSanPham.html"><p class="Item">Đồng Hồ Longines 41mm Nam L3.742.4.96.6</p></a>
                            <p class="PriceOfPoduct">40.050.000₫</p>
                            <div class="Discount-row">
                                <p class="Discount">44.500.000₫</p>
                                <p class="DiscountPercent">-10%</p>
                            </div>
                            <p class="Sold">Đã bán 3</p>
                        </div>
                    </li>
                </ul>

                <!-- Pagination -->
                <div class="swiper-pagination"></div>

                <!-- Navigation buttons -->
                <div class="swiper-slide-button swiper-button-prev"></div>
                <div class="swiper-slide-button swiper-button-next"></div>
            </div>
        </div>
    </div>

    <!-- Vu -->
    <div>
        <p class="ThuongHieu">Thương hiệu nổi bật</p>
    </div>
    <div class="CamKet">
        <p>VPP.vn Cam kết chính hãng 100%, bồi thường 20 lần nếu phát hiện hàng giả</p>
    </div>

    <div class="logo-container">
        <a href="" class="logo-brand"><div class="item-Casio"><img src="https://cdn.casio-vietnam.vn/wp-content/uploads/2024/11/logo_casio_g_store.png" alt=""></div></a>
        <a href="" class="logo-brand"><div class="item-Orient"><img src="https://1000logos.net/wp-content/uploads/2018/10/Orient-Logo.png" alt=""></div></a>
        <a href="" class="logo-brand"><div class="item-Citizen"><img src="https://thietkelogo.mondial.vn/wp-content/uploads/2024/01/MAU_THIET_KE_LOGO_THUONG_HIEU_CITIZEN_1.jpg" alt=""></div></a>
        <a href="" class="logo-brand"><div class="item-Longines"><img src="https://i.pinimg.com/originals/e0/ce/07/e0ce0771f4e6c58203eeb6a638375500.png" alt=""></div></a>
        <a href="" class="logo-brand"><div class="item-Bentley"><img src="https://donghochinhhangsmile.com/wp-content/uploads/2023/04/logo-dong-ho-bentley.png" alt=""></div></a>
        <a href="" class="logo-brand"><div class="item-SR"><img src="https://www.watchstore.vn/wp-content/uploads/2025/06/dong-ho-srwatch-cua-nuoc-nao-1-1650531691689.jpg" alt=""></div></a>
        <a href="" class="logo-brand"><div class="item-Seiko"><img src="https://thietkelogo.mondial.vn/wp-content/uploads/2024/01/Seiko-Logo.jpg" alt=""></div></a>
        <a href="" class="logo-brand"><div class="item-Omega"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTC6W1731EzorghFc3xS1iz1mptUitE1X1dUg&s" alt=""></div></a>
        <a href="" class="logo-brand"><div class="item-Hublot"><img src="https://greeninnovation.com.vn/wp-content/uploads/2023/06/Hublot-Logo.png" alt=""></div></a>
        <a href="" class="logo-brand"><div class="item-Tissot"><img src="https://brandpalettes.com/wp-content/uploads/2023/06/Tissot-logo.png" alt=""></div></a>
        <a href="" class="logo-brand"><div class="item-G-shock"><img src="https://dongho.timemart.vn/wp-content/uploads/2017/07/casio-logo.png" alt=""></div></a>
        <a href="" class="logo-brand"><div class="item-Olym"><img src="https://cdn.vuanhwatch.com/media/products/22104/content/olym-pianus-png-1663989235-24092022101355.png" alt=""></div></a>
    </div>

    <div class="BST">
        <p>BỘ SƯU TẬP CHO MÙA HÈ</p>
    </div>


    <div class="button-bst-container">
        <button id="tab-featured" class="active">Nổi bật</button> <!-- đặt tab nổi bật làm mặc định -->
        <button id="tab-men">Đồng hồ nam</button>
        <button id="tab-women">Đồng hồ nữ</button>
    </div>

    <div class="Product-list-container">
        <!-- Tab đồng hồ nổi bật -->
        <div id="content-featured" class="tab-content">
            <div id="Page1" class="Product-page">
                <c:forEach items="${listP}" var="p">
                    <div class="link-product">
                        <div class="Product">
                            <button class="wishlist-icon"><i class="fa-regular fa-heart"></i></button>

                            <a href="detail?pid=${p.id}" class="img-product">
                                <img src="${p.imageUrl}" alt="${p.name}" onerror="this.src='https://via.placeholder.com/300'">
                            </a>
                            <br />

                            <a href="detail?pid=${p.id}">
                                <p class="Item" style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">${p.name}</p>
                            </a>

                            <p class="PriceOfPoduct">
                                <fmt:formatNumber value="${p.currentPrice}" type="currency" currencySymbol="₫" maxFractionDigits="0"/>
                            </p>

                            <div class="Discount-row">
                                <p class="Discount">
                                    <fmt:formatNumber value="${p.originalPrice}" type="currency" currencySymbol="₫" maxFractionDigits="0"/>
                                </p>
                                <p class="DiscountPercent">-30%</p>
                            </div>

                            <p class="Sold" style="font-size: 12px; color: #666;">Đã bán: ${p.soldQuantity}</p>

                            <a href="add-to-cart?pid=${p.id}" class="button" style="text-align: center; margin-top: 5px; display:block;">Mua ngay</a>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <div id="Page2" class="Product-page hidden">
                <div class="link-product">
                    <div class="Product">
                        <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                            <i class="fa-regular fa-heart"></i>
                        </button>
                        <a href="TrangChiTietSanPham.html" class="img-product"><img src="https://www.watchstore.vn/wp-content/uploads/2023/11/bg5605-a2-1-322274342-559280603-1712669076-400x400.jpg" alt=""></a>
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
                        <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                            <i class="fa-regular fa-heart"></i>
                        </button>
                        <a href="TrangChiTietSanPham.html" class="img-product"><img src="https://www.watchstore.vn/wp-content/uploads/2023/10/8113g-vt-dcs-t-1-213290406-1626795257-1712667500-400x400.jpg" alt=""></a>
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
                        <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                            <i class="fa-regular fa-heart"></i>
                        </button>
                        <a href="TrangChiTietSanPham.html" class="img-product"><img src="https://www.watchstore.vn/wp-content/uploads/2025/06/z6676116817384_61de97491cbb4ca1c7731896b9c800cc_1749192353-400x445.jpg" alt=""></a>
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
                        <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                            <i class="fa-regular fa-heart"></i>
                        </button>
                        <a href="TrangChiTietSanPham.html" class="img-product"><img src="https://www.watchstore.vn/wp-content/uploads/2024/06/8131g-ch-n-1_1724295646-400x400.jpg" alt=""></a>
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
                <div class="link-product">
                    <div class="Product">
                        <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                            <i class="fa-regular fa-heart"></i>
                        </button>
                        <a href="TrangChiTietSanPham.html" class="img-product"><img src="https://www.watchstore.vn/wp-content/uploads/2020/09/123aaa-1712554045-400x400.jpg" alt=""></a>
                        <br />
                        <a href="TrangChiTietSanPham.html"><p class="Item">Orient 40.8mm Nam RA-AR0001S30B (RA-AR0001S10B)</p></a>
                        <p class="PriceOfPoduct">10.408.000₫</p>
                        <div class="Discount-row">
                            <p class="Discount">13.010.000₫</p>
                            <p class="DiscountPercent">-20%</p>
                        </div>

                        <p class="Sold">Đã bán 253</p>
                    </div>
                </div>
                <div class="link-product">
                    <div class="Product">
                        <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                            <i class="fa-regular fa-heart"></i>
                        </button>
                        <a href="TrangChiTietSanPham.html" class="img-product"><img src="https://www.watchstore.vn/wp-content/uploads/2020/09/ra-ar0005y10b-1712554051-400x400.jpg" alt=""></a>
                        <br />
                        <a href="TrangChiTietSanPham.html"><p class="Item">Orient 40.8mm Nam RA-AR0005Y30B (RA-AR0005Y10B)</p></a>
                        <p class="PriceOfPoduct">8.008.000₫</p>
                        <div class="Discount-row">
                            <p class="Discount">10.010.000₫</p>
                            <p class="DiscountPercent">-20%</p>
                        </div>

                        <p class="Sold">Đã bán 236</p>
                    </div>
                </div>
                <div class="link-product">
                    <div class="Product">
                        <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                            <i class="fa-regular fa-heart"></i>
                        </button>
                        <a href="TrangChiTietSanPham.html" class="img-product"><img src="https://www.watchstore.vn/wp-content/uploads/2025/06/tissot-nu-t050-207-37-017-04-400x400.jpg" alt=""></a>
                        <br />
                        <a href="TrangChiTietSanPham.html"><p class="Item">Tissot 35mm Nữ T050.207.37.017.04</p></a>
                        <p class="PriceOfPoduct">14.800.000₫</p>
                        <div class="Discount-row">
                            <p class="Discount">22.600.000₫</p>
                            <p class="DiscountPercent">-35%</p>
                        </div>

                        <p class="Sold">Đã bán 126</p>
                    </div>
                </div>
                <div class="link-product">
                    <div class="Product">
                        <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                            <i class="fa-regular fa-heart"></i>
                        </button>
                        <a href="TrangChiTietSanPham.html" class="img-product"><img src="https://www.watchstore.vn/wp-content/uploads/2024/06/8131g-ch-n-1_1724295646-400x400.jpg" alt=""></a>
                        <br />
                        <a href="TrangChiTietSanPham.html"><p class="Item">Tissot 41mm Nam T086.408.22.036.00</p></a>
                        <p class="PriceOfPoduct">17.800.000₫</p>
                        <div class="Discount-row">
                            <p class="Discount">19.000.000₫</p>
                            <p class="DiscountPercent">-6%</p>
                        </div>

                        <p class="Sold">Đã bán 159</p>
                    </div>
                </div>
            </div>

            <div class="ViewMore-Container">
                <button id="view-more-btn" class="ViewMore-Button">Xem thêm sản phẩm</button>
            </div>

        </div>
        <!-- Tab đồng hồ nam -->
        <div id="content-men" class="tab-content hidden">
            <!-- đặt tab nam bị ẩn -->
            <div class="Product-page">
                <div class="link-product">
                    <div class="Product">
                        <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                            <i class="fa-regular fa-heart"></i>
                        </button>
                        <a href="TrangChiTietSanPham.html" class="img-product"><img src="https://www.watchstore.vn/wp-content/uploads/2025/06/carnival-8907g-vt-tf-400x400.jpg" alt=""></a>
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
                        <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                            <i class="fa-regular fa-heart"></i>
                        </button>
                        <a href="TrangChiTietSanPham.html" class="img-product"><img src="https://www.watchstore.vn/wp-content/uploads/2024/06/8131g-ch-n-1_1724295646-400x400.jpg" alt=""></a>
                        <br />
                        <a href="TrangChiTietSanPham.html"><p class="Item">Tissot 41mm Nam T086.408.22.036.00</p></a>
                        <p class="PriceOfPoduct">17.800.000₫</p>
                        <div class="Discount-row">
                            <p class="Discount">19.000.000₫</p>
                            <p class="DiscountPercent">-6%</p>
                        </div>

                        <p class="Sold">Đã bán 159</p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Tab đồng hồ nữ -->
        <div id="content-women" class="tab-content hidden">
            <!-- đặt tab nữ bị ẩn -->
            <div class="Product-page">
                <div class="link-product">
                    <div class="Product">
                        <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                            <i class="fa-regular fa-heart"></i>
                        </button>
                        <a href="TrangChiTietSanPham.html" class="img-product"><img src="https://www.watchstore.vn/wp-content/uploads/2020/09/123aaa-1712554045-400x400.jpg" alt=""></a>
                        <br />
                        <a href="TrangChiTietSanPham.html"><p class="Item">Orient 40.8mm Nam RA-AR0001S30B (RA-AR0001S10B)</p></a>
                        <p class="PriceOfPoduct">10.408.000₫</p>
                        <div class="Discount-row">
                            <p class="Discount">13.010.000₫</p>
                            <p class="DiscountPercent">-20%</p>
                        </div>

                        <p class="Sold">Đã bán 253</p>
                    </div>
                </div>

                <div class="link-product">
                    <div class="Product">
                        <button class="wishlist-icon" aria-label="Thêm vào danh sách yêu thích">
                            <i class="fa-regular fa-heart"></i>
                        </button>
                        <a href="TrangChiTietSanPham.html" class="img-product"><img src="https://www.watchstore.vn/wp-content/uploads/2020/11/1-khung-sp-6676612-1785849039-1712554705-400x400.jpg" alt=""></a>
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
            </div>
        </div>

    </div>



    <section class="InformationStore">
        <div class="History-Brand">
            <div class="Picture-Brand">
                <img src="https://www.watchstore.vn/wp-content/uploads/2025/06/gioithieu-home-desktop_1711705731.webp" alt="">
            </div>
            <div class="Introduce-Brand">
                <p class="LogoStore">VVP</p>
                <p class="ReputationBrand">Cửa hàng đồng hồ đeo tay chính hãng</p>
                <p class="History1">Là chuỗi cửa hàng chuyên bán đồng hồ chính hãng, VVP.VN đã đồng hành cùng khách hàng hơn 4 năm kể từ ngày thành lập vào năm 2020. Chúng tôi tự hào là đại lý ủy quyền của nhiều thương hiệu đồng hồ Thụy Sĩ và Nhật Bản hàng đầu.</p>
                <p class="History2">Chúng tôi cam kết 100% sản phẩm là chính hãng và áp dụng Chính sách Bảo hành lên đến 5 năm để đảm bảo sự an tâm tuyệt đối. Đội ngũ VVP.VN luôn sẵn lòng hỗ trợ với kiến thức chuyên sâu, mang đến trải nghiệm mua sắm đẳng cấp và đáng tin cậy.</p>
                <p class="History3">Hãy để VVP.VN hoàn thiện phong cách của bạn với chiếc đồng hồ chất lượng nhất!</p>
                </p>
            </div>
        </div>
        <div class="btn-timhieuthem">
            <a href="introduce.html">Tìm hiểu thêm</a>
        </div>
    </section>


    <!-- Vy -->
    <!-- Vy -->
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


    <!-- Nút lhtv -->
    <div class="introduce-section container-button-lhtv">
        <div class="button-introduce" style="text-align:center">
            <a href="contact.html" class="button button-lhtv" style="border-radius:7px;">
                <span style="color: #fff">LIÊN HỆ TƯ VẤN</span>
            </a>
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

    <!-- Linking SwiperJS Script -->
    <script src="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.js"></script>
    <script src="assets/js/index.js"></script>
    <script src="assets/js/ProductCards.js"></script>
</body>
</html>
