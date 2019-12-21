package com.cnwtt.ban_ve_xe_khach.service;


import com.cnwtt.ban_ve_xe_khach.entity.OrderDetail;
import com.cnwtt.ban_ve_xe_khach.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository repository;

    public Page<OrderDetail> getLists(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<OrderDetail> findAllOrderDetail() {
        return repository.findAll();
    }

    public OrderDetail create(OrderDetail entity) {
        return repository.save(entity);
    }

    public OrderDetail findById(Long id) {
        return repository.findById(id).get();
    }

    public OrderDetail update(OrderDetail entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        OrderDetail entity = findById(id);
        repository.delete(entity);
    }

    public long count() {
        return repository.count();
    }

    public List<String> getListViTriGheOrderedByIdChuyenXe(int idChuyenXe) {
        return repository.getListViTriGheOrderedByIdChuyenXe(idChuyenXe);
    }

}
