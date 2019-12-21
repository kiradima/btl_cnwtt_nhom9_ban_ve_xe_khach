package com.cnwtt.ban_ve_xe_khach.api;

import com.cnwtt.ban_ve_xe_khach.entity.ThanhToan;
import com.cnwtt.ban_ve_xe_khach.service.ThanhToanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/thanhtoan")
public class ThanhToanResource {

    private static Logger LOGGER = LoggerFactory.getLogger(ThanhToanResource.class);

    @Autowired
    private ThanhToanService service;

    @PostMapping("/create")
    public ResponseEntity<ThanhToan> save(@RequestBody ThanhToan entity) {
        LOGGER.info("Call api create ThanhToan");
        return ResponseEntity.ok(service.create(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThanhToan> get(@PathVariable("id") Long id) {
        LOGGER.info("Call api get ThanhToan: id[{}]", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<ThanhToan> update(@RequestBody ThanhToan entity) {
        LOGGER.info("Call api update ThanhToan");
        return ResponseEntity.ok(service.update(entity));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Call api delete ThanhToan : id [{}]", id);
        service.delete(id);
    }

    @GetMapping("/list")
    public Page<ThanhToan> list(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "size", defaultValue = "20") int size,
                           @RequestParam(value = "sort_by", defaultValue = "id") String sortField) {
        LOGGER.info("Call api list ThanhToan");
        return service.getLists(PageRequest.of(page - 1, size, Sort.by(sortField)));
    }
}
