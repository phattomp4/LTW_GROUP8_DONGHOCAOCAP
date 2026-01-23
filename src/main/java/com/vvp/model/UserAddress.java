package com.vvp.model;

public class UserAddress {
    private int id;
    private int uID;
    private String name;    // Map với ReceiverName
    private String phone;   // Map với Phone
    private String address; // Map với Street
    private String city;    // Map với City (Thêm vào cho đủ bộ)
    private boolean isDefault;

    public UserAddress() {}

    // Constructor 7 tham số (Khớp với Database của bạn)
    public UserAddress(int id, int uID, String name, String phone, String address, String city, boolean isDefault) {
        this.id = id;
        this.uID = uID;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.isDefault = isDefault;
    }

    // --- CÁC HÀM GETTER BẮT BUỘC (JSP dùng cái này để hiển thị) ---
    public int getId() { return id; }
    public int getuID() { return uID; }
    public String getName() { return name; }       // JSP gọi ${addr.name}
    public String getPhone() { return phone; }     // JSP gọi ${addr.phone}
    public String getAddress() { return address; } // JSP gọi ${addr.address}
    public String getCity() { return city; }
    public boolean getIsDefault() { return isDefault; }
}