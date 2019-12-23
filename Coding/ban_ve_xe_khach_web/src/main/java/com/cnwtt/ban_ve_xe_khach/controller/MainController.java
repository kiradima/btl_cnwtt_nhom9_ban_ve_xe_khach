package com.cnwtt.ban_ve_xe_khach.controller;

import com.cnwtt.ban_ve_xe_khach.api.Response;
import com.cnwtt.ban_ve_xe_khach.api.UserResource;
import com.cnwtt.ban_ve_xe_khach.api.request.trangdautien.SearchRequest;
import com.cnwtt.ban_ve_xe_khach.entity.ChuyenXe;
import com.cnwtt.ban_ve_xe_khach.service.ChuyenXeService;
import com.cnwtt.ban_ve_xe_khach.service.NhaXeService;
import com.cnwtt.ban_ve_xe_khach.service.ViTriService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    private static Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    private final ViTriService viTriService;
    private final NhaXeService nhaXeService;
    private final ChuyenXeService chuyenXeService;

    public MainController(ViTriService viTriService, NhaXeService nhaXeService, ChuyenXeService chuyenXeService) {
        this.viTriService = viTriService;
        this.nhaXeService = nhaXeService;
        this.chuyenXeService = chuyenXeService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tinhs", viTriService.getAllTinhs());
        return "trangdautien";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/history")
    public String history() {
        return "tranglichsu";
    }

    @GetMapping("/trang-chu")
    public String trangChu(Model model) {
        model.addAttribute("tinhs", viTriService.getAllTinhs());
        model.addAttribute("nhaXes", nhaXeService.findAllNhaXe());
        return "trangchu";
    }

    @RequestMapping(value = "/search", produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Response> search(@ModelAttribute SearchRequest request) {
        LOGGER.info("Call api search");
        LOGGER.info(request.getDiemXuatPhat());
        LOGGER.info(request.getDiemDung());
        LOGGER.info(request.getNgayXuatPhat());
        int code = 200;
        String message = "Success";
        List<ChuyenXe> chuyenXes = chuyenXeService.search(request.getDiemXuatPhat(),
                request.getDiemDung(),
                request.getNgayXuatPhat());
        if (chuyenXes == null) {
            code = 400;
            message = "Failure";
        }
        return ResponseEntity.ok(new Response(code, message, chuyenXes));
    }
}
