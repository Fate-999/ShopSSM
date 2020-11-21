package com.jayant.service;

import com.jayant.pojo.Pager;
import com.jayant.pojo.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoService {
    public List<UserInfo> getValidUser();

    public UserInfo getUserInfoById(int id);

    List<UserInfo> findUserInfo(UserInfo userInfo, Pager pager);

    Integer count(Map<String, Object> params);

    void modifyUserStatus(String ids,int flag);
}
