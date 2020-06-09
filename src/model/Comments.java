package model;

public class Comments {
    private int id;
    private String contentComments;
    private String date;

    public Comments(int id, String contentComments, String date) {
        this.id = id;
        this.contentComments = contentComments;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
