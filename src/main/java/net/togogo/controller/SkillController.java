package net.togogo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.togogo.bean.Emp;
import net.togogo.bean.Skill;
import net.togogo.config.PaginationConstant;
import net.togogo.mapper.SkillMapper;
import net.togogo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SkillController {
    @Autowired
    private SkillService skillService;
    @GetMapping("/skilllist")
    public String list(Model model, @RequestParam(value="pageNum",defaultValue="1") Integer pageNum) {
        if(ObjectUtils.isEmpty(pageNum)) {
            pageNum = PaginationConstant.CURRENT_NUM;
        }
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);
        List<Skill> skilllist = skillService.getSkill();
        PageInfo<Skill> pageInfo=new PageInfo<>(skilllist);
        model.addAttribute("pageInfo",pageInfo);
        return "skill/listskill";
    }
    //跳转到添加页面
    @GetMapping("/skill")
    public String goAddPage(Model model) {
        return "skill/addskill";
    }

    @PostMapping("/skill")
    public String addEmp(Skill skill) {
        skillService.addSkill(skill);
        return "redirect:/skilllist";
    }

    @GetMapping("/skill/{id}")
    public String goUpdate(@PathVariable("id") Integer id, Model model) {
        Skill skill = skillService.getSkillById(id);
        model.addAttribute("skill",skill);
        return "skill/addskill";
    }

    @PutMapping("/skill")
    public String updateSkill(Skill skill) {
        skillService.updateSkill(skill);
        return "redirect:/skilllist";
    }

    @DeleteMapping("/skill/{id}")
    public String deleteSkillById(@PathVariable("id") Integer id){
        skillService.deleteSkill(id);
        return "redirect:/skilllist";
    }


    @PostMapping("/searchskill")
    public String queryEmp(@RequestParam String name, Model model,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum){
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);
        List<Skill> skilllist=skillService.selectByName(name);
        model.addAttribute("skilllist",skilllist);//传回前端
        PageInfo<Skill> pageInfo=new PageInfo<>(skilllist);
        model.addAttribute("pageInfo",pageInfo);
        return "skill/listskill";
    }
}
