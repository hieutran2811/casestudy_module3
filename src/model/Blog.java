package model;

public class Blog {
    private int id;
    private int name;
    private String contentBlog;
    private String date;

    public Blog(int id, int name, String contentBlog, String date) {
        this.id = id;
        this.name = name;
        this.contentBlog = contentBlog;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getContentBlog() {
        return contentBlog;
    }

    public void setContentBlog(String contentBlog) {
        this.contentBlog = contentBlog;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
