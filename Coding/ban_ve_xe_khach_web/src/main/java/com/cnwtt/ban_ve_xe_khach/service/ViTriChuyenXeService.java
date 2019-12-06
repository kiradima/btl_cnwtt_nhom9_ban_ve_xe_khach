package com.cnwtt.ban_ve_xe_khach.service;


import com.cnwtt.ban_ve_xe_khach.entity.ViTriChuyenXe;
import com.cnwtt.ban_ve_xe_khach.repository.ViTriChuyenXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViTriChuyenXeService {

    @Autowired
    private ViTriChuyenXeRepository repository;

    public Page<ViTriChuyenXe> getLists(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<ViTriChuyenXe> findAllViTriChuyenXe() {
        return repository.findAll();
    }

    /**
     * Create
     *
     * @param entity
     * @return
     */
    public ViTriChuyenXe create(ViTriChuyenXe entity) {
        return repository.save(entity);
    }

    /**
     * Read
     *
     * @param id
     * @return
     */

    public ViTriChuyenXe findById(Integer id) {
        return repository.findById(id).get();
    }

    /**
     * Update
     *
     * @param entity
     * @return
     */

    public ViTriChuyenXe update(ViTriChuyenXe entity) {
        return repository.save(entity);
    }

    /**
     * Delete
     *
     * @param id
     * @return
     */

    public void delete(Integer id) {
        ViTriChuyenXe entity = findById(id);
        repository.delete(entity);
    }

}
