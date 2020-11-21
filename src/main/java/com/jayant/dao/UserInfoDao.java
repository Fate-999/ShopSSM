package com.jayant.dao;

import com.jayant.dao.provider.UserInfoDynaSqlProvider;
import com.jayant.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserInfoDao {

    @Select("select * from user_info where status=1")
    public List<UserInfo> getValidUser();

    @Select("select * from user_info where id=#{id}")
    public UserInfo getUserInfoById(int id);

    @SelectProvider(type = UserInfoDynaSqlProvider.class,method = "selectWithParam")
    List<UserInfo> selectByPage(Map<String, Object>params);

    @SelectProvider(type = UserInfoDynaSqlProvider.class,method = "count")
    Integer count(Map<String, Object> params);

    @Update("update user_info set status=#{flag} where id in (${ids})")
    void updateStatus(@Param("ids") String ids,@Param("flag") int flag);
}
