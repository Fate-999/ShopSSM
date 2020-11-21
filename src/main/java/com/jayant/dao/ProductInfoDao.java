package com.jayant.dao;

import com.jayant.dao.provider.ProductInfoDynaSqlProvider;
import com.jayant.pojo.ProductInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

public interface ProductInfoDao {
    @Results({@Result(id = true,column = "id",property = "id"),
              @Result(column = "code",property = "code"),
              @Result(column = "name",property = "name"),
              @Result(column = "brand",property = "brand"),
              @Result(column = "pic",property = "pic"),
              @Result(column = "num",property = "num"),
              @Result(column = "price",property = "price"),
              @Result(column = "intro",property = "intro"),
              @Result(column = "status",property = "status"),
              @Result(column = "tid",property = "type",one = @One(select = "com.jayant.dao.TypeDao.selectById",fetchType = FetchType.EAGER))
    })
    @SelectProvider(type = ProductInfoDynaSqlProvider.class,method = "selectWithParam")
    List<ProductInfo> selectByPage(Map<String, Object> params);

    @SelectProvider(type = ProductInfoDynaSqlProvider.class,method ="count")
    Integer count(Map<String, Object> params);

    @Insert("insert into product_info (code, name, tid, brand, pic, num, price, intro, status)"+
            "values (#{code}, #{name}, #{tid}, #{brand}, #{pic}, #{num}, #{price}, #{intro}, #{status})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void save(ProductInfo pi);

    @Update("update product_info set code=#{code},name=#{name},tid=#{type.id},"+
            "brand=#{brand},pic=#{pic},num=#{num} price=#{price},intro=#{intro},"+
            "status=#{status}, where id=#{id}")
    void edit(ProductInfo pi);

    @Update("update product_info set status=#{flag} where id in (${ids})")
    void updateStatus(@Param("ids") String ids,@Param("flag") int flag);

    @Select("select * from product_info where status=1")
    List<ProductInfo> getOnSaleProduct();

    @Select("select * from product_info where id=#{id}")
    ProductInfo getProductInfoById(int id);
}
