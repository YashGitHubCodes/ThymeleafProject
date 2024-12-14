package com.main.handsonjava.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showLoginPage() {
        return "customer/plain-login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "customer/access-denied";
    }
}
