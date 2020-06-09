package dao;

import model.Blog;

import java.util.List;

public class BlogDAO implements IBlogDAO{
    UserDAO userDAO= new UserDAO();
    private static final String INSERT_BLOG_SQL = "INSERT INTO users" + " (name, content, date,user_id) VALUES " +
            " (?, ?, ?,?);";

    private static final String SELECT_BLOG_BY_ID = "select id,name,account,password,email,phoneNumber from users where id =?";
    private static final String SELECT_ALL_BLOG = "select * from users";
    private static final String DELETE_BLOG_SQL = "delete from users where id = ?;";
    private static final String UPDATE_BLOG_SQL = "update users set name = ?,action =?,password=?,email= ?, phoneNumber =? where id = ?;";
    @Override
    public void insertBlog(Blog blog) {

    }

    @Override
    public Blog selectBlog(int id) {
        return null;
    }

    @Override
    public List<Blog> selectAllBlog() {
        return null;
    }

    @Override
    public boolean deleteBlog(int id) {
        return false;
    }

    @Override
    public boolean updateBlog(Blog blog) {
        return false;
    }
}
