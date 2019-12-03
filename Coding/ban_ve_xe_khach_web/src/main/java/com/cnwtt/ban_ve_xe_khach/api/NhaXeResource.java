package com.cnwtt.ban_ve_xe_khach.api;

import com.cnwtt.ban_ve_xe_khach.entity.NhaXe;
import com.cnwtt.ban_ve_xe_khach.service.NhaXeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/nhaxe")
public class NhaXeResource {

    private static Logger LOGGER = LoggerFactory.getLogger(NhaXeResource.class);

    @Autowired
    private NhaXeService service;

    @PostMapping("/create")
    public ResponseEntity<NhaXe> save(@RequestBody NhaXe entity) {
        LOGGER.info("Call api create nhaxe");
        return ResponseEntity.ok(service.create(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhaXe> get(@PathVariable("id") Integer id) {
        LOGGER.info("Call api get nhaxe: id[{}]", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<NhaXe> update(@RequestBody NhaXe entity) {
        LOGGER.info("Call api update nhaxe");
        return ResponseEntity.ok(service.update(entity));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        LOGGER.info("Call api delete nhaxe : id [{}]", id);
        service.delete(id);
    }

    @GetMapping("/list")
    public Page<NhaXe> list(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "size", defaultValue = "20") int size,
                               @RequestParam(value = "sort_by", defaultValue = "id") String sortField) {
        LOGGER.info("Call api list nhaxe");
        return service.getLists(PageRequest.of(page - 1, size, Sort.by(sortField)));
    }


}