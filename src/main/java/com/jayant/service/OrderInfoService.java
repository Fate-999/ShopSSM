package com.jayant.service;

import com.jayant.pojo.OrderDetail;
import com.jayant.pojo.OrderInfo;
import com.jayant.pojo.Pager;

import java.util.List;
import java.util.Map;

public interface OrderInfoService {

    List<OrderInfo> findOrderInfo(OrderInfo orderInfo, Pager pager);

    Integer count(Map<String, Object> params);

    public int addOrderInfo(OrderInfo oi);

    public int addOrderDetail(OrderDetail od);

    public OrderInfo getOrderInfoById(int id);

    public List<OrderDetail> getOrderDetailByOid (int oid);

    public int deleteOrder(int id);
}
