package com.dongyang.wooyeong01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {
    @GetMapping("/quote")
    public String quote(Model mo2){
        String[] quotes = {
                "명언1",
                "명언2",
                "명언3"
        };
        int random = (int) (Math.random() * quotes.length);
        mo2.addAttribute("quote", quotes[random]);
        return "quote";
    }
}
