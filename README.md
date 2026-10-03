# BÀI 3: TẠO CƠ SỞ DỮ LIỆU CHO WEBSITE BÁN HÀNG

Dự án mẫu thực hành Spring Boot kết nối MySQL quản lý cơ sở dữ liệu Website Bán Hàng theo đúng nội dung yêu cầu thực hành.

---

## 1. Cấu trúc dự án
```text
TH_03_231A290039_CNPM/
├── pom.xml                                  # Cấu hình dependency Maven (Spring Data JPA, MySQL Connector, Lombok)
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── thjava/
│   │   │       └── thbuoi2/
│   │   │           ├── Thbuoi2Application.java   # Main class khởi chạy Spring Boot
│   │   │           ├── DataInitializer.java      # Khởi tạo dữ liệu mẫu kiểm tra CSDL
│   │   │           ├── models/                   # Các Entity ánh xạ CSDL
│   │   │           │   ├── Category.java         # Bảng categories (1 - N với Product)
│   │   │           │   ├── Product.java          # Bảng products (N - 1 với Category)
│   │   │           │   ├── Order.java            # Bảng orders (1 - N với OrderDetail)
│   │   │           │   └── OrderDetail.java      # Bảng order_details (N - 1 với Order & Product)
│   │   │           └── repository/               # Các Interface Repository CRUD
│   │   │               ├── CategoryRepository.java
│   │   │               ├── ProductRepository.java
│   │   │               ├── OrderRepository.java
│   │   │               └── OrderDetailRepository.java
│   │   └── resources/
│   │       └── application.properties       # Cấu hình kết nối MySQL port 4406, ddl-auto=update
└── README.md
```

---

## 2. Các bước chuẩn bị và chạy dự án

### Bước 1: Khởi động MySQL trên Laragon
1. Mở **Laragon** -> Nhấn vào biểu tượng **Bánh răng (Settings)** ở góc phải.
2. Chọn tab **Services & Ports**, đổi cổng MySQL sang **`4406`** (để tránh xung đột cổng 3306).
3. Nhấn **Start All**.
4. Nhấn nút **Database** để mở **HeidiSQL** (User: `root`, Password: để trống).
5. Nhấp chuột phải -> Chọn **Create new** -> **Database** -> Nhập tên **`WebBanHang`** -> Nhấn OK.

### Bước 2: Chạy ứng dụng Spring Boot
* **Trong Eclipse:**
  * Chọn `File` -> `Import...` -> `Existing Maven Projects` -> Trỏ đến thư mục dự án này.
  * Mở file `Thbuoi2Application.java`.
  * Nhấp chuột phải -> `Run As` -> `Spring Boot App` (hoặc `Java Application`).
* **Trong VS Code:**
  * Mở thư mục dự án trong VS Code.
  * Cài extension "Spring Boot Extension Pack" và "Extension Pack for Java".
  * Nhấn `F5` hoặc mở file `Thbuoi2Application.java` và nhấn `Run`.

### Bước 3: Nghiệm thu kết quả
1. Console hiển thị:
   ```text
   Hibernate: create table categories (...)
   Hibernate: create table products (...)
   Hibernate: create table orders (...)
   Hibernate: create table order_details (...)
   Hibernate: alter table products add constraint ... foreign key (category_id) references categories (id)
   >>> KẾT NỐI VÀ KHỞI TẠO BẢNG CSDL THÀNH CÔNG! <<<
   ```
2. Mở HeidiSQL trên Laragon, nhấn `F5`:
   * 4 bảng xuất hiện tự động: `categories`, `orders`, `order_details`, `products`.
   * Bảng `categories` và `products` đã được chèn dữ liệu mẫu thành công.
