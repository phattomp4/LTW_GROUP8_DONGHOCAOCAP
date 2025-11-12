
        // "DOMContentLoaded" là sự kiện xảy ra khi HTML đã tải xong.
    // Chúng ta bọc code trong này để đảm bảo JS không chạy
    // trước khi các phần tử HTML (nút, trang) tồn tại.
    document.addEventListener('DOMContentLoaded', function () {

            // --- 1. Lấy các phần tử cần tương tác ---

            // Lấy TẤT CẢ các link menu (trả về một danh sách/mảng)
            const navLinks = document.querySelectorAll('.nav-link');
    // Lấy TẤT CẢ các trang (trả về một danh sách/mảng)
    const pages = document.querySelectorAll('.page-content');

    // Lấy các nút bấm cụ thể bằng ID
    const btnAddProduct = document.getElementById('btn-add-product');
    const btnCancelProduct = document.getElementById('btn-cancel-product');

            // --- 2. Định nghĩa hàm dùng chung ---

            /**
             * Hàm "showPage" - Trái tim của hệ thống điều hướng.
             * Nhiệm vụ: Ẩn tất cả các trang, sau đó chỉ hiện trang
             * có ID được truyền vào.
             * @param {string} pageId - ID của trang cần hiển thị (ví dụ: 'page-products')
    */
    function showPage(pageId) {

        // --- A. Xử lý các trang (ẩn hết) ---
        // Dùng .forEach để lặp qua danh sách các trang
        pages.forEach(page => {
            // Xóa class "active" ở tất cả các trang
            page.classList.remove('active');
        });

                // --- B. Xử lý các link menu (bỏ highlight hết) ---
                navLinks.forEach(link => {
        link.classList.remove('active');
                });

    // --- C. Hiển thị trang được chọn ---
    const activePage = document.getElementById(pageId);
    if (activePage) { // Kiểm tra xem trang có tồn tại không
        activePage.classList.add('active'); // Thêm "active" (CSS sẽ làm nó hiện ra)
                }

    // --- D. Highlight link menu được chọn ---
    // Tìm link có thuộc tính data-page="[pageId]"
    const activeLink = document.querySelector(`.nav-link[data-page="${pageId}"]`);
    if (activeLink) {
        activeLink.classList.add('active');
    S
                }
            }

            // --- 3. Gắn các "Bộ lắng nghe sự kiện" (Event Listeners) ---

            // --- Sự kiện cho TẤT CẢ các link menu ---
            // Lặp qua từng link và gắn sự kiện "click"
            navLinks.forEach(link => {
        link.addEventListener('click', function (e) {
            // e.preventDefault(); // Ngăn hành vi mặc định của thẻ <a> (nếu nó có href="#")

            // Lấy giá trị của thuộc tính "data-page"
            const pageId = this.getAttribute('data-page');

            if (pageId) { // Chỉ chạy nếu link đó có data-page
                // Gọi hàm showPage với ID vừa lấy được
                showPage(pageId);
            }
        });
            });

    // --- Sự kiện cho nút "Thêm sản phẩm mới" ---
    if (btnAddProduct) { // Kiểm tra nút có tồn tại không
        btnAddProduct.addEventListener('click', function () {
            // Gọi hàm để chuyển sang trang "Thêm sản phẩm"
            showPage('page-add-product');

            // Đổi tiêu đề và xóa trắng form
            document.getElementById('form-title').innerText = 'Thêm sản phẩm mới';
            document.getElementById('product-form').reset(); // Xóa sạch dữ liệu form cũ
        });
            }

    // --- Sự kiện cho nút "Hủy" (trên form sản phẩm) ---
    if (btnCancelProduct) {
        btnCancelProduct.addEventListener('click', function () {
            // Quay lại trang danh sách sản phẩm
            showPage('page-products');
        });
            }

            // --- Sự kiện cho các nút "Sửa" sản phẩm ---
            // Chúng ta phải tìm TẤT CẢ các nút "Sửa" trên trang "Quản lý Sản phẩm"
            document.querySelectorAll('#page-products .btn-icon.edit').forEach(button => {
        button.addEventListener('click', function () {
            // 1. Chuyển sang trang form
            showPage('page-add-product');

            // 2. Đổi tiêu đề
            document.getElementById('form-title').innerText = 'Chỉnh sửa sản phẩm';

            // 3. (Giả lập) Điền dữ liệu vào form
            // Trong một ứng dụng thật, bạn sẽ lấy ID sản phẩm từ nút này,
            // gọi API để lấy dữ liệu, sau đó điền vào form.
            document.getElementById('product-name').value = 'Tên sản phẩm được sửa';
            document.getElementById('product-sku').value = 'SKU-EDIT';
            document.getElementById('product-price').value = 123456;
        });
            });

            // --- Sự kiện cho nút "Xóa" (Demo với alert) ---
            document.querySelectorAll('.btn-icon.delete').forEach(button => {
        button.addEventListener('click', function () {
            // Hỏi xác nhận trước khi xóa
            if (confirm('Bạn có chắc chắn muốn xóa mục này?')) {
                // Trong ứng dụng thật, bạn sẽ gọi API để xóa
                // Ở đây chúng ta chỉ thông báo
                alert('Đã gửi yêu cầu xóa! (Demo)');
                // (Bạn có thể làm cho hàng đó biến mất khỏi bảng)
                // this.closest('tr').remove();
            }
        });
            });

        }); // Kết thúc sự kiện DOMContentLoaded
