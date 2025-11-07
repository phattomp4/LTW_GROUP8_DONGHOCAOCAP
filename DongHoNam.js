const filterButton = document.getElementById('filterButton'); 
const filterDropdown = document.getElementById('filterDropdown');
const pageOverlay = document.getElementById('pageOverlay');
const applyButton = document.querySelector('.apply-button'); 
const productItems = document.querySelectorAll('.items'); 

function priceToNumber(priceString) {
    if (!priceString) return 0;
    // Loại bỏ dấu '₫', dấu chấm (.), và khoảng trắng
    return parseInt(priceString.replace('₫', '').replace(/\./g, '').trim());
}

/**
 * Lấy thương hiệu từ tên sản phẩm (Giả định thương hiệu là từ đầu tiên)
 */
function getBrandFromItem(itemName) {
    return itemName.split(' ')[0].trim();
}

/**
 * Kiểm tra xem giá của sản phẩm có nằm trong phạm vi được chọn không
 */
function checkPriceRange(price, selectedRadioValue) {
    // Giá trị tối đa giả định (ví dụ: 200 Triệu) cho phạm vi mở
    const MAX_PRICE = 200000000; 
    
    // Lưu ý: Giá trị radio trong HTML của bạn không chi tiết, nên chúng ta cần ánh xạ lại logic
    switch (selectedRadioValue) {
        case 'Dưới 1 Triệu':
            return price < 1000000;
        case 'Từ 1 Triệu - 5 Triệu':
            return price >= 1000000 && price <= 5000000;
        case 'Từ 6 - 9 Triệu':
            return price >= 6000000 && price <= 9000000;
        case 'Từ 9 - 15 Triệu':
            return price >= 9000000 && price <= 15000000;
        case 'Từ 15 - 30 Triệu':
            return price >= 15000000 && price <= 30000000;
        case 'Từ 30 - 50 Triệu':
            return price >= 30000000 && price <= 50000000;
        case 'Từ 50 - 80 Triệu':
            return price >= 50000000 && price <= 80000000;
        case 'Từ 80 - 120 Triệu':
            return price >= 80000000 && price <= 120000000;
        case 'Từ 120 - 150 Triệu':
            return price >= 120000000 && price <= 150000000;
        case '150 Triệu':
            return price >= 150000000;
        default:
            return true; // Nếu không chọn giá nào, coi như hợp lệ
    }
}

// --- Hàm xử lý sự kiện chính ---

/**
 * Hàm ẩn/hiện khung lọc và overlay
 */
function toggleDropdown(){
    filterDropdown.classList.toggle('show');
    pageOverlay.classList.toggle('active');
}

/**
 * Hàm xử lý khi nhấn nút "Áp dụng"
 */
function applyFilters(event) {
    event.preventDefault(); // Ngăn chặn hành vi mặc định (nếu button nằm trong form)

    // 1. Thu thập các tiêu chí lọc
    
    // Lọc Hãng (Brands)
    const selectedBrands = Array.from(document.querySelectorAll('input[name="brand"]:checked'))
        .map(checkbox => checkbox.value.trim().toLowerCase());
    
    // Lọc Giá (Price)
    const selectedPriceElement = document.querySelector('input[name="price"]:checked');
    // Lấy nội dung text của label để xác định phạm vi giá chi tiết
    const selectedPriceLabel = selectedPriceElement ? selectedPriceElement.parentElement.textContent.trim() : null;

    // 2. Lặp qua các sản phẩm và áp dụng lọc
    productItems.forEach(item => {
        const itemPriceString = item.querySelector('.price').textContent;
        const itemPrice = priceToNumber(itemPriceString);
        const itemName = item.querySelector('.name-items').textContent;
        const itemBrand = getBrandFromItem(itemName).toLowerCase();

        // Kiểm tra điều kiện lọc
        let matchesBrand = true;
        let matchesPrice = true;

        // Lọc theo Hãng: Nếu có hãng được chọn VÀ hãng sản phẩm không nằm trong danh sách chọn
        if (selectedBrands.length > 0 && !selectedBrands.includes(itemBrand)) {
            matchesBrand = false;
        }

        // Lọc theo Giá: Nếu có phạm vi giá được chọn VÀ giá sản phẩm không khớp phạm vi
        if (selectedPriceLabel && !checkPriceRange(itemPrice, selectedPriceLabel)) {
            matchesPrice = false;
        }

        // 3. Ẩn/Hiện sản phẩm
        if (matchesBrand && matchesPrice) {
            item.style.display = 'block'; // Hiển thị sản phẩm
        } else {
            item.style.display = 'none'; // Ẩn sản phẩm
        }
    });

    // 4. Đóng khung lọc sau khi áp dụng
    toggleDropdown();
}


// --- Gán sự kiện (Listeners) ---

// Sự kiện cho nút Bộ lọc (Mở/Đóng)
filterButton.addEventListener('click', toggleDropdown);

// Sự kiện cho nút Áp dụng (Thực hiện lọc)
applyButton.addEventListener('click', applyFilters);

// Sự kiện đóng khung khi click ra ngoài (bao gồm cả lớp phủ mờ)
document.addEventListener('click', function(event){
    if (
        !filterDropdown.contains(event.target) && 
        !filterButton.contains(event.target) &&
        filterDropdown.classList.contains('show') // Chỉ chạy khi dropdown đang mở
    ) {
        toggleDropdown(); // Đóng khung và tắt overlay
    }
});