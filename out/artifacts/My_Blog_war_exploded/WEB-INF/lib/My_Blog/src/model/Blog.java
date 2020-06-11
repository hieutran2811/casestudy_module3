package model;

import java.sql.Timestamp;
import java.util.List;

public class Blog {
    private int id;
    private String name;
    private String contentBlog;
    private Timestamp date;
    private String user_name;
    private List<Comments> commentsList;


    public Blog(int id, String name, String contentBlog, Timestamp date, String user_name) {
        this.id = id;
        this.name = name;
        this.contentBlog = contentBlog;
        this.date = date;
        this.user_name = user_name;
    }

    public Blog(String name, String contentBlog, Timestamp date, String user_name) {
        this.name = name;
        this.contentBlog = contentBlog;
        this.date = date;
        this.user_name = user_name;
    }

    public Blog(int id, String name, String contentBlog, Timestamp date, String user_name, List<Comments> commentsList) {
        this.id = id;
        this.name = name;
        this.contentBlog = contentBlog;
        this.date = date;
        this.user_name= user_name;
        this.commentsList = commentsList;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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
