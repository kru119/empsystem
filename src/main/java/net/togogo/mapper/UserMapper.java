package net.togogo.mapper;

import net.togogo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User userlogin(User user);
    User adminlogin(User user);
    void adduser(User user);
}
