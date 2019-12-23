package com.cnwtt.ban_ve_xe_khach.api.resource;

import com.cnwtt.ban_ve_xe_khach.api.Response;
import com.cnwtt.ban_ve_xe_khach.entity.User;
import com.cnwtt.ban_ve_xe_khach.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/login")
public class LoginResource {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    final
    UserService userService;

    public LoginResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/log")
    public @ResponseBody
    ResponseEntity<Response> login(@RequestParam("email") String email,
                                   @RequestParam("password") String password) {
        logger.info(email);
        logger.info(password);
        int code = 200;
        String message = "Success";
        User user = userService.login(email, password);
        if (user == null) {
            code = 400;
            message = "Username or password is incorrect!";
        }
        return ResponseEntity.ok(new Response(code, message, user));
    }
}
