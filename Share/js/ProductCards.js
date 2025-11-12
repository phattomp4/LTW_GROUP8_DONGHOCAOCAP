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
