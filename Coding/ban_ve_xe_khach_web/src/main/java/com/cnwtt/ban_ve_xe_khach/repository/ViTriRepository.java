package com.cnwtt.ban_ve_xe_khach.repository;

import com.cnwtt.ban_ve_xe_khach.entity.ViTri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViTriRepository extends JpaRepository<ViTri, Long> {

    @Query("select distinct vt.tinh from ViTri vt")
    List<String> getAllTinhs();
}
