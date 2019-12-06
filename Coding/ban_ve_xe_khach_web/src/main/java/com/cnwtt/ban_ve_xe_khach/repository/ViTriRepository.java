package com.cnwtt.ban_ve_xe_khach.repository;

import com.cnwtt.ban_ve_xe_khach.entity.ViTri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViTriRepository extends JpaRepository<ViTri, Long> {

}
