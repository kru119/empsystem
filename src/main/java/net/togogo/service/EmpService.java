package net.togogo.service;

import net.togogo.bean.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> getEmp();
    int deleteEmp(Integer id);
    Emp getEmpById(Integer id);
    int addEmp(Emp emp);
    int updateEmp(Emp emp);
    List<Emp> selectByName(String name);
}
