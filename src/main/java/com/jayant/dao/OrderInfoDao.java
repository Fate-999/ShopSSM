package com.jayant.dao;

import com.jayant.dao.provider.OrderInfoDynaSqlProvider;
import com.jayant.pojo.OrderDetail;
import com.jayant.pojo.OrderInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

public interface OrderInfoDao {
    @Results({@Result(column = "uid", property = "ui", one = @One(select = "com.jayant.dao.UserInfoDao.getUserInfoById", fetchType = FetchType.EAGER))})
    @SelectProvider(type = OrderInfoDynaSqlProvider.class, method = "selectWithParam")
    List<OrderInfo> selectByPage(Map<String, Object> params);

    @SelectProvider(type = OrderInfoDynaSqlProvider.class,method = "count")
    Integer count(Map<String, Object> params);

    @Insert("insert into order_info(uid, status, ordertime, orderprice) values (#{uid},#{status},#{ordertime},#{orderprice})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int saveOrderInfo(OrderInfo oi);

    @Insert("insert into order_detail (oid, pid, num) values (#{oid}, #{pid}, #{num})")
    @Options(useGeneratedKeys = true,keyProperty="id")
    int saveOrderDetail(OrderDetail od);

    @Results({@Result(column = "uid" ,property = "ui",one = @One(select = "com.jayant.dao.UserInfoDao.getUserInfoById",fetchType = FetchType.EAGER))})
    @Select("select * from order_info where id =#{id}")
    public OrderInfo getOrderInfoById(int id);

    @Results({@Result(column = "pid",property = "pi",one = @One(select = "com.jayant.dao.ProductInfoDao.getProductInfoById",fetchType = FetchType.EAGER))})
    @Select("select * from order_detail where oid =#{oid}")
    public List<OrderDetail> getOrderDetailByOid(int oid);

    @Delete("delete from order_info where id=#{id}")
    public int deleteOrderInfo(int id);

    @Delete("delete from order_detail where oid=#{id} ")
    public int deleteOrderDetail(int id);
}
