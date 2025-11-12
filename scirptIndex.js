/* phan script cua Phat -- > */

///* --- TỰ ĐỘNG TẢI HEADER VÀ FOOTER --- */
//// 1. Tạo một hàm để tải HTML từ một file bên ngoài
//function loadHTML(filePath, elementId) {
//    fetch(filePath)
//        .then(response => {
//            if (!response.ok) {
//                throw new Error("Network response was not ok");
//            }
//            return response.text(); // Lấy nội dung HTML dạng text
//        })
//        .then(html => {
//            // "Nhét" nội dung HTML vào đúng cái "chỗ" (placeholder)
//            document.getElementById(elementId).innerHTML = html;
//        })
//        .catch(error => {
//            console.error(`Error loading ${filePath}:`, error);
//            // Thông báo lỗi nếu không tải được file
//            document.getElementById(elementId).innerHTML = `<p style="color:red;">Failed to load ${filePath}.</p>`;
//        });
//}

//// 2. Chờ cho trang web tải xong...
//document.addEventListener("DOMContentLoaded", function () {
//    // ...rồi gọi hàm để tải header và footer vào đúng "chỗ" của chúng
//    loadHTML("header.html", "header-placeholder");
//    loadHTML("footer.html", "footer-placeholder");
//});


// Slideshow container
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

