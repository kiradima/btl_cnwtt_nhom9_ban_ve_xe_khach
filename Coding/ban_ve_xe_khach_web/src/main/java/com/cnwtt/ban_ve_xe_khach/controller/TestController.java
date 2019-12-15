package com.cnwtt.ban_ve_xe_khach.controller;

import com.cnwtt.ban_ve_xe_khach.service.ChuyenXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    private ChuyenXeService chuyenXeService;

    @GetMapping("/a")
    public String test(Model model){
        model.addAttribute("listChuyenXe", chuyenXeService.findAll());
        return "tranglichsu";
    }

    @GetMapping("/b")
    public String test1(Model model){
        model.addAttribute("listChuyenXe", chuyenXeService.findAll());
        return "trangThanhtoan";
    }
}
