package model;

import java.sql.Timestamp;

public class Comments {
    private int id;
    private String content;
    private Timestamp date;
    private int blog_id;
    private String user_name;

    public Comments(int id, String content, Timestamp date, int blog_id, String user_name) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.blog_id = blog_id;
        this.user_name = user_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}