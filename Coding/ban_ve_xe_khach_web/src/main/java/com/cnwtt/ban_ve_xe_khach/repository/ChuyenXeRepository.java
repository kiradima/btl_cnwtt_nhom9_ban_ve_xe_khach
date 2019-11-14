package com.cnwtt.ban_ve_xe_khach.repository;

import com.cnwtt.ban_ve_xe_khach.entity.ChuyenXeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChuyenXeRepository extends JpaRepository<ChuyenXeEntity, Integer> {
    Page<ChuyenXeEntity> findAll (Pageable pageable);

}
