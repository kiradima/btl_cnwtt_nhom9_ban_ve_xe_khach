package com.cnwtt.ban_ve_xe_khach.repository;

import com.cnwtt.ban_ve_xe_khach.entity.ChuyenXeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChuyenXeRepository extends JpaRepository<ChuyenXeEntity, Integer> {
    Page<ChuyenXeEntity> findAll (Pageable pageable);

//    List<ChuyenXeEntity> findAllByDiemXuatPhatAndDiemKetThucAndGioXuatPhat (String diemXuatPhat, String diemKetThuc, )
}
