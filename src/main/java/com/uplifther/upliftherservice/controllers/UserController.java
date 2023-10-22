package com.uplifther.upliftherservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @RequestMapping("/login")
    public String userLogin() {
        return "Surprise!!";
    }
}
