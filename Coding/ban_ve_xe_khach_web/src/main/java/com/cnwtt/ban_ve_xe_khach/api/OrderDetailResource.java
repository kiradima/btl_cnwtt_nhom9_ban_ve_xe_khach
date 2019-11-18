package com.cnwtt.ban_ve_xe_khach.api;

import com.cnwtt.ban_ve_xe_khach.entity.OrderDetail;
import com.cnwtt.ban_ve_xe_khach.service.OrderDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ordertail")
public class OrderDetailResource {

    private static Logger LOGGER = LoggerFactory.getLogger(OrderDetailResource.class);

    @Autowired
    private OrderDetailService service;

    @PostMapping("/create")
    public ResponseEntity<OrderDetail> save(@RequestBody OrderDetail entity) {
        LOGGER.info("Call api create ordertail");
        return ResponseEntity.ok(service.create(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> get(@PathVariable("id") Integer id) {
        LOGGER.info("Call api get ordertail: id[{}]", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<OrderDetail> update(@RequestBody OrderDetail entity) {
        LOGGER.info("Call api update ordertail");
        return ResponseEntity.ok(service.update(entity));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        LOGGER.info("Call api delete ordertail : id [{}]", id);
        service.delete(id);
    }

    @GetMapping("/list")
    public Page<OrderDetail> list(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "size", defaultValue = "20") int size,
                               @RequestParam(value = "sort_by", defaultValue = "id") String sortField) {
        LOGGER.info("Call api list ordertail");
        return service.getLists(PageRequest.of(page - 1, size, Sort.by(sortField)));
    }


}
