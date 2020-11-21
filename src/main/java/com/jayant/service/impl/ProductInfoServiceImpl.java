package com.jayant.service.impl;

import com.jayant.dao.ProductInfoDao;
import com.jayant.pojo.Pager;
import com.jayant.pojo.ProductInfo;
import com.jayant.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("productInfoService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    ProductInfoDao productInfoDao;
    @Override
    public List<ProductInfo> findProductInfo(ProductInfo productInfo, Pager pager) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("productInfo",productInfo);
        int recodeCount = productInfoDao.count(params);
        pager.setRowCount(recodeCount);
        if (recodeCount>0){
            params.put("pager",pager);
        }
        return productInfoDao.selectByPage(params);
    }

    @Override
    public Integer cont(Map<String, Object> params) {
        return productInfoDao.count(params);
    }

    @Override
    public void addProductInfo(ProductInfo pi) {
        productInfoDao.save(pi);
    }

    @Override
    public void modifyProductInfo(ProductInfo pi) {
        productInfoDao.edit(pi);
    }

    @Override
    public void modifyStatus(String ids, int flag) {
        productInfoDao.updateStatus(ids, flag);
    }

    @Override
    public List<ProductInfo> getOnSaleProduct() {
        return productInfoDao.getOnSaleProduct();
    }

    @Override
    public ProductInfo getProductInfoById(int id) {
        return productInfoDao.getProductInfoById(id);
    }
}
