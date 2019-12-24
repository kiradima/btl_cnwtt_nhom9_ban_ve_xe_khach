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

    public User create(User entity) {
        return repository.save(entity);
    }

    public User findById(Long id) {
        return repository.findById(id).get();
    }

    public User update(User entity) {
        return repository.save(entity);
    }

    public void delete(Long id){
        User entity = findById(id);
        repository.delete(entity);
    }

    public User login(String username, String password) {
        List<User> users = findAllUser();
        for (User user : users) {
            if (user.getEmail().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
