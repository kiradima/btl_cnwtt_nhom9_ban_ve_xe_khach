package com.cnwtt.ban_ve_xe_khach.service;


import com.cnwtt.ban_ve_xe_khach.entity.DanhGia;
import com.cnwtt.ban_ve_xe_khach.repository.DanhGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhGiaService {

    @Autowired
    private DanhGiaRepository repository;

    public Page<DanhGia> getLists(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<DanhGia> findAllDanhGia() {
        return repository.findAll();
    }

    /**
     * Create
     *
     * @param entity
     * @return
     */
    public DanhGia create(DanhGia entity) {
        return repository.save(entity);
    }

    /**
     * Read
     *
     * @param id
     * @return
     */

    public DanhGia findById(Long id) {
        return repository.findById(id).get();
    }

    /**
     * Update
     *
     * @param entity
     * @return
     */

    public DanhGia update(DanhGia entity){
        return repository.save(entity);
    }

    /**
     * Delete
     *
     * @param id
     * @return
     */

    public void delete(Long id){
        DanhGia entity = findById(id);
        repository.delete(entity);
    }

}
