package com.cnwtt.ban_ve_xe_khach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChuyenXeController {
    @GetMapping("/chuyenxe")
    public String chuyenXe(){
        return "/chuyenxe";
    }
}
