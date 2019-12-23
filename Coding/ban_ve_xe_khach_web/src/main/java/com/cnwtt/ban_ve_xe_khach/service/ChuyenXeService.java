package com.cnwtt.ban_ve_xe_khach.service;

import com.cnwtt.ban_ve_xe_khach.entity.ChuyenXe;
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

    public Page<ChuyenXe> getLists(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<ChuyenXe> findAll() {
        return repository.findAll();
    }

    public ChuyenXe create(ChuyenXe entity) {
        return repository.save(entity);
    }

    public ChuyenXe findById(Long id) {
        return repository.findById(id).get();
    }

    public ChuyenXe update(ChuyenXe entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        ChuyenXe entity = findById(id);
        repository.delete(entity);
    }

    public List<ChuyenXe> search(String diemXuatPhat,
                                 String diemDung,
                                 String ngayXuatPhat) {
        return repository.search(diemXuatPhat, diemDung, ngayXuatPhat);
    }
}
