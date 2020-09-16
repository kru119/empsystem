package net.togogo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.togogo.bean.Emp;
import net.togogo.config.PaginationConstant;
import net.togogo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class EmpController {
    @Autowired
    EmpService empService;
//查询
    @GetMapping("/emplist")
    public String list(Model model, @RequestParam(value="pageNum",defaultValue="1") Integer pageNum) {
        if(ObjectUtils.isEmpty(pageNum)) {
            pageNum = PaginationConstant.CURRENT_NUM;
        }
            PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);
            List<Emp> emplist = empService.getEmp();
            PageInfo<Emp> pageInfo=new PageInfo<>(emplist);
            model.addAttribute("pageInfo",pageInfo);
            return "emp/listemp";
    }
    //跳转到添加页面
    @GetMapping("/emp")
    public String goAddPage(Model model) {
        return "emp/addemp";
    }

    @PostMapping("/emp")
    public String addEmp(Emp emp) {
        empService.addEmp(emp);
        return "redirect:/emplist";
    }

    @GetMapping("/emp/{id}")
    public String goUpdate(@PathVariable("id") Integer id, Model model) {
        Emp emp = empService.getEmpById(id);
        model.addAttribute("emp",emp);
        return "emp/addemp";
    }

    @PutMapping("/emp")
    public String updateEmp(Emp emp) {
        empService.updateEmp(emp);
        return "redirect:/emplist";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmpById(@PathVariable("id") Integer id){
        empService.deleteEmp(id);
        return "redirect:/emplist";
    }


    @PostMapping("/search")
    public String queryEmp(@RequestParam String name, Model model,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum){
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);
        List<Emp> emplist=empService.selectByName(name);
        model.addAttribute("emplist",emplist);//传回前端
        PageInfo<Emp> pageInfo=new PageInfo<>(emplist);
        model.addAttribute("pageInfo",pageInfo);
        return "emp/listemp";
    }

}
