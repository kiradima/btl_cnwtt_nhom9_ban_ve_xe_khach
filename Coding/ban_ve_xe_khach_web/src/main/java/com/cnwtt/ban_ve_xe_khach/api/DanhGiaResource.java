package com.cnwtt.ban_ve_xe_khach.api;

import com.cnwtt.ban_ve_xe_khach.entity.DanhGia;
import com.cnwtt.ban_ve_xe_khach.service.DanhGiaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/danhgia")
public class DanhGiaResource {

    private static Logger LOGGER = LoggerFactory.getLogger(DanhGiaResource.class);

    @Autowired
    private DanhGiaService service;

    @PostMapping("/create")
    public ResponseEntity<DanhGia> save(@RequestBody DanhGia entity) {
        LOGGER.info("Call api create danhgia");
        return ResponseEntity.ok(service.create(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DanhGia> get(@PathVariable("id") Long id) {
        LOGGER.info("Call api get danhgia: id[{}]", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<DanhGia> update(@RequestBody DanhGia entity) {
        LOGGER.info("Call api update danhgia");
        return ResponseEntity.ok(service.update(entity));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Call api delete danhgia : id [{}]", id);
        service.delete(id);
    }

    @GetMapping("/list")
    public Page<DanhGia> list(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "size", defaultValue = "20") int size,
                               @RequestParam(value = "sort_by", defaultValue = "id") String sortField) {
        LOGGER.info("Call api list danhgia");
        return service.getLists(PageRequest.of(page - 1, size, Sort.by(sortField)));
    }


}
