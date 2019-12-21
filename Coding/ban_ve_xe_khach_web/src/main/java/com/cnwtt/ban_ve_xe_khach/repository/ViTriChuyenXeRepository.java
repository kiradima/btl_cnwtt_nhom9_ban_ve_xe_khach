package com.cnwtt.ban_ve_xe_khach.repository;


import com.cnwtt.ban_ve_xe_khach.entity.ChuyenXe;
import com.cnwtt.ban_ve_xe_khach.entity.ViTriChuyenXe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViTriChuyenXeRepository extends JpaRepository<ViTriChuyenXe, Long> {
    Page<ViTriChuyenXe> findAll(Pageable pageable);

    @Query("select vtcx from ViTriChuyenXe vtcx where " +
            " vtcx.idChuyenXe = :idChuyenXe and vtcx.type = :t order by vtcx.thoiDiemDuKien asc")
    List<ViTriChuyenXe> findByIdChuyenXeAndType(@Param("idChuyenXe") int idChuyenXe,
                                                @Param("t") int type);
}
