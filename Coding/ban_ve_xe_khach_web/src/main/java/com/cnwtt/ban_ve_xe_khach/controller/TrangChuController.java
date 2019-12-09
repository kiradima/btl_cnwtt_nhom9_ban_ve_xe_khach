package com.cnwtt.ban_ve_xe_khach.controller;

import com.cnwtt.ban_ve_xe_khach.service.ViTriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrangChuController {
    @Autowired
    private ViTriService viTriService;

    @GetMapping("/trang-chu")
    public String trangChu(Model model){
        model.addAttribute("listViTri", viTriService.findAll());
        return "Trangchu";
    }
}
