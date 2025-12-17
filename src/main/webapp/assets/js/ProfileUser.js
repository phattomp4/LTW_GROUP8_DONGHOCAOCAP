 // Hàm JavaScript để chuyển đổi Tab
        function openTab(evt, contentName) {
            let i, tabcontent, tablinks, titleElement;

            // 1. Ẩn tất cả nội dung tab
            tabcontent = document.getElementsByClassName("tabcontent");
            for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
            }

            // 2. Xóa class 'active' khỏi tất cả các nút tab
            tablinks = document.getElementsByClassName("tablinks");
            for (i = 0; i < tablinks.length; i++) {
                tablinks[i].classList.remove("active");
            }

            // 3. Hiển thị nội dung tab hiện tại và thêm class 'active' vào nút đã nhấn
            document.getElementById(contentName).style.display = "block";
            evt.currentTarget.classList.add("active");

            // 4. Cập nhật tiêu đề trang (H1)
            const newTitle = evt.currentTarget.getAttribute('data-content-title');
            document.getElementById('current-title').textContent = newTitle;
        }

        // Tự động mở tab mặc định khi tải trang
        document.addEventListener('DOMContentLoaded', (event) => {
             // Kích hoạt tab mặc định (Thông tin tài khoản)
            document.getElementById("btn-info").click();
        });

        // Hàm xử lý việc chuyển đổi các tab LỚN (Menu chính)
function openTab(evt, contentName) {
    let i, tabcontent, tablinks;

    // 1. Ẩn tất cả nội dung tabcontent
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // 2. Xóa class 'active' khỏi tất cả các nút tablinks
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].classList.remove("active");
    }

    // 3. Hiển thị nội dung tab hiện tại
    document.getElementById(contentName).style.display = "block";
    
    // 4. Thêm class 'active' vào nút đã nhấn
    evt.currentTarget.classList.add("active");

    // 5. Cập nhật tiêu đề trang (H1)
    const newTitle = evt.currentTarget.getAttribute('data-content-title');
    document.getElementById('current-title').textContent = newTitle;
    
    // 6. Xử lý logic Mở Tab Mặc định cho Lịch sử mua hàng (nếu đó là tab được mở)
    if (contentName === 'history-content') {
        // Tự động kích hoạt nút "Tất cả" bên trong Lịch sử mua hàng
        const defaultOrderTab = document.querySelector('#history-content .order-tab-group .order-tab');
        if (defaultOrderTab) {
            // Dùng .click() để kích hoạt hàm openOrderStatusTab với tham số null (vì không có event)
            openOrderStatusTab(null, 'all-orders');
            defaultOrderTab.classList.add('active'); // Thêm active cho nút
        }
    }
}

// Hàm xử lý việc chuyển đổi các tab NHỎ (Menu trạng thái đơn hàng)
function openOrderStatusTab(evt, contentName) {
    let i, orderContent, orderTabs;

    // 1. Ẩn tất cả nội dung đơn hàng (order-content)
    orderContent = document.getElementsByClassName("order-content");
    for (i = 0; i < orderContent.length; i++) {
        orderContent[i].style.display = "none";
    }

    // 2. Xóa class 'active' khỏi tất cả các nút order-tab
    orderTabs = document.getElementsByClassName("order-tab");
    for (i = 0; i < orderTabs.length; i++) {
        orderTabs[i].classList.remove("active");
    }

    // 3. Hiển thị nội dung đơn hàng hiện tại
    document.getElementById(contentName).style.display = "block";
    
    // 4. Thêm class 'active' vào nút đã nhấn (chỉ khi có sự kiện click)
    if (evt && evt.currentTarget) {
        evt.currentTarget.classList.add("active");
    }
}


// Kích hoạt tab mặc định khi tải trang (Thông tin tài khoản)
document.addEventListener('DOMContentLoaded', (event) => {
    // Tìm nút đầu tiên có class tablinks và mô phỏng click
    const defaultTab = document.querySelector('.left-side .tablinks');
    if (defaultTab) {
        // Gọi hàm trực tiếp thay vì dùng .click() để tránh vấn đề với tham số event khi khởi động
        openTab({currentTarget: defaultTab}, defaultTab.getAttribute('onclick').split("'")[1]);
    }
});