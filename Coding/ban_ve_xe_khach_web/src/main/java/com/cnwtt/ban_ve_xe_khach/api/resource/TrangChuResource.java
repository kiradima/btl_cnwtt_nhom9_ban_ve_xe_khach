package com.cnwtt.ban_ve_xe_khach.api.resource;

import com.cnwtt.ban_ve_xe_khach.api.Response;
import com.cnwtt.ban_ve_xe_khach.api.response.trangchu.GetDetailChuyenXeResponse;
import com.cnwtt.ban_ve_xe_khach.entity.OrderDetail;
import com.cnwtt.ban_ve_xe_khach.service.OrderDetailService;
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

    public TrangChuResource(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("/get/orders")
    public ResponseEntity<Response> getOrders(@RequestParam("idChuyenXe") int idChuyenXe) {
        int code = 200;
        String message = "Success";
        boolean isTwoFloors = false;
        List<String> listViTriGheOrdered = orderDetailService.getListViTriGheOrderedByIdChuyenXe(idChuyenXe);
        for (String viTriGhe : listViTriGheOrdered) {
            if (viTriGhe.contains("B")) {
                isTwoFloors = true;
                break;
            }
        }
        if (listViTriGheOrdered == null) {
            code = 400;
            message = "Failed";
        }
        return ResponseEntity.ok(new Response(code, message, new GetDetailChuyenXeResponse(listViTriGheOrdered, isTwoFloors)));
    }
}
