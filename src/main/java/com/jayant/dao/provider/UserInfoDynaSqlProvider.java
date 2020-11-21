package com.jayant.dao.provider;

import com.jayant.pojo.UserInfo;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class UserInfoDynaSqlProvider {
    public String selectWithParam(Map<String, Object> params) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM("user_info");
                if (params.get("user_info") != null) {
                    UserInfo userInfo = (UserInfo) params.get("user_info");
                    if (userInfo.getUsername() != null && !userInfo.getUsername().equals("")) {
                        WHERE("username LIKE CONCAT('%',#{userInfo.username},'%')");
                    }
                }
            }
        }.toString();
        if (params.get("pager") != null) {
            sql += "limit #{pager.firstLimitParam},#{paper.perPageRows}";
        }
        return sql;
    }

    public String count(Map<String, Object> params) {
        return new SQL() {
            {
                SELECT("count(*)");
                FROM("user_info");
                if (params.get("user_info") != null) {
                    UserInfo userInfo = (UserInfo) params.get("user_info");
                    if (userInfo.getUsername() != null && !userInfo.getUsername().equals("")) {
                        WHERE("username LIKE CONCAT('%',#{userInfo.username},'%')");
                    }
                }
            }
        }.toString();
    }
}
