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


    /* Phan script của Phát */
// Hình trái tim trên Product Card 
document.addEventListener('DOMContentLoaded', function() {
    // Lấy tất cả các nút trái tim
    const wishlistButtons = document.querySelectorAll('.wishlist-icon');

    wishlistButtons.forEach(button => {
        button.addEventListener('click', function() {
            // Chuyển đổi class 'active'
            this.classList.toggle('active');

            // Chuyển đổi icon từ rỗng sang đặc và ngược lại
            const icon = this.querySelector('i');
            if (this.classList.contains('active')) {
                icon.classList.remove('fa-regular');
                icon.classList.add('fa-solid');
            } else {
                icon.classList.remove('fa-solid');
                icon.classList.add('fa-regular');
            }
            console.log('Trạng thái yêu thích đã thay đổi.');
        });
    });
});