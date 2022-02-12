package com.example.springconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {

    @Autowired
    private DbConnection dbConnection;

    @Value("${greet.say: default value}")
    private String hlo;
    @RequestMapping("/hello")
    public String greet(){
        return dbConnection.getConnection() +"----"+ dbConnection.getHost() +"...."+dbConnection.getPort();
    }
}
