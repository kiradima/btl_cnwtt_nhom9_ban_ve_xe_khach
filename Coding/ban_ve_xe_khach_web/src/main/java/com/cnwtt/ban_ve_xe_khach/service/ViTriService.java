package com.cnwtt.ban_ve_xe_khach.service;

import com.cnwtt.ban_ve_xe_khach.entity.ViTri;
import com.cnwtt.ban_ve_xe_khach.repository.ViTriRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViTriService {
    @Autowired
    private ViTriRepository repository;

    private Logger LOGGER = LoggerFactory.getLogger(ViTriService.class);

    public Page<ViTri> getLists(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<ViTri> findAll(){
        return repository.findAll();
    }

    /**
     * Create
     *
     * @param entity
     * @return
     */
    public ViTri create(ViTri entity) {
        return repository.save(entity);
    }

    /**
     * Read
     *
     * @param id
     * @return
     */

    public ViTri findById(Long id) {
        return repository.findById(id).get();
    }

    /**
     * Update
     *
     * @param entity
     * @return
     */

    public ViTri update(ViTri entity){
        return repository.save(entity);
    }

    /**
     * Delete
     *
     * @param id
     * @return
     */

    public void delete(Long id){
        ViTri entity = findById(id);
        repository.delete(entity);
    }
}
