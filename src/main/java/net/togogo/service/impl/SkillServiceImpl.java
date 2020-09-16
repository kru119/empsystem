package net.togogo.service.impl;

import net.togogo.bean.Emp;
import net.togogo.bean.Skill;
import net.togogo.mapper.SkillMapper;
import net.togogo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    private SkillMapper skillMapper;
    @Override
    public List<Skill> getSkill(){
        return skillMapper.getSkill();
    }
    @Override
    public int deleteSkill(Integer id){
        return skillMapper.deleteSkill(id);
    }
    @Override
    public Skill getSkillById(Integer id){
        return skillMapper.getSkillById(id);
    }
    @Override
    public int addSkill(Skill skill){
        return skillMapper.addSkill(skill);
    }
    @Override
    public int updateSkill(Skill skill){
        return skillMapper.updateSkill(skill);
    }
    @Override
    public List<Skill> selectByName(String name){
        return skillMapper.selectByName(name);
    }
}
