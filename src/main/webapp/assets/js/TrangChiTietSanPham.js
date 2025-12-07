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




// 1. Lấy ra form bằng ID đã thêm
const form = document.getElementById('them_gio_hang_form');

// 2. Lắng nghe sự kiện 'submit' của form (xảy ra khi nhấn nút type="submit")
form.addEventListener('submit', function (event) {

    // Ngăn chặn hành vi gửi form mặc định của trình duyệt
    event.preventDefault();

    // Kiểm tra xem tất cả các trường required có hợp lệ không
    if (form.checkValidity()) {
        // 3. Hiển thị thông báo thành công
        alert('🎉 Đã thêm vào giỏ hàng!');

        // Tùy chọn: Nếu muốn chuyển hướng sau thông báo, bỏ comment dòng này:
        // window.location.href = 'login.html'; 

        // Ở đây, vì chỉ là demo, ta không làm gì thêm sau alert.
        // Trong thực tế, bạn sẽ gửi dữ liệu đến server ở đây.

    } else {
        // Nếu form không hợp lệ, trình duyệt sẽ tự động hiển thị thông báo lỗi mặc định 
        // (ví dụ: "Vui lòng điền vào trường này.")
        // Tuy nhiên, ta cần gọi reportValidity để chắc chắn nó được hiển thị
        form.reportValidity();
    }
});