let slideIndex = 1;
showSlides(slideIndex);

// Khi bấm nút Next/Prev
function plusSlides(n) {
    showSlides(slideIndex += n);
}

// Hiển thị slide hiện tại
function showSlides(n) {
    const slides = document.getElementsByClassName("mySlides");
    if (n > slides.length) slideIndex = 1;
    if (n < 1) slideIndex = slides.length;
    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slides[slideIndex - 1].style.display = "block";
}

// Tự động đổi ảnh mỗi 4 giây
setInterval(() => plusSlides(1), 4000);
