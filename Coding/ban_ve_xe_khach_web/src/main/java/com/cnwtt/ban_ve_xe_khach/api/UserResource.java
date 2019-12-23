package com.cnwtt.ban_ve_xe_khach.api;

import com.cnwtt.ban_ve_xe_khach.entity.User;
import com.cnwtt.ban_ve_xe_khach.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserResource {
    private static Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserService service;

    @PostMapping("/create")
    public ResponseEntity<User> save(@RequestBody User entity) {
        LOGGER.info("Call api create user");
        return ResponseEntity.ok(service.create(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable("id") Long id) {
        LOGGER.info("Call api get user: id[{}]", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User entity) {
        LOGGER.info("Call api update user");
        return ResponseEntity.ok(service.update(entity));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Call api delete user : id [{}]", id);
        service.delete(id);
    }

    @GetMapping("/list")
    public Page<User> list(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "size", defaultValue = "20") int size,
                           @RequestParam(value = "sort_by", defaultValue = "id") String sortField) {
        LOGGER.info("Call api list user");
        return service.getLists(PageRequest.of(page - 1, size, Sort.by(sortField)));
    }
}
