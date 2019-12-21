package com.cnwtt.ban_ve_xe_khach.service;

import com.cnwtt.ban_ve_xe_khach.entity.ThanhToan;
import com.cnwtt.ban_ve_xe_khach.repository.ThanhToanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThanhToanService {

    @Autowired
    private ThanhToanRepository repository;

    public Page<ThanhToan> getLists(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<ThanhToan> findAllVeXe() {
        return repository.findAll();
    }

    /**
     * Create
     *
     * @param entity
     * @return
     */
    public ThanhToan create(ThanhToan entity) {
        return repository.save(entity);
    }

    /**
     * Read
     *
     * @param id
     * @return
     */

    public ThanhToan findById(Long id) {
        return repository.findById(id).get();
    }

    /**
     * Update
     *
     * @param entity
     * @return
     */

    public ThanhToan update(ThanhToan entity){
        return repository.save(entity);
    }

    /**
     * Delete
     *
     * @param id
     * @return
     */

    public void delete(Long id){
        ThanhToan entity = findById(id);
        repository.delete(entity);
    }
}
