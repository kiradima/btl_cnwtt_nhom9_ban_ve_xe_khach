package com.cnwtt.ban_ve_xe_khach.service;


import com.cnwtt.ban_ve_xe_khach.entity.User;
import com.cnwtt.ban_ve_xe_khach.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Page<User> getLists(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<User> findAllUser() {
        return repository.findAll();
    }

    /**
     * Create
     *
     * @param entity
     * @return
     */
    public User create(User entity) {
        return repository.save(entity);
    }

    /**
     * Read
     *
     * @param id
     * @return
     */

    public User findById(Long id) {
        return repository.findById(id).get();
    }

    /**
     * Update
     *
     * @param entity
     * @return
     */

    public User update(User entity){
        return repository.save(entity);
    }

    /**
     * Delete
     *
     * @param id
     * @return
     */

    public void delete(Long id){
        User entity = findById(id);
        repository.delete(entity);
    }

}
