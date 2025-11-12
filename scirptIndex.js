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
let scrollAmount = 0;
const scrollStep = 300;

function scrollSlider(direction) {
    const slider = document.getElementById("slide-list-img");
    const maxScroll = slider.scrollWidth - slider.clientWidth;

    scrollAmount += direction * scrollStep;

    if (scrollAmount < 0) scrollAmount = 0;
    if (scrollAmount > maxScroll) scrollAmount = maxScroll;

    slider.scrollTo({
        left: scrollAmount,
        behavior: "smooth"
    });
}

