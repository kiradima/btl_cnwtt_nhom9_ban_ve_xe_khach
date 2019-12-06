package com.cnwtt.ban_ve_xe_khach.repository;


import com.cnwtt.ban_ve_xe_khach.entity.NhaXe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaXeRepository extends JpaRepository<NhaXe, Integer> {
    Page<NhaXe> findAll(Pageable pageable);

}
