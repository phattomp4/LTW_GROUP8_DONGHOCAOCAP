<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<link rel="stylesheet" href="assets/css/index.css">
<link rel="stylesheet" href="assets/css/ProductCards.css">
<link rel="stylesheet" href="assets/css/header.css">
<link rel="stylesheet" href="assets/css/footer.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@12/swiper-bundle.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<button id="btnScrollToTop" onclick="scrollToTop()">
    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
        <path d="M18 15l-6-6-6 6" />
    </svg>
</button>

<header class="main-header">
    <div class="logo-container-header">
        <a href="index.jsp" class="logo-header">
            <h1 class="logo-text" style="font-weight: 900; font-size: 35px;">VVP</h1>
        </a>
    </div>

    <div class="nav-item">
        <nav class="main-nav">
            <ul>
                <li class="nav-item-has-dropdown">
                    <a href="DongHo.jsp" class="link-yellow">Đồng hồ <i class="fa-solid fa-chevron-down"></i></a>
                    <div class="megamenu megamenu-dongho">
                        <div class="megamenu-column">
                            <ul>
                                <li><a href="#">Giống Rolex, Hublot</a></li>
                                <li><a href="#">Giống Patek, Richard</a></li>
                                <li><a href="#">Giá dưới 1 triệu</a></li>
                                <li><a href="#">Giá trên 15 triệu</a></li>
                            </ul>
                        </div>
                        <div class="megamenu-column">
                            <ul>
                                <li><a href="#">Casio, G-Shock</a></li>
                                <li><a href="#">Orient</a></li>
                                <li><a href="#">Seiko</a></li>
                                <li><a href="#">Tissot</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
                <li><a href="DongHo.jsp">Nam</a></li>
                <li><a href="DongHo.jsp">Nữ</a></li>
                <li class="nav-item-has-dropdown">
                    <a href="PhuKien.jsp">Phụ kiện <i class="fa-solid fa-chevron-down"></i></a>
                    <div class="megamenu megamenu-phukien">
                        <div class="megamenu-column-phukien">
                            <ul>
                                <li><a href="PhuKien.jsp">Dây đồng hồ</a></li>
                                <li><a href="PhuKien.jsp">Hộp xoay đồng hồ</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
            </ul>
        </nav>
    </div>

    <div class="header-action">
        <ul class="ul-header-action">
            <li>
                <div class="search-bar">
                    <input type="text" placeholder="Tìm là thấy">
                    <i class="fa-solid fa-magnifying-glass search-icon"></i>
                </div>
            </li>
            <li>
                <a href="cart.jsp" class="action-icon cart-icon">
                    <i class="fa-solid fa-bag-shopping"></i>
                </a>
            </li>
            <li>
                <a href="wishlist.jsp" class="action-icon">
                    <i class="fa-regular fa-heart"></i>
                </a>
            </li>
            <li>
                <div class="container-button-login" style="text-align:center">
                    <a href="login.jsp" class="button button-login">
                        <c:choose>
                            <c:when test="${not empty sessionScope.user}">
                                <span style="color: red">${sessionScope.user.username}</span>
                            </c:when>
                            <c:otherwise>
                                <span style="color: #fff">Đăng nhập</span>
                            </c:otherwise>
                        </c:choose>
                    </a>
                </div>
            </li>
        </ul>
    </div>
</header>