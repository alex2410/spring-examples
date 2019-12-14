package ru.trushkin.spring.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String helloAuth(@RequestParam String name, Principal principal) {
        return "Hello " + name + getPrincipalInfo(principal);
    }

    @GetMapping("/admin")
    public String helloAdmin(@RequestParam String name, Principal principal) {
        return "Hello admin " + name + getPrincipalInfo(principal);
    }

    private String getPrincipalInfo(Principal principal) {
        return " .I know you are " + (principal == null ? null : principal.getName());
    }

    @GetMapping("/anonymous")
    public String anonymous(@RequestParam String name, Principal principal) {
        return "Hello " + name + getPrincipalInfo(principal);
    }

    @GetMapping("/everyone")
    public String index(@RequestParam String name, Principal principal) {
        return "Hello " + name + getPrincipalInfo(principal);
    }

}
