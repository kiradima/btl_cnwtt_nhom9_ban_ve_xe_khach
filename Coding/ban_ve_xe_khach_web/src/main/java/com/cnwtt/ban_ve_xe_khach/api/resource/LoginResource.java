package com.cnwtt.ban_ve_xe_khach.api.resource;

import com.cnwtt.ban_ve_xe_khach.api.Response;
import com.cnwtt.ban_ve_xe_khach.api.request.login.LoginRequest;
import com.cnwtt.ban_ve_xe_khach.entity.User;
import com.cnwtt.ban_ve_xe_khach.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/login")
public class LoginResource {
    final
    UserService userService;

    public LoginResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public @ResponseBody
    ResponseEntity<Response> login(@ModelAttribute LoginRequest loginRequest) {
        int code = 200;
        String message = "Success";
        User user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (user == null) {
            code = 400;
            message = "Username or password is incorrect!";
        }
        return ResponseEntity.ok(new Response(code, message, user));
    }
}
