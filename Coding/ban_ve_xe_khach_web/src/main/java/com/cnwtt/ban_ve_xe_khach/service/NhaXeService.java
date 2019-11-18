package com.cnwtt.ban_ve_xe_khach.service;

import com.cnwtt.ban_ve_xe_khach.entity.NhaXe;
import com.cnwtt.ban_ve_xe_khach.repository.NhaXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhaXeService {

    @Autowired
    private NhaXeRepository repository;

    public Page<NhaXe> getLists(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<NhaXe> findAllNhaXe() {
        return repository.findAll();
    }

    /**
     * Create
     *
     * @param entity
     * @return
     */
    public NhaXe create(NhaXe entity) {
        return repository.save(entity);
    }

    /**
     * Read
     *
     * @param id
     * @return
     */

    public NhaXe findById(Integer id) {
        return repository.findById(id).get();
    }

    /**
     * Update
     *
     * @param entity
     * @return
     */

    public NhaXe update(NhaXe entity){
        return repository.save(entity);
    }

    /**
     * Delete
     *
     * @param id
     * @return
     */

    public void delete(Integer id){
        NhaXe entity = findById(id);
        repository.delete(entity);
    }

}
