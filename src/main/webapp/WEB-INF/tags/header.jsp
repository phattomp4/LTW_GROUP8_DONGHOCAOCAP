<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<header class="main-header">

    <!--Logo-->
    <div class="logo-container-header">
        <a href="${pageContext.request.contextPath}/home" class="logo-header"> <h1 class="logo-text" style="font-weight: 900; font-size: 35px;">VVP</h1>
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
                                <li><a href="category?type=search&keyword=Rolex">Giống Rolex, Hublot</a></li>
                                <li><a href="DongHo.html">Giống Patek, Richard</a></li>
                                <li><a href="category?type=price&min=0&max=1000000">Giá dưới 1 triệu</a></li>
                                <li><a href="category?type=price&min=1000000&max=3000000">Giá từ 1 - 3 triệu</a></li>
                                <li><a href="DongHo.html">Giá từ 3 - 6 triệu</a></li>
                                <li><a href="DongHo.html">Giá từ 6 - 9 triệu</a></li>
                                <li><a href="DongHo.html">Giá từ 9 - 15 triệu</a></li>
                                <li><a href="category?type=price&min=15000000&max=-1">Giá trên 15 triệu</a></li>
                            </ul>
                        </div>
                        <div class="megamenu-column">
                            <ul>
                                <li><a href="category?type=search&keyword=Casio">Casio, G-Shock</a></li>
                                <li><a href="DongHo.html">Olym Pianus</a></li>
                                <li><a href="DongHo.html">Bentley</a></li>
                                <li><a href="DongHo.html">Carnival, I&W Carnival</a></li>
                                <li><a href="category?type=search&keyword=Orient">Orient</a></li>
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
                                <li><a href="category?type=search&keyword=Automatic">Đồng hồ cơ/automatic</a></li>
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
            <li>
                <div class="search-bar" style="position: relative;">

                    <form action="category" method="GET" class="search-form">
                        <input type="hidden" name="type" value="search">

                        <input type="text" name="keyword"
                               oninput="searchByName(this)"
                               placeholder="Tìm kiếm..." required autocomplete="off">

                        <button type="submit" class="search-button">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </button>
                    </form>

                    <div id="search-results" class="search-results-box">
                    </div>

                </div>
            </li>

            <li>
                <div class="header-action-item">
                    <a href="${pageContext.request.contextPath}/cart" style="position: relative; text-decoration: none; color: inherit;">
                        <i class="fa-solid fa-cart-shopping" style="font-size: 20px;"></i>

                        <span class="cart-count" id="cartCountHeader" style="position: absolute; top: -8px; right: -8px; background: #d0011b; color: white; font-size: 11px; font-weight: bold; padding: 2px 6px; border-radius: 50%;">
                            ${sessionScope.cartCount != null ? sessionScope.cartCount : 0}
                        </span>
                    </a>
                </div>
            </li>

            <li>
                <c:if test="${sessionScope.acc == null}">
                    <div class="container-button-login" style="text-align:center">
                        <a href="login.jsp" class="button button-login">
                            <span style="color: #fff">Đăng nhập</span>
                        </a>
                    </div>
                </c:if>

                <c:if test="${sessionScope.acc != null}">
                    <div class="profile-dropdown">
                        <button id="profile-btn" class="profile-avatar-btn">
                            <img src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt="Avatar">
                        </button>

                        <div id="profile-menu" class="dropdown-menu">
                            <div class="menu-header">
                                Xin chào, <br>
                                <b style="color: #1b6e76;">${sessionScope.acc.username}</b>
                            </div>

                            <a href="${pageContext.request.contextPath}/profile"><i class="fa-regular fa-user"></i> Hồ sơ cá nhân</a>
                            <a href="order-history"><i class="fa-solid fa-clock-rotate-left"></i> Lịch sử đơn hàng</a>

                            <div class="divider"></div>

                            <a href="logout" style="color: #d0011b;">
                                <i class="fa-solid fa-right-from-bracket"></i> Đăng xuất
                            </a>
                        </div>
                    </div>
                </c:if>
            </li>
        </ul>
    </div>
</header>