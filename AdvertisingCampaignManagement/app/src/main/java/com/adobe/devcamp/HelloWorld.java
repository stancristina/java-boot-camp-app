package com.adobe.devcamp;
import com.adobe.devcamp.model.User;
import com.adobe.devcamp.service.GenericService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.Map;

@SpringBootApplication
public class HelloWorld {
    private static GenericService genericService;
    public HelloWorld(GenericService genericService) {
        this.genericService = genericService;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SpringApplication.run(HelloWorld.class);
    }

}
