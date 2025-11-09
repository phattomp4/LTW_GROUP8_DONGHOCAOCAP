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

