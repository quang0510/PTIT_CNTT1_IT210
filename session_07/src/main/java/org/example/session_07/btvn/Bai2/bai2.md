Nguyên tắc bị vi phạm: 
DRY (Don't Repeat Yourself) Đoạn code đang vi phạm trực tiếp nguyên tắc DRY.
Thay vì tập trung xử lý logic riêng biệt của từng trang (Trang Add tạo mới, Trang Edit lấy dữ liệu cũ),
Fresher lại đang bắt cả 3 hàm phải gánh thêm phần việc "chuẩn bị dữ liệu dùng chung".

Rủi ro bảo trì Nếu sau này hệ thống mở rộng lên 20 trang hoặc nghiệp vụ thay đổi 
(ví dụ: đổi tên "Món chính" thành "Món đặc biệt", hoặc lấy danh sách này từ Database thay vì fix cứng), bạn sẽ phải:

Sửa tay tại 20 địa điểm khác nhau: Rất dễ sót (Human error).

Unit Test: Phải viết test lặp lại cho cùng một logic ở nhiều hàm.

Phình to Controller: Code bị loãng, khó đọc vì các dòng code setup chiếm quá nhiều diện tích
so với logic nghiệp vụ thực tế.