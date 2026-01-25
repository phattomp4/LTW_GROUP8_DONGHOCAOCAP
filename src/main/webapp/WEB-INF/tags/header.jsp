<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<style>
    /* Container của avatar */
    .profile-dropdown {
        position: relative;
        display: inline-block;
    }

    /* Nút Avatar */
    .profile-avatar-btn {
        background: none;
        border: none;
        cursor: pointer;
        padding: 0;
        display: flex;
        align-items: center;
    }

    .profile-avatar-btn img {
        width: 35px;
        height: 35px;
        border-radius: 50%;
        object-fit: cover;
        border: 2px solid #ddd;
        transition: 0.2s;
    }

    .profile-avatar-btn:hover img {
        border-color: #1b6e76;
    }

    /* Menu Dropdown (Mặc định ẩn) */
    .dropdown-menu {
        display: none; /* Quan trọng: Ẩn đi */
        position: absolute;
        right: 0;
        top: 120%; /* Cách nút một chút */
        background-color: white;
        min-width: 220px;
        box-shadow: 0px 4px 15px rgba(0,0,0,0.15);
        z-index: 99999; /* Số lớn để luôn nổi lên trên */
        border-radius: 8px;
        border: 1px solid #eee;
        animation: fadeIn 0.2s;
    }

    /* Class này sẽ được JS thêm vào để hiện menu */
    .dropdown-menu.show {
        display: block;
    }

    /* Style bên trong menu */
    .menu-header {
        padding: 15px;
        border-bottom: 1px solid #f0f0f0;
        background-color: #fafafa;
        font-size: 14px;
        color: #333;
        border-radius: 8px 8px 0 0;
    }

    .dropdown-menu a {
        color: #333;
        padding: 12px 16px;
        text-decoration: none;
        display: flex;
        align-items: center;
        gap: 10px;
        font-size: 14px;
        transition: 0.2s;
    }

    .dropdown-menu a i {
        width: 20px;
        text-align: center;
        color: #777;
    }

    .dropdown-menu a:hover {
        background-color: #f5f5f5;
        color: #1b6e76;
    }

    .dropdown-menu .divider {
        height: 1px;
        background-color: #eee;
        margin: 4px 0;
    }

    @keyframes fadeIn {
        from {opacity: 0; transform: translateY(10px);}
        to {opacity: 1; transform: translateY(0);}
    }
</style>
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

                    <form action="${pageContext.request.contextPath}/category" method="GET" class="search-form">
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
                        <a href="${pageContext.request.contextPath}/login.jsp" class="button button-login">
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

                        <c:choose>

                            <%-- TRƯỜNG HỢP 1: LÀ ADMIN --%>
                            <c:when test="${sessionScope.acc.role == 'Admin'}">
                                <a href="${pageContext.request.contextPath}/admin/dashboard" style="color: #d0011b; font-weight: bold; background-color: #fff5f5;">
                                    <i class="fa-solid fa-screwdriver-wrench"></i> Trang Quản Trị
                                </a>
                            </c:when>

                            <%-- TRƯỜNG HỢP 2: LÀ USER THƯỜNG (Hoặc khác Admin) --%>
                            <c:otherwise>
                                <a href="${pageContext.request.contextPath}/profile">
                                    <i class="fa-regular fa-user"></i> Hồ sơ cá nhân
                                </a>

                                <a href="${pageContext.request.contextPath}/order-history" class="btn-history">
                                    <i class="fa-solid fa-clock-rotate-left"></i> Lịch sử đơn hàng
                                </a>
                            </c:otherwise>

                        </c:choose>

                        <div class="divider"></div>

                        <a href="${pageContext.request.contextPath}/logout" style="color: #d0011b;">
                            <i class="fa-solid fa-right-from-bracket"></i> Đăng xuất
                        </a>
                    </div>
                </div>
            </c:if>
            </li>
        </ul>
    </div>

    <script>
        function toggleProfileMenu(event) {
            // Ngăn sự kiện click lan ra ngoài (giúp menu không bị đóng ngay lập tức)
            event.stopPropagation();

            var menu = document.getElementById("profile-menu");
            if (menu) {
                menu.classList.toggle("show");
            }
        }

        // Sự kiện click bất kỳ đâu trên màn hình để đóng menu
        window.onclick = function(event) {
            if (!event.target.closest('.profile-avatar-btn')) {
                var dropdowns = document.getElementsByClassName("dropdown-menu");
                for (var i = 0; i < dropdowns.length; i++) {
                    var openDropdown = dropdowns[i];
                    if (openDropdown.classList.contains('show')) {
                        openDropdown.classList.remove('show');
                    }
                }
            }
        }
    </script>
</header>