package com.cnwtt.ban_ve_xe_khach.repository;


import com.cnwtt.ban_ve_xe_khach.entity.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    Page<OrderDetail> findAll(Pageable pageable);

    @Query("select count(vx.id) from OrderDetail od, VeXe vx, ChuyenXe cx where od.idVe = vx.id" +
            " and cx.id = vx.idChuyenXe")
    long count();

    @Query("SELECT vx.viTriGhe FROM OrderDetail od, VeXe vx " +
            "where od.idVe = vx.id " +
            "and vx.idChuyenXe = :idChuyenXe")
    List<String> getListViTriGheOrderedByIdChuyenXe(@Param("idChuyenXe") int idChuyenXe);
}
