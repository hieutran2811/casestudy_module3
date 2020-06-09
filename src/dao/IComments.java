package dao;

import model.Comments;

import java.sql.SQLException;
import java.util.List;

public interface IComments {
    void insertBlog(Comments comments) throws SQLException;
    Comments selectBlog(int id);
    List<Comments> selectAllBlog();
    boolean deleteBlog(int id) throws SQLException;
    boolean updateBlog(Comments comments) throws SQLException;
}
