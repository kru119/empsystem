package net.togogo.service;

import net.togogo.bean.Emp;
import net.togogo.bean.Skill;

import java.util.List;

public interface SkillService {
    List<Skill> getSkill();
    int deleteSkill(Integer id);
    Skill getSkillById(Integer id);
    int addSkill(Skill skill);
    int updateSkill(Skill skill);
    List<Skill> selectByName(String name);
}
