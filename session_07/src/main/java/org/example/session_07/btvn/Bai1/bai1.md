Tại sao Tên cửa hàng bị null? 

Trong Spring Boot, khi bạn gửi một Form bằng phương thức POST, 
cơ chế Data Binding (mặc định là ModelAttribute) sẽ tìm kiếm các thuộc tính trong POJO 
dựa trên thuộc tính name của thẻ .

Trong POJO: Thuộc tính được đặt tên là name.

Trong HTML: Thẻ input lại đặt name="restaurantName".

Kết quả: Spring không tìm thấy trường nào tên là restaurantName trong class RestaurantProfile,
vì vậy nó bỏ qua và trường name trong Java không được gán giá trị (mặc định là null).

Tại sao Checkbox active bị lỗi logic? Có hai vấn đề khiến trường boolean này không chạy đúng:

Sai giá trị (Value mismatch): Bạn đang để value="MỞ_CỬA". 
Kiểu boolean trong Java chỉ hiểu các giá trị như "true"/"false", "on"/"off", hoặc "1"/"0". 
Việc gửi một chuỗi Tiếng Việt khiến Spring không thể ép kiểu (cast) sang boolean.

Cơ chế Checkbox: Nếu người dùng không tích vào checkbox,
trình duyệt sẽ không gửi bất kỳ dữ liệu nào của field đó lên Server.
Nếu không dùng Thymeleaf để xử lý (thẻ hidden phụ), 
giá trị ở Backend đôi khi bị giữ nguyên trạng thái cũ hoặc gây lỗi mapping nếu không có xử lý mặc định.