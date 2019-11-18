package com.cnwtt.ban_ve_xe_khach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViTriController {
    @GetMapping("/vitri")
    public String viTri(){
        return "/vitri";
    }
}
