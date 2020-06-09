package model;

import java.sql.Timestamp;

public class Comments {
    private int id;
    private String contentComments;
    private Timestamp date;
    private int blog_id;

    public Comments(int id, String contentComments, Timestamp date, int blog_id) {
        this.id = id;
        this.contentComments = contentComments;
        this.date = date;
        this.blog_id = blog_id;
    }

    public Comments(String contentComments, Timestamp date, int blog_id) {
        this.contentComments = contentComments;
        this.date = date;
        this.blog_id = blog_id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContentComments() {
        return contentComments;
    }

    public void setContentComments(String contentComments) {
        this.contentComments = contentComments;
    }

}
