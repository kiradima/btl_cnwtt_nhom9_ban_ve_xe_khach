package com.cnwtt.ban_ve_xe_khach.repository;

import com.cnwtt.ban_ve_xe_khach.entity.DanhGia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhGiaRepository extends JpaRepository<DanhGia, Long> {
    Page<DanhGia> findAll(Pageable pageable);

    List<DanhGia> findByIdChuyenXe(long idChuyenXe);

    @Query("select avg(dg.sao) from DanhGia dg where dg.idChuyenXe = :idChuyenXe")
    String star(@Param("idChuyenXe") int idChuyenXe);

    @Query("select count(dg.id) from DanhGia dg where dg.idChuyenXe = :idChuyenXe")
    int countComment(@Param("idChuyenXe") int idChuyenXe);
}
