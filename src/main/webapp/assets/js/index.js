/* phan script cua Phat -- > */

// --- BỌC CODE NÚT SCROLL TO TOP ---
// Lấy nút từ HTML
const btnScrollToTop = document.getElementById("btnScrollToTop");

// Lắng nghe sự kiện cuộn trang
window.onscroll = function () {
    scrollFunction();
};

function scrollFunction() {
    // Nếu cuộn xuống quá 200px thì hiện nút
    if (document.body.scrollTop > 200 || document.documentElement.scrollTop > 200) {
        btnScrollToTop.classList.add("show");
    } else {
        // Nếu ở trên đầu trang thì ẩn nút
        btnScrollToTop.classList.remove("show");
    }
}

// Hàm xử lý khi click vào nút
function scrollToTop() {
    window.scrollTo({
        top: 0,
        behavior: "smooth" // Quan trọng: tạo hiệu ứng trượt mượt mà
    });
}





// --- BỌC CODE SLIDESHOW ---
// Chỉ chạy code slideshow nếu các phần tử tồn tại
const dotsContainer = document.getElementsByClassName("dot");
if (dotsContainer.length > 0) {

    let slideIndex = 1;
    showSlides(slideIndex);

    // Next/previous controls
    function plusSlides(n) {
        showSlides(slideIndex += n);
    }

    // Thumbnail image controls
    function currentSlide(n) {
        showSlides(slideIndex = n);
    }

    function showSlides(n) {
        let i;
        let slides = document.getElementsByClassName("mySlides");
        let dots = document.getElementsByClassName("dot");
        if (n > slides.length) { slideIndex = 1 }
        if (n < 1) { slideIndex = slides.length }
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        slides[slideIndex - 1].style.display = "block";
        dots[slideIndex - 1].className += " active";
    }
}




// --- BỌC CODE SWIPERJS ---
// Chỉ chạy Swiper nếu phần tử tồn tại
if (document.querySelector('.card-wrapper')) {

    new Swiper('.card-wrapper', {
        loop: true,
        spaceBetween: 0,

        // Pagination bullets
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
            dynamicBullets: true,
        },

        // Navigation arrows
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },

        // Responsive breakpoints
        breakpoints: {
            0: {
                slidesPerView: 1,
            },
            690: {
                slidesPerView: 2,
            },
            900: {
                slidesPerView: 3,
            },
            950: {
                slidesPerView: 4,
            },
        }
    });
} // --- KẾT THÚC BỌC CODE SWIPERJS ---


// --- BỌC CODE NÚT PROFILE ---
// Chỉ chạy nếu tìm thấy nút và menu
const profileBtn = document.getElementById('profile-btn');
const profileMenu = document.getElementById('profile-menu');

if (profileBtn && profileMenu) {

    // 2. Thêm sự kiện 'click' cho nút avatar
    profileBtn.addEventListener('click', () => {
        // Bật/tắt lớp 'show' trên menu
        profileMenu.classList.toggle('show');
    });

    // 3. (Rất quan trọng) Đóng menu khi nhấp ra bên ngoài
    window.addEventListener('click', (event) => {
        // event.target là phần tử được nhấp

        // Kiểm tra xem người dùng có nhấp ra ngoài menu VÀ ngoài nút avatar không
        if (!profileMenu.contains(event.target) && !profileBtn.contains(event.target)) {
            // Nếu đúng, thì xóa lớp 'show' để ẩn menu đi
            profileMenu.classList.remove('show');
        }
    });
} // --- KẾT THÚC BỌC CODE NÚT PROFILE ---


/* === TAB SẢN PHẨM === */

// 1. Lấy tất cả các nút bấm tab
const tabFeatured = document.getElementById('tab-featured');
const tabMen = document.getElementById('tab-men');
const tabWomen = document.getElementById('tab-women');

// 2. Lấy tất cả các khối nội dung (content panels)
const contentFeatured = document.getElementById('content-featured');
const contentMen = document.getElementById('content-men');
const contentWomen = document.getElementById('content-women');

// 3. Gom các nút và nội dung vào mảng để dễ quản lý
const tabs = [tabFeatured, tabMen, tabWomen];
const contents = [contentFeatured, contentMen, contentWomen];

// 4. Hàm để xử lý khi click tab
function switchTab(clickedTab, contentToShow) {
    // 4a. Tắt 'active' trên tất cả các nút
    tabs.forEach(tab => {
        if (tab) tab.classList.remove('active');
    });

    // 4b. Ẩn tất cả các nội dung
    contents.forEach(content => {
        if (content) content.classList.add('hidden');
    });

    // 4c. Bật 'active' cho nút vừa bấm
    if (clickedTab) clickedTab.classList.add('active');

    // 4d. Hiện nội dung tương ứng
    if (contentToShow) contentToShow.classList.remove('hidden');
}

// 5. Gán sự kiện click cho từng nút
// (Thêm kiểm tra 'if' để tránh lỗi nếu không tìm thấy nút)
if (tabFeatured) {
    tabFeatured.addEventListener('click', () => {
        switchTab(tabFeatured, contentFeatured);
    });
}

if (tabMen) {
    tabMen.addEventListener('click', () => {
        switchTab(tabMen, contentMen);
    });
}

if (tabWomen) {
    tabWomen.addEventListener('click', () => {
        switchTab(tabWomen, contentWomen);
    });
}

/* === KẾT THÚC CODE MỚI CHO TAB SẢN PHẨM === */

/* phan script cua Vy */

/**
 * Chức năng cuộn chính xác từng hình ảnh trong container ngang.
 * Nó tính toán chiều rộng của hình ảnh cộng với margin để cuộn mượt mà sang ảnh tiếp theo.
 * @param {number} direction - Hướng cuộn: 1 cho phải (next), -1 cho trái (prev).
 */
let scrollSlider = (direction) => {
    // 1. Xác định Slider container
    // Sử dụng ID chính xác từ HTML của bạn
    const slider = document.getElementById("slide-list-img-new");

    if (!slider) {
        console.error("Slider element with ID slide-list-img-new not found.");
        return;
    }

    // 2. Tính toán bước cuộn chính xác
    // Lấy thẻ ảnh đầu tiên để tính toán kích thước bước cuộn
    const firstImage = slider.querySelector('.gallery-image');
    let scrollStep = 300; // Giá trị mặc định an toàn

    if (firstImage) {
        // Lấy chiều rộng hình ảnh thực tế
        const imageWidth = firstImage.offsetWidth;
        const style = window.getComputedStyle(firstImage);

        // Lấy margin-right (giá trị 15px trong CSS)
        const marginRight = parseFloat(style.marginRight) || 0;

        // Bước cuộn = Chiều rộng ảnh + Margin
        scrollStep = imageWidth + marginRight;
    }

    // 3. Thực hiện cuộn
    slider.scrollBy({
        left: direction * scrollStep,
        behavior: "smooth"
    });
};

// Gán hàm vào window để nó có thể được gọi từ onclick trong HTML
window.scrollSlider = scrollSlider;