package com.cnwtt.ban_ve_xe_khach.api.resource;

import com.cnwtt.ban_ve_xe_khach.api.Response;
import com.cnwtt.ban_ve_xe_khach.api.response.trangdautien.SearchResponse;
import com.cnwtt.ban_ve_xe_khach.entity.ChuyenXe;
import com.cnwtt.ban_ve_xe_khach.entity.ViTriChuyenXe;
import com.cnwtt.ban_ve_xe_khach.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/trangdautien")
public class TrangDauTienResource {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public static final int TYPE_DIEM_DI = 0;
    public static final int TYPE_DIEM_DUNG = 1;
    final
    ChuyenXeService chuyenXeService;
    final
    NhaXeService nhaXeService;
    final
    ViTriService viTriService;
    final
    ViTriChuyenXeService viTriChuyenXeService;
    final
    OrderDetailService orderDetailService;
    final
    DanhGiaService danhGiaService;

    public TrangDauTienResource(ChuyenXeService chuyenXeService, NhaXeService nhaXeService,
                                ViTriService viTriService, ViTriChuyenXeService viTriChuyenXeService,
                                OrderDetailService orderDetailService, DanhGiaService danhGiaService) {
        this.chuyenXeService = chuyenXeService;
        this.nhaXeService = nhaXeService;
        this.viTriService = viTriService;
        this.viTriChuyenXeService = viTriChuyenXeService;
        this.orderDetailService = orderDetailService;
        this.danhGiaService = danhGiaService;
    }

    @GetMapping("/search")
    public ResponseEntity<Response> search(@RequestParam("diemXuatPhat") String diemXuatPhat,
                                           @RequestParam("diemDung") String diemDung,
                                           @RequestParam("ngayXuatPhat") String ngayXuatPhat) {
        logger.info("diemXuatPhat: " + diemXuatPhat);
        logger.info("diemDung: " + diemDung);
        logger.info("ngayXuatPhat: " + ngayXuatPhat);
        int code = 200;
        String message = "Success";
        List<SearchResponse> searchResponses = new ArrayList<>();
        try {
            List<ChuyenXe> chuyenXes = chuyenXeService.search(diemXuatPhat,
                    diemDung,
                    ngayXuatPhat);
            logger.info("size = " + chuyenXes.size());
            if(chuyenXes.size() ==0 ){
                code = 400;
                message = "Không có chuyến xe nào phù hợp!";
                return ResponseEntity.ok(new Response(code, message, searchResponses));
            }
            for (ChuyenXe chuyenXe : chuyenXes) {
                String tenNhaXe = nhaXeService.findById(chuyenXe.getIdNhaXe()).getTen();
                List<ViTriChuyenXe> viTriChuyenXesDi = viTriChuyenXeService.findByIdChuyenXeAndType(chuyenXe.getId(), TYPE_DIEM_DI);
                List<ViTriChuyenXe> viTriChuyenXesDung = viTriChuyenXeService.findByIdChuyenXeAndType(chuyenXe.getId(), TYPE_DIEM_DUNG);
                String soGheTrong = "Số ghế trống " + (chuyenXe.getSoGhe() - orderDetailService.count()) + "/" + chuyenXe.getSoGhe();
                String danhGiaSao = danhGiaService.star(chuyenXe.getId());
                logger.info(danhGiaSao);
                String soBinhLuan = danhGiaService.countComment(chuyenXe.getId()) + " bình luận";
                logger.info(soBinhLuan);
                searchResponses.add(new SearchResponse(chuyenXe, tenNhaXe, diemXuatPhat, diemDung,
                        viTriChuyenXesDi, viTriChuyenXesDung, soGheTrong, danhGiaSao, soBinhLuan));
            }
            return ResponseEntity.ok(new Response(code, message, searchResponses));
        } catch (Exception e) {
            code = 400;
            message = "Exception: " + e.getMessage();
            return ResponseEntity.ok(new Response(code, message, searchResponses));
        }
    }
}
