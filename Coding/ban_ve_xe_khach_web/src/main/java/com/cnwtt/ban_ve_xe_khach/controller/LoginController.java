package com.cnwtt.ban_ve_xe_khach.controller;

import com.cnwtt.ban_ve_xe_khach.entity.User;
import com.cnwtt.ban_ve_xe_khach.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LoginController {
    private List<User> users;
    private UserService service;
    private Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public Boolean login(String username, String password) {
//        List<User> users = service.findAllUser();
        service = new UserService();
//        for (User user : users) {
//            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
//                return true;
//            }
//        }
        return false;
    }

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }
}
