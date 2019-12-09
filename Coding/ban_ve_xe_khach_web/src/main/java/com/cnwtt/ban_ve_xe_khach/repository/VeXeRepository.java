package com.cnwtt.ban_ve_xe_khach.repository;


import com.cnwtt.ban_ve_xe_khach.entity.VeXe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeXeRepository extends JpaRepository<VeXe, Long> {
    Page<VeXe> findAll(Pageable pageable);

}
