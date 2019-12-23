package com.cnwtt.ban_ve_xe_khach.api.resource;

import com.cnwtt.ban_ve_xe_khach.api.Response;
import com.cnwtt.ban_ve_xe_khach.api.response.trangchu.GetDetailChuyenXeResponse;
import com.cnwtt.ban_ve_xe_khach.entity.OrderDetail;
import com.cnwtt.ban_ve_xe_khach.entity.VeXe;
import com.cnwtt.ban_ve_xe_khach.entity.ViTriChuyenXe;
import com.cnwtt.ban_ve_xe_khach.service.OrderDetailService;
import com.cnwtt.ban_ve_xe_khach.service.VeXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/trangchu")
public class TrangChuResource {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    final
    OrderDetailService orderDetailService;
    final
    VeXeService veXeService;

    public TrangChuResource(OrderDetailService orderDetailService, VeXeService veXeService) {
        this.orderDetailService = orderDetailService;
        this.veXeService = veXeService;
    }

    @GetMapping("/get/orders")
    public ResponseEntity<Response> getOrders(@RequestParam("idChuyenXe") int idChuyenXe) {
        int code = 200;
        String message = "Success";
        boolean isTwoFloors = false;
        List<String> listViTriGheOrdered = orderDetailService.getListViTriGheOrderedByIdChuyenXe(idChuyenXe);
        List<VeXe> veXes = veXeService.getVeXesByIdChuyenXe(idChuyenXe);
        for (VeXe veXe : veXes) {
            if (veXe.getViTriGhe().contains("B")) {
                isTwoFloors = true;
                break;
            }
        }
        return ResponseEntity.ok(new Response(code, message, new GetDetailChuyenXeResponse(listViTriGheOrdered, isTwoFloors, veXes)));
    }
}
