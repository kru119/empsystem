package net.togogo.mapper;

import net.togogo.bean.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FileMapper {
    List<Data> getAll();
    int add(String name);
    String selectById(Integer id);
}
