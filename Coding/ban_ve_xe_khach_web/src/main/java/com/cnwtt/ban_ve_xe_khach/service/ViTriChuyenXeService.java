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

    public ViTriChuyenXe create(ViTriChuyenXe entity) {
        return repository.save(entity);
    }

    public ViTriChuyenXe findById(Long id) {
        return repository.findById(id).get();
    }

    public ViTriChuyenXe update(ViTriChuyenXe entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        ViTriChuyenXe entity = findById(id);
        repository.delete(entity);
    }

    public List<ViTriChuyenXe> findByIdChuyenXeAndType(int idChuyenXe, int type) {
        return repository.findByIdChuyenXeAndType(idChuyenXe, type);
    }

}
