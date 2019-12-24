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

    final
    DanhGiaRepository repository;

    public DanhGiaService(DanhGiaRepository repository) {
        this.repository = repository;
    }

    public Page<DanhGia> getLists(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<DanhGia> findAllDanhGia() {
        return repository.findAll();
    }

    public DanhGia create(DanhGia entity) {
        return repository.save(entity);
    }

    public DanhGia findById(Long id) {
        return repository.findById(id).get();
    }

    public DanhGia update(DanhGia entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        DanhGia entity = findById(id);
        repository.delete(entity);
    }

    public List<DanhGia> findByIdChuyenXe(long idChuyenXe) {
        return repository.findByIdChuyenXe(idChuyenXe);
    }

    public String star(int idChuyenXe) {
        return repository.star(idChuyenXe);
    }

    public int countComment(int idChuyenXe) {
        return repository.countComment(idChuyenXe);
    }

}
