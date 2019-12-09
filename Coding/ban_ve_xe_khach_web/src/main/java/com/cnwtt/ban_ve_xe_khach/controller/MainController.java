package com.cnwtt.ban_ve_xe_khach.controller;

import com.cnwtt.ban_ve_xe_khach.service.ViTriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private ViTriService service;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("listViTri",service.findAll());
        return "index";
    }
}
