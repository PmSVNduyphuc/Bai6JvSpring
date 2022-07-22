package com.example.controller.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user/userlist")
    public String showUserList() {
        return "listStudent";
    }
}
