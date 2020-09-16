package net.togogo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.togogo.bean.Emp;
import net.togogo.bean.Notice;
import net.togogo.config.PaginationConstant;
import net.togogo.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class NoticeController {
    @Autowired
    NoticeService noticeService;
    @GetMapping("/noticelist")
    public String list(Model model, @RequestParam(value="pageNum",defaultValue="1") Integer pageNum) {
        if(ObjectUtils.isEmpty(pageNum)) {
            pageNum = PaginationConstant.CURRENT_NUM;
        }
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);
        List<Notice> noticelist = noticeService.getNotice();
        PageInfo<Notice> pageInfo=new PageInfo<>(noticelist);
        model.addAttribute("pageInfo",pageInfo);
        return "notice/listnotice";
    }
    //跳转到添加页面
    @GetMapping("/notice")
    public String goAddPage(Model model) {
        return "notice/addnotice";
    }

    @PostMapping("/notice")
    public String addNotice(Notice notice) {
        noticeService.addNotice(notice);
        return "redirect:/noticelist";
    }

    @GetMapping("/notice/{id}")
    public String goUpdate(@PathVariable("id") Integer id, Model model) {
        Notice notice = noticeService.getNoticeById(id);
        model.addAttribute("notice",notice);
        return "notice/addnotice";
    }

    @PutMapping("/notice")
    public String updateNotice(Notice notice) {
        noticeService.updateNotice(notice);
        return "redirect:/noticelist";
    }

    @DeleteMapping("/notice/{id}")
    public String deleteEmpById(@PathVariable("id") Integer id){
        noticeService.deleteNotice(id);
        return "redirect:/noticelist";
    }


    @PostMapping("/select")
    public String queryEmp(@RequestParam String name, Model model,@RequestParam(value="pageNum",defaultValue="1")Integer pageNum){
        PageHelper.startPage(pageNum, PaginationConstant.PAGE_SIZE);
        List<Notice> noticelist=noticeService.selectByName(name);
        model.addAttribute("noticelist",noticelist);//传回前端
        PageInfo<Notice> pageInfo=new PageInfo<>(noticelist);
        model.addAttribute("pageInfo",pageInfo);
        return "notice/listnotice";
    }
    @GetMapping("dmain.html")
    public String getcontent(Model model) {
        Notice notice = noticeService.selectByTime();
        model.addAttribute("notice",notice);
        return "admin.html";
    }
    @GetMapping("umain.html")
    public String getcontenttwo(Model model) {
        Notice notice = noticeService.selectByTime();
        model.addAttribute("notice",notice);
        return "user.html";
    }

}
