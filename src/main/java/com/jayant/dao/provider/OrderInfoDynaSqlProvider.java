package com.jayant.dao.provider;

import com.jayant.pojo.OrderInfo;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class OrderInfoDynaSqlProvider {
    public String selectWithParam(Map<String, Object> params) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM("order_info");
                if (params.get("orderInfo") != null) {
                    OrderInfo orderInfo = (OrderInfo) params.get("orderInfo");
                    if (orderInfo.getId() != null && !"".equals(orderInfo.getId())) {
                        WHERE("id=#{orderInfo.id}");
                    }
                    if (orderInfo.getStatus() != null && !"请选择".equals(orderInfo.getStatus())) {
                        WHERE("status = #{orderInfo.Status}");
                    }
                    if (orderInfo.getOrderTimeFrom() != null && !"".equals(orderInfo.getOrderTimeFrom())){
                        WHERE("ordertime>=#{orderInfo.orderTimeFrom}");
                    }
                    if (orderInfo.getOrderTimeTo() != null && !"".equals(orderInfo.getOrderTimeTo())){
                        WHERE("ordertime>=#{orderInfo.orderTimeTo}");
                    }
                    if (orderInfo.getUid()>0){
                        WHERE("uid=#{orderInfo.uid}");
                    }
                }
            }
        }.toString();
        if (params.get("pager") != null) {
            sql += "limit #{pager.firstLimitParam},#{pager.perPageRows}";
        }
        return sql;
    }
    public String count(Map<String, Object> params) {
         return new SQL() {
            {
                SELECT("*");
                FROM("order_info");
                if (params.get("orderInfo") != null) {
                    OrderInfo orderInfo = (OrderInfo) params.get("orderInfo");
                    if (orderInfo.getId() != null && !"".equals(orderInfo.getId())) {
                        WHERE("id=#{orderInfo.id}");
                    }
                    if (orderInfo.getStatus() != null && !"请选择".equals(orderInfo.getStatus())) {
                        WHERE("status = #{orderInfo.Status}");
                    }
                    if (orderInfo.getOrderTimeFrom() != null && !"".equals(orderInfo.getOrderTimeFrom())){
                        WHERE("ordertime>=#{orderInfo.orderTimeFrom}");
                    }
                    if (orderInfo.getOrderTimeTo() != null && !"".equals(orderInfo.getOrderTimeTo())){
                        WHERE("ordertime<#{orderInfo.orderTimeTo}");
                    }
                    if (orderInfo.getUid()>0){
                        WHERE("uid=#{orderInfo.uid}");
                    }
                }
            }
        }.toString();
    }
}
