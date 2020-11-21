package com.jayant.dao;

import com.jayant.pojo.Type;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.List;

public interface TypeDao {
    //    查询全部
    @Select("select * from type")
    public List<Type> selectAll();

    //     通过id查询
    @Select("select * from type where id=#{id}")
    Type selectById(int id);

    //    插入数据
    @Insert("insert into type(name) values(#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int add(Type type);

    //更新数据
    @Update("update type set name=#{name} where id =#{id}")
    public int update(Type type);
}
