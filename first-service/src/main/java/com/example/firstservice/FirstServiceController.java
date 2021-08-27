package com.example.firstservice;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/first-service")
@Slf4j
public class FirstServiceController {

//    @Value("local.server.port")
//    private String serverPort;


    Environment env;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    // GET http://localhost:8081/first-service/welcome   이메서드가 응답
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the First service.";
    }

    @GetMapping("/message")
    public String message(@RequestHeader(value = "first-request", required = true) String header) {
        System.out.println("header : " + header);

        return "Hello, First service";
    }


    @GetMapping("/check")
    public String check(HttpServletRequest request) {
        log.info("Server port={}", request.getServerPort());

        return String.format("Hi. there. This is a message from First Service on PORT %s.", env.getProperty("local.server.port"));
    }
}
