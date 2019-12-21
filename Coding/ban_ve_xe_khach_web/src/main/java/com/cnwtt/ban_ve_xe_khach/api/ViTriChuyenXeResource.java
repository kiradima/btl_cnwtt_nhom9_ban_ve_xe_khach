package com.cnwtt.ban_ve_xe_khach.api;

import com.cnwtt.ban_ve_xe_khach.entity.ViTriChuyenXe;
import com.cnwtt.ban_ve_xe_khach.service.ViTriChuyenXeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vitrichuyenxe")
public class ViTriChuyenXeResource {

    private static Logger LOGGER = LoggerFactory.getLogger(ViTriChuyenXeResource.class);

    @Autowired
    private ViTriChuyenXeService service;

    @PostMapping("/create")
    public ResponseEntity<ViTriChuyenXe> save(@RequestBody ViTriChuyenXe entity) {
        LOGGER.info("Call api create vitrichuyenxe");
        return ResponseEntity.ok(service.create(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViTriChuyenXe> get(@PathVariable("id") Long id) {
        LOGGER.info("Call api get vitrichuyenxe: id[{}]", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<ViTriChuyenXe> update(@RequestBody ViTriChuyenXe entity) {
        LOGGER.info("Call api update vitrichuyenxe");
        return ResponseEntity.ok(service.update(entity));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Call api delete vitrichuyenxe : id [{}]", id);
        service.delete(id);
    }

    @GetMapping("/list")
    public Page<ViTriChuyenXe> list(@RequestParam(value = "page", defaultValue = "1") int page,
                                    @RequestParam(value = "size", defaultValue = "20") int size,
                                    @RequestParam(value = "sort_by", defaultValue = "id") String sortField) {
        LOGGER.info("Call api list vitrichuyenxe");
        return service.getLists(PageRequest.of(page - 1, size, Sort.by(sortField)));
    }

    @GetMapping("/get/chuyenxe_type")
    public ResponseEntity<Response> findByIdChuyenXeAndType(@RequestParam(value = "idChuyenXe") int idChuyenXe,
                                                            @RequestParam(value = "type") int type) {
        return ResponseEntity.ok(new Response(200, "success", service.findByIdChuyenXeAndType(idChuyenXe, type)));
    }
}
