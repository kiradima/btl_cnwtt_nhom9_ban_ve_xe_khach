package com.cnwtt.ban_ve_xe_khach.api;


import com.cnwtt.ban_ve_xe_khach.entity.VeXe;
import com.cnwtt.ban_ve_xe_khach.service.VeXeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vexe")
public class VeXeResource {

    private static Logger LOGGER = LoggerFactory.getLogger(VeXeResource.class);

    @Autowired
    private VeXeService service;

    @PostMapping("/create")
    public ResponseEntity<VeXe> save(@RequestBody VeXe entity) {
        LOGGER.info("Call api create vexe");
        return ResponseEntity.ok(service.create(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeXe> get(@PathVariable("id") Integer id) {
        LOGGER.info("Call api get vexe: id[{}]", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<VeXe> update(@RequestBody VeXe entity) {
        LOGGER.info("Call api update vexe");
        return ResponseEntity.ok(service.update(entity));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        LOGGER.info("Call api delete vexe : id [{}]", id);
        service.delete(id);
    }

    @GetMapping("/list")
    public Page<VeXe> list(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "size", defaultValue = "20") int size,
                               @RequestParam(value = "sort_by", defaultValue = "id") String sortField) {
        LOGGER.info("Call api list vexe");
        return service.getLists(PageRequest.of(page - 1, size, Sort.by(sortField)));
    }


}
