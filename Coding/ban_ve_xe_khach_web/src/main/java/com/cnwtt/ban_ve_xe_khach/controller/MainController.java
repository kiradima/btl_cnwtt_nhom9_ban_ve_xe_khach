package com.cnwtt.ban_ve_xe_khach.controller;

import com.cnwtt.ban_ve_xe_khach.service.NhaXeService;
import com.cnwtt.ban_ve_xe_khach.service.ViTriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private ViTriService viTriService;
    @Autowired
    private NhaXeService nhaXeService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("viTris", viTriService.findAll());
        return "trangdautien";
    }

    @GetMapping("/login")
    public String test() {
        return "login";
    }

    @GetMapping("/trang-chu")
    public String trangChu(Model model) {
        model.addAttribute("viTris", viTriService.findAll());
        model.addAttribute("nhaXes", nhaXeService.findAllNhaXe());
        return "trangchu";
    }
}
