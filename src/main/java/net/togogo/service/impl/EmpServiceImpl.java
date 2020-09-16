package net.togogo.service.impl;

import net.togogo.bean.Emp;
import net.togogo.mapper.EmpMapper;
import net.togogo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Emp> getEmp() {
        return empMapper.getEmp();
    }
    @Override
    public int deleteEmp(Integer id) {
        return empMapper.deleteEmp(id);
    }
    @Override
    public Emp getEmpById(Integer id){
        return empMapper.getEmpById(id);
    }
    @Override
    public int addEmp(Emp emp) {
        return empMapper.addEmp(emp);
    }
    @Override
    public int updateEmp(Emp emp) {
        return empMapper.updateEmp(emp);
    }
    @Override
    public List<Emp> selectByName(String name) {
        return empMapper.selectByName(name);
    }

}
