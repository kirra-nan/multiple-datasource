package com.example.kirracloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("com.example.kirracloud.mapper")
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class KirraCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(KirraCloudApplication.class, args);
    }
}
