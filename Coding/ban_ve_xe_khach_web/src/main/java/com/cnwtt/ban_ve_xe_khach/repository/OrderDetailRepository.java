package com.cnwtt.ban_ve_xe_khach.repository;

import com.cnwtt.ban_ve_xe_khach.entity.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    Page<OrderDetail> findAll(Pageable pageable);

}
