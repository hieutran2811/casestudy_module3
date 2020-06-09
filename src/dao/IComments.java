package dao;

import model.Blog;
import model.Comments;

import java.sql.SQLException;
import java.util.List;

public interface IComments {
    void insertComment(Comments comments, Blog blog) throws SQLException;
    Comments selectComment(int id);
    List<Comments> selectAllComment();
    boolean deleteComment(int id) throws SQLException;
    boolean updateComment(Comments comments) throws SQLException;
}
