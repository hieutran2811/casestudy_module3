package dao;

import model.Blog;

import java.sql.SQLException;
import java.util.List;

public interface IBlogDAO {
    void insertBlog(Blog blog) throws SQLException;
    Blog selectBlog(int id);
    List<Blog> selectAllBlog();
    boolean deleteBlog(int id) throws SQLException;
    boolean updateBlog(Blog blog) throws SQLException;

}
