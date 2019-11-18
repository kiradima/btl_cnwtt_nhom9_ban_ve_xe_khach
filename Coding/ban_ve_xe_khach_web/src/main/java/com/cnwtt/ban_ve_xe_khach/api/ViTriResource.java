package com.cnwtt.ban_ve_xe_khach.api;

import com.cnwtt.ban_ve_xe_khach.entity.ViTri;
import com.cnwtt.ban_ve_xe_khach.service.ViTriService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vitri")
public class ViTriResource {

    private static Logger LOGGER = LoggerFactory.getLogger(ViTriResource.class);

    @Autowired
    private ViTriService service;

    @PostMapping("/create")
    public ResponseEntity<ViTri> save(@RequestBody ViTri entity) {
        LOGGER.info("Call api create vitri");
        return ResponseEntity.ok(service.create(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViTri> get(@PathVariable("id") Integer id) {
        LOGGER.info("Call api get vitri: id[{}]", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<ViTri> update(@RequestBody ViTri entity) {
        LOGGER.info("Call api update vitri");
        return ResponseEntity.ok(service.update(entity));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        LOGGER.info("Call api delete vitri : id [{}]", id);
        service.delete(id);
    }

    @GetMapping("/list")
    public Page<ViTri> list(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "size", defaultValue = "20") int size,
                               @RequestParam(value = "sort_by", defaultValue = "id") String sortField) {
        LOGGER.info("Call api list vitri");
        return service.getLists(PageRequest.of(page - 1, size, Sort.by(sortField)));
    }


}
