package org.example.BaiTap.Bai2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

//Sử dụng Prototype Scope
@ComponentScan
@Scope("prototype")

public class PlaySession {
    private double playTime = 0;

    public void addTime(double time) {
        this.playTime += time;
    }


}

//Sử dụng Session Scope

//@Component
//@SessionScope
//public class PlaySession {
//    private double playTime = 0;
//    public void addTime(double time) {
//        this.playTime += time;
//    }
//    // ... các phương thức khác
//}


/*
*  Giải thích: Tại sao Singleton Bean gây ra hiện tượng tính nhầm tiền?
*
Dựa trên cơ chế quản lý Bean của Spring Framework, hiện tượng máy 01 nạp tiền mà máy 02 bị ảnh hưởng là do:

Cơ chế Singleton mặc định: Khi đánh dấu @Component, Spring chỉ tạo ra duy nhất một thực thể (instance) của PlaySession cho toàn bộ ứng dụng.
*
Dùng chung bộ nhớ (Shared State): Tất cả các máy trạm (Máy 01, Máy 02,...) đều được Spring "tiêm" (inject) chung một đối tượng PlaySession duy nhất đó vào để xử lý
*
Xung đột dữ liệu: * Khi máy 01 gọi addTime(), giá trị biến playTime trong đối tượng dùng chung bị tăng lên.
*
Vì máy 02 cũng nhìn vào đúng đối tượng đó, nó sẽ thấy tổng thời gian đã tăng, dẫn đến việc hệ thống hiểu lầm máy 02 cũng đang chơi và trừ tiền oan.
*
Thiếu tính biệt lập (Isolation): Lớp có chứa biến lưu trữ dữ liệu riêng biệt của khách hàng (Stateful Bean) tuyệt đối không được để ở chế độ Singleton.
* */