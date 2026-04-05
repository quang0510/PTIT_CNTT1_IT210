package org.example.ThucHanh;

import org.springframework.stereotype.Component;

@Component
public class VIPNotify implements Notification {
    @Override
    public void sendNotify(String username, double balance) {
        System.out.println("[ Popup ] Tài khoản: " + username + " | Số dư: " + balance+ " còn lại");
    }
}