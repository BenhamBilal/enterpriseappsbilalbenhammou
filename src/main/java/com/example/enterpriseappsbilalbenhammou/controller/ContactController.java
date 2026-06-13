package com.example.enterpriseappsbilalbenhammou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
    @GetMapping("/contact")
    public String showContact() {
        return "contact";
    }

    @PostMapping("/contact")
    public String sendMessage(@RequestParam String name,
                              @RequestParam String email,
                              @RequestParam String message) {
        // For now, just redirect back. Mailtrap integration comes later.
        return "redirect:/contact?success";
    }
}
