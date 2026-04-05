package org.example.BaiTap.Bai3;

public interface UserAccountRepository {
    double getBalance(String username);
    void deductBalance(String username, double amount);
}