package com.jayant.service;

import com.jayant.pojo.AdminInfo;

public interface AdminInfoService {
    public AdminInfo login(AdminInfo ai);
    public AdminInfo getAdminInfoAndFunctions(Integer id);
}
