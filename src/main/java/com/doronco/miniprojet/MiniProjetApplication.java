package com.doronco.miniprojet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@SpringBootApplication
public class MiniProjetApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniProjetApplication.class, args);
    }

}
