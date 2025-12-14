
    // 1. Lấy ra form bằng ID đã thêm
    const form = document.getElementById('thanhtoanForm');

    // 2. Lắng nghe sự kiện 'submit' của form (xảy ra khi nhấn nút type="submit")
    form.addEventListener('submit', function(event) {
        
        // Ngăn chặn hành vi gửi form mặc định của trình duyệt
        event.preventDefault(); 

        // Kiểm tra xem tất cả các trường required có hợp lệ không
        if (form.checkValidity()) {
            // 3. Hiển thị thông báo thành công
            alert('🎉 Đã đặt hàng thành công!');
            
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
