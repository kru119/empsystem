package net.togogo.mapper;

import net.togogo.bean.Emp;
import net.togogo.bean.Skill;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SkillMapper {
    List<Skill> getSkill();
    int deleteSkill(Integer id);
    Skill getSkillById(Integer id);
    int addSkill(Skill skill);
    int updateSkill(Skill skill);
    List<Skill> selectByName(String name);
}
