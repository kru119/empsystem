package net.togogo.service.impl;

import net.togogo.bean.User;
import net.togogo.mapper.UserMapper;
import net.togogo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
   @Override
    public User userlogin(User user) {
        return userMapper.userlogin(user);
    }
    @Override
    public User adminlogin(User user) {
        return userMapper.adminlogin(user);
    }
   @Override
    public void adduser(User user) {
        userMapper.adduser(user);
    }

}
