package net.togogo.service.impl;

import net.togogo.bean.Notice;
import net.togogo.mapper.NoticeMapper;
import net.togogo.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public List<Notice> getNotice() {
        return noticeMapper.getNotice();
    }
    @Override
    public int deleteNotice(Integer id) {
        return noticeMapper.deleteNotice(id);
    }
    @Override
    public Notice getNoticeById(Integer id){
        return noticeMapper.getNoticeById(id);
    }
    @Override
    public int addNotice(Notice notice) {
        return noticeMapper.addNotice(notice);
    }
    @Override
    public int updateNotice(Notice notice){
        return noticeMapper.updateNotice(notice);
    }
    @Override
    public List<Notice> selectByName(String name){
        return noticeMapper.selectByName(name);
    }
    @Override
    public Notice selectByTime(){
        return noticeMapper.selectByTime();
    }
}
