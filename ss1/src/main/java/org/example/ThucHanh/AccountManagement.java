package org.example.ThucHanh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AccountManagement {

    List<Account> accounts = new ArrayList<>(
            Arrays.asList(
                    new Account("Hoang Cuong Cat", 4000.0),
                    new Account("Nguyen Quang Vinh", 3.600),
                    new Account("Tran Minh Quang", 1.800)
            )
    );

    public void checkYourBalance(String username, String area) {
        // kiểm tra username có rỗng hay không
        if(username == null || username.isEmpty()) {
            System.err.println("[ERROR] Ten khong hop le");
            return;
        }

        // Kiểm tra username có tồn tại trong hệ thống hay không
        boolean isExist = accounts.stream()
                .anyMatch(
                        account ->
                                account.getUsername().equals(username)
                );
        if(!isExist) {
            System.err.println("[ERROR] Nguoi dung khong ton tai");
            return;
        }

        // Kiểm tra balance < 0
        Account account = accounts.stream()
                // lọc ra phần tử nào có username = với usename nhập vào ở trên --> [ 1 phần tử ]
                .filter(a -> a.getUsername().equals(username))
                // lấy cái đầu tiên
                .findFirst()
                // nếu như phần tử không tồn tại thì trả về null
                .orElse(null);

        if(account != null) {
            // Trường hợp balance < 0
            if(account.getBalance() < 0) {
                System.err.println("[ERROR] Khong du so du");
                return;
            }

            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

            if(account.getBalance() < 5000) {
                String nameBean = "";
                if(area.equals("VIP")) {
                    // VIP
                    nameBean += "vip";
//                    VIPNotify vipNotify = context.getBean("vipNotify", VIPNotify.class);
//                    vipNotify.sendNotify(username,account.getBalance());
                } else {
                    // Normal
                    nameBean += "normal";
//                    NormalNotify normalNotify = context.getBean("normalNotify",NormalNotify.class);
//                    normalNotify.sendNotify(username,account.getBalance());
                }

                nameBean += "Notify";

                Notification notification = context.getBean(nameBean,Notification.class);
                notification.sendNotify(username,account.getBalance());
            }


        }

    }

}