package com.jayant.dao;

import com.jayant.pojo.Functions;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FunctionDao {
    @Select("select * from functions where id in (select fid from powers where aid =#{aid})")
    public List<Functions> selectByAdminId(Integer id);
}
