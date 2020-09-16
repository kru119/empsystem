package net.togogo.bean;

import java.util.Date;

public class Notice {
    private Integer id;
    private String title;
    private String content;
    private Date time;

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }

    public Notice() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Notice(Integer id, String title, String content, Date time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time = time;
    }
}
