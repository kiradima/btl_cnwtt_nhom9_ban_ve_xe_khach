package com.cnwtt.ban_ve_xe_khach.service;


import com.cnwtt.ban_ve_xe_khach.entity.VeXe;
import com.cnwtt.ban_ve_xe_khach.repository.VeXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeXeService {

    @Autowired
    private VeXeRepository repository;

    public Page<VeXe> getLists(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<VeXe> findAllVeXe() {
        return repository.findAll();
    }

    public VeXe create(VeXe entity) {
        return repository.save(entity);
    }

    public VeXe findById(int id) {
        return repository.findById(id);
    }

    public VeXe update(VeXe entity) {
        return repository.save(entity);
    }

    public void delete(int id) {
        VeXe entity = findById(id);
        repository.delete(entity);
    }

    public List<VeXe> getVeXesByIdChuyenXe(int idChuyenXe) {
        return repository.findByIdChuyenXe(idChuyenXe);
    }

}
