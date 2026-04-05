package org.example.ThucHanh;

import org.springframework.stereotype.Component;

@Component
public class NormalNotify implements Notification {
    @Override
    public void sendNotify(String username, double balance) {
        System.out.println("[ Sound ] Tài khoản: " + username + " | Số dư: " + balance + " còn lại");
    }
}