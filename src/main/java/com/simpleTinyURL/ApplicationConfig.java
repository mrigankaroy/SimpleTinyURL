package com.simpleTinyURL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by mrro1015 on 11/28/2017.
 */
@SpringBootApplication
@ImportResource("classpath:SpringConfig.xml")
public class ApplicationConfig {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfig.class, args);
    }
}
