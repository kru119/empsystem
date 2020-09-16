package net.togogo.service;

import net.togogo.bean.User;

public interface UserService {
    User userlogin(User user);
    User adminlogin(User user);
    void adduser(User user);
}
