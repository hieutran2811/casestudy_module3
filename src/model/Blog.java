package model;

import java.sql.Timestamp;

public class Blog {
    private int id;
    private String name;
    private String contentBlog;
    private Timestamp date;
    private int user_id;

    public Blog(int id, String name, String contentBlog, Timestamp date, int user_id) {
        this.id = id;
        this.name = name;
        this.contentBlog = contentBlog;
        this.date = date;
        this.user_id = user_id;
    }

    public Blog(String name, String contentBlog, Timestamp date, int user_id) {
        this.name = name;
        this.contentBlog = contentBlog;
        this.date = date;
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentBlog() {
        return contentBlog;
    }

    public void setContentBlog(String contentBlog) {
        this.contentBlog = contentBlog;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
