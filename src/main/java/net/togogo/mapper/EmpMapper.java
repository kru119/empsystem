package net.togogo.mapper;

import net.togogo.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface EmpMapper {
    List<Emp> getEmp();
    int deleteEmp(Integer id);
    Emp getEmpById(Integer id);
    int addEmp(Emp emp);
    int updateEmp(Emp emp);
    List<Emp> selectByName(String name);


}
