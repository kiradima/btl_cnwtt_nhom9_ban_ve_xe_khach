package com.cnwtt.ban_ve_xe_khach.repository;

import com.cnwtt.ban_ve_xe_khach.entity.ViTriChuyenXe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViTriChuyenXeRepository extends JpaRepository<ViTriChuyenXe, Integer> {
    Page<ViTriChuyenXe> findAll(Pageable pageable);

}
