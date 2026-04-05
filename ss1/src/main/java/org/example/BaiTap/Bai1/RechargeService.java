package org.example.BaiTap.Bai1;

public class RechargeService {
//    private PaymentGateway gateway;
//
//    // Inject từ bên ngoài thay vì tự new
//    public RechargeService(PaymentGateway gateway) {
//        this.gateway = gateway;
//    }
//
//    public void processRecharge(String username, double amount) {
//        gateway.pay(amount);
//        System.out.println("Nạp " + amount + " cho " + username);
//    }

}

/*
* Dựa trên nguyên lý Inversion of Control (IoC), cách viết này gây ra các vấn đề sau:

Phụ thuộc chặt chẽ (Tightly Coupling): * RechargeService bị "dính cứng" vào InternalPaymentGateway.

Muốn đổi sang cổng thanh toán khác (Momo, Paypal), bạn buộc phải sửa mã nguồn của lớp này.
Vi phạm nguyên lý Open/Closed (Mở để mở rộng, đóng để sửa đổi).
Vi phạm nguyên lý IoC: * Lớp Service đang tự nắm quyền khởi tạo (tự quyết định dùng loại gateway nào).

Mất đi khả năng "đảo ngược điều khiển" cho một Container bên ngoài (như Spring) quản lý và "tiêm" (inject) vào.
*
Khó khăn khi Unit Test: * Không thể thay thế gateway bằng một đối tượng giả (Mock object).

Không thể kiểm thử độc lập logic của Service mà không gọi đến Gateway thật.
* */