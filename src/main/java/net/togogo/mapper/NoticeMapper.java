package net.togogo.mapper;


import net.togogo.bean.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NoticeMapper {
    List<Notice> getNotice();
    int deleteNotice(Integer id);
    Notice getNoticeById(Integer id);
    int addNotice(Notice notice);
    int updateNotice(Notice notice);
    List<Notice> selectByName(String name);
    Notice selectByTime();

}
