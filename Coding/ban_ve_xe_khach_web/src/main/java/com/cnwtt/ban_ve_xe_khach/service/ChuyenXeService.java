package com.cnwtt.ban_ve_xe_khach.service;

import com.cnwtt.ban_ve_xe_khach.entity.ChuyenXeEntity;
import com.cnwtt.ban_ve_xe_khach.repository.ChuyenXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuyenXeService {

    @Autowired
    private ChuyenXeRepository repository;

    public Page<ChuyenXeEntity> getLists(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<ChuyenXeEntity> findAllChuyenXe() {
        return repository.findAll();
    }

    /**
     * Create
     *
     * @param entity
     * @return
     */
    public ChuyenXeEntity create(ChuyenXeEntity entity) {
        return repository.save(entity);
    }

    /**
     * Read
     *
     * @param id
     * @return
     */

    public ChuyenXeEntity findById(Integer id) {
        return repository.findById(id).get();
    }

    /**
     * Update
     *
     * @param entity
     * @return
     */

    public ChuyenXeEntity update(ChuyenXeEntity entity){
        return repository.save(entity);
    }

    /**
     * Delete
     *
     * @param id
     * @return
     */

    public void delete(Integer id){
        ChuyenXeEntity entity = findById(id);
        repository.delete(entity);
    }

}
