package com.jayant.service;

import com.jayant.pojo.Pager;
import com.jayant.pojo.ProductInfo;

import java.util.List;
import java.util.Map;

public interface ProductInfoService {
    List<ProductInfo> findProductInfo (ProductInfo productInfo, Pager pager);

    Integer  cont(Map<String,Object> params);

    public void addProductInfo (ProductInfo pi);

    public void modifyProductInfo(ProductInfo pi);

    void modifyStatus (String ids,int flag);

    List<ProductInfo> getOnSaleProduct();

    ProductInfo getProductInfoById(int id);
}
