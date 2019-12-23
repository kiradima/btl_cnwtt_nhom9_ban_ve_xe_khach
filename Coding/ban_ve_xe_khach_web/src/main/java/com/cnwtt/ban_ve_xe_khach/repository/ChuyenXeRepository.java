package com.cnwtt.ban_ve_xe_khach.repository;

import com.cnwtt.ban_ve_xe_khach.entity.ChuyenXe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChuyenXeRepository extends JpaRepository<ChuyenXe, Long> {
    Page<ChuyenXe> findAll(Pageable pageable);

    @Query("select distinct cx from ChuyenXe cx, ViTri vt1, ViTri vt2, ViTriChuyenXe vtcx1, ViTriChuyenXe vtcx2\n" +
            "where cx.id = vtcx1.idChuyenXe\n" +
            "and cx.id = vtcx2.idChuyenXe\n" +
            "and vt1.id = vtcx1.idViTri\n" +
            "and vt2.id = vtcx2.idViTri\n" +
            "and vt1.tinh = :diemXuatPhat\n" +
            "and vt2.tinh = :diemDung\n" +
            "and vtcx1.thoiDiemDuKien like :ngayXuatPhat%")
    List<ChuyenXe> search(
            @Param("diemXuatPhat") String diemXuatPhat,
            @Param("diemDung") String diemDung,
            @Param("ngayXuatPhat") String ngayXuatPhat
    );
}
