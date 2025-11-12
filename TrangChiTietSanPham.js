// Chờ cho toàn bộ HTML được tải
document.addEventListener('DOMContentLoaded', function() {
    // 1. Lấy ra các phần tử
    const mainImage = document.getElementById('mainImage');
    const thumbnailList = document.querySelector('.Thumbnail-list');
    const scrollLeftBtn = document.getElementById('scrollLeft');
    const scrollRightBtn = document.getElementById('scrollRight');
    const thumbnails = document.querySelectorAll('.thumbnail');
    
    // Độ rộng cần cuộn (khoảng 2 ảnh + gap)
    const scrollAmount = 140; 
    
    // --- 1. Xử lý Chuyển đổi Ảnh Lớn ---
    thumbnails.forEach(thumbnail => {
        thumbnail.addEventListener('click', function() {
            const newSrc = this.getAttribute('data-full-src');
            mainImage.src = newSrc;
            
            // Xóa/Thêm trạng thái active
            thumbnails.forEach(t => t.classList.remove('active'));
            this.classList.add('active');
        });
    });
    
    // --- 2. Xử lý Nút Lướt Ngang ---
    
    // Hàm cuộn với animation
    function scrollThumbnails(direction) {
        if (direction === 'left') {
            thumbnailList.scrollBy({
                left: -scrollAmount,
                behavior: 'smooth'
            });
        } else if (direction === 'right') {
            thumbnailList.scrollBy({
                left: scrollAmount,
                behavior: 'smooth'
            });
        }
    }

    // Gán sự kiện cho nút
    scrollLeftBtn.addEventListener('click', () => scrollThumbnails('left'));
    scrollRightBtn.addEventListener('click', () => scrollThumbnails('right'));
});