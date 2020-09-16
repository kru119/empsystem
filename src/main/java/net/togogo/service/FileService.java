package net.togogo.service;

import net.togogo.bean.Data;

import java.util.List;

public interface FileService {
    List<Data> getAll();
    int add(String name);
    String selectById(Integer id);
}
