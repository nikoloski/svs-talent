package com;

import com.ventoelectrics.waterheater.WaterHeater;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WaterHeaterApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(WaterHeaterApplication.class, args);
        ctx.getBean(WaterHeater.class).simulateRun();
    }
}
