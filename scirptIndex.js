/* phan script cua Phat -- > */
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
    if (n > slides.length) {slideIndex = 1}
    if (n < 1) {slideIndex = slides.length}
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";
    dots[slideIndex-1].className += " active";
}

// SwiperJS
new Swiper('.card-wrapper', {
    loop: true,
    spaceBetween: 30,

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
    breakpoint: {
        0: {
            slidesPerView: 1,
        },
        768: {
            slidesPerView: 2,
        },
        1024: {
            slidesPerView: 3,
        },
    }
});


/* phan script cua Vu */
        const page2 = document.getElementById('Page2');
        const viewMoreBtn = document.getElementById('view-more-btn');

        viewMoreBtn.addEventListener('click', () => {
            if (page2.classList.contains('hidden')) {
            // Hiện Page2
            page2.classList.remove('hidden');
        viewMoreBtn.textContent = 'Thu gọn';
            } else {
            // Ẩn Page2
            page2.classList.add('hidden');
        viewMoreBtn.textContent = 'Xem thêm sản phẩm';
        // (Tùy chọn: Cuộn lên đầu Page1 sau khi thu gọn)
        window.scrollTo({
            top: document.querySelector('.Outstanding-clocks').offsetTop - 20,
        behavior: 'smooth'
                });
            }
        });


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

