package net.togogo.service;

import net.togogo.bean.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> getNotice();
    int deleteNotice(Integer id);
    Notice getNoticeById(Integer id);
    int addNotice(Notice notice);
    int updateNotice(Notice notice);
    List<Notice> selectByName(String name);
    Notice selectByTime();
}
