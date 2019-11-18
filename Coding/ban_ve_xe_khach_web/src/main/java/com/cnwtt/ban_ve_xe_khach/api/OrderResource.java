package com.cnwtt.ban_ve_xe_khach.api;

import com.cnwtt.ban_ve_xe_khach.entity.Order;
import com.cnwtt.ban_ve_xe_khach.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderResource {

    private static Logger LOGGER = LoggerFactory.getLogger(OrderResource.class);

    @Autowired
    private OrderService service;

    @PostMapping("/create")
    public ResponseEntity<Order> save(@RequestBody Order entity) {
        LOGGER.info("Call api create order");
        return ResponseEntity.ok(service.create(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@PathVariable("id") Integer id) {
        LOGGER.info("Call api get order: id[{}]", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Order> update(@RequestBody Order entity) {
        LOGGER.info("Call api update order");
        return ResponseEntity.ok(service.update(entity));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        LOGGER.info("Call api delete order : id [{}]", id);
        service.delete(id);
    }

    @GetMapping("/list")
    public Page<Order> list(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "size", defaultValue = "20") int size,
                               @RequestParam(value = "sort_by", defaultValue = "id") String sortField) {
        LOGGER.info("Call api list order");
        return service.getLists(PageRequest.of(page - 1, size, Sort.by(sortField)));
    }


}
