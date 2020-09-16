package net.togogo.controller;

import net.togogo.bean.Notice;
import net.togogo.bean.User;
import net.togogo.service.NoticeService;
import net.togogo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private NoticeService noticeService;
     @PostMapping(value = "/user/login")
    public String login(User user, Map<String, Object> map, HttpSession session, Model model){
        User u = userService.userlogin(user);
        User a = userService.adminlogin(user);
        if (u==null&&a!=null){
            session.setAttribute("loginUser","success");
            return "redirect:/dmain.html";
        } else if(u!=null&&a==null){
            session.setAttribute("loginUser","success");
            return "redirect:/umain.html";
        } else {
            map.put("msg","用户或密码错误");
            return "login";
        }
    }
    @GetMapping(value = "/goregist")
    public String goregist() {
         return "regist";
    }
    @GetMapping(value = "/gologin")
    public String gologin() {
        return "login";
    }
    @RequestMapping(value = "/user/regist")
    public String regist(User user, Map<String, Object> map, HttpSession session) {
        userService.adduser(user);
        map.put("rgmsg","注册成功");
        return "regist";
    }
    @GetMapping(value = "/logout")
    public String logout(){
        return "login";
    }



}
