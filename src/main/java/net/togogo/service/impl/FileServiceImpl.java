package net.togogo.service.impl;
import net.togogo.bean.Data;

import net.togogo.mapper.FileMapper;
import net.togogo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FileServiceImpl implements FileService {
    @Autowired
    private FileMapper fileMapper;
    @Override
    public List<Data> getAll() {
        return fileMapper.getAll();
    }
    @Override
    public int add(String name) {
        return fileMapper.add(name);
    }
    @Override
    public String selectById(Integer id) {
        return fileMapper.selectById(id);
    }

}
