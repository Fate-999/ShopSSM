package com.jayant.service;

import com.jayant.pojo.Type;

import java.util.List;

public interface TypeService {

    public List<Type> getAll();

    public int addType(Type type);

    public void updateType(Type type);
}
