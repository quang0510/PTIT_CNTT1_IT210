package org.example.BaiTap.Bai3;

import org.springframework.stereotype.Service;

@Service
public class OrderFoodService {

//    private final InventoryRepository inventoryRepository;
//    private final UserAccountRepository userAccountRepository;
//
//    // Constructor Injection (DI)
//    public OrderFoodService(InventoryRepository inventoryRepository,
//                            UserAccountRepository userAccountRepository) {
//        this.inventoryRepository = inventoryRepository;
//        this.userAccountRepository = userAccountRepository;
//    }
//
//    public String orderFood(String username, String foodName, int quantity, double price) {
//
//        int stock = inventoryRepository.getStock(foodName);
//        if (stock < quantity) {
//            return "Hết hàng!";
//        }
//
//        double totalCost = quantity * price;
//        double balance = userAccountRepository.getBalance(username);
//
//        if (balance < totalCost) {
//            return "Không đủ tiền!";
//        }
//
//        // Xử lý
//        inventoryRepository.decreaseStock(foodName, quantity);
//        userAccountRepository.deductBalance(username, totalCost);
//
//        return "Đặt món thành công!";
//    }

}