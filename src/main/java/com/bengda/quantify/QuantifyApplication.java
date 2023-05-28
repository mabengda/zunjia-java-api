package com.bengda.quantify;


import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@RetrofitScan(basePackages = "com.*")
//@EnableScheduling
@SpringBootApplication
public class QuantifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuantifyApplication.class, args);
    }

}
