package com.pingou.msuseradress;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HelloWorld {
    @GetMapping("/")
    public String hello() {
        return "Hello Spring!!!";
    }
}
