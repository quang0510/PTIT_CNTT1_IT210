package org.example.ThucHanh;

import org.springframework.context.annotation.Bean;

public class AppConfig {

    // Bean - VIPNotify
    @Bean
    public VIPNotify vipNotify() {
        return new VIPNotify();
    }

    // Bean - NormalNotify
    @Bean
    public NormalNotify normalNotify() {
        return new NormalNotify();
    }

    // Bean - AccountManagement
    @Bean
    public AccountManagement accountManagement() {
        return new AccountManagement();
    }


}