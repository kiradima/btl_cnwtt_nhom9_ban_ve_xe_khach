package com.cnwtt.ban_ve_xe_khach.api;

import com.cnwtt.ban_ve_xe_khach.entity.ChuyenXe;
import com.cnwtt.ban_ve_xe_khach.service.ChuyenXeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chuyenxe")
public class ChuyenXeResource {

    private static Logger LOGGER = LoggerFactory.getLogger(ChuyenXeResource.class);

    @Autowired
    private ChuyenXeService service;

    @PostMapping("/create")
    public ResponseEntity<ChuyenXe> save(@RequestBody ChuyenXe entity) {
        LOGGER.info("Call api create chuyenxe");
        return ResponseEntity.ok(service.create(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChuyenXe> get(@PathVariable("id") Integer id) {
        LOGGER.info("Call api get chuyenxe: id[{}]", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<ChuyenXe> update(@RequestBody ChuyenXe entity) {
        LOGGER.info("Call api update chuyenxe");
        return ResponseEntity.ok(service.update(entity));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        LOGGER.info("Call api delete chuyenxe : id [{}]", id);
        service.delete(id);
    }

    @GetMapping("/list")
    public Page<ChuyenXe> list(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "size", defaultValue = "20") int size,
                               @RequestParam(value = "sort_by", defaultValue = "id") String sortField) {
        LOGGER.info("Call api list chuyenxe");
        return service.getLists(PageRequest.of(page - 1, size, Sort.by(sortField)));
    }


}
