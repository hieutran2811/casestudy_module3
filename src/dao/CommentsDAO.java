package dao;

import model.Blog;
import model.Comments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentsDAO implements IComments{
    UserDAO userDAO = new UserDAO();
    private static final String INSERT_COMMENTS_SQL = "INSERT INTO my_blog.comments" + " (content, date,blog_id) VALUES " +
            " (?, ?, ?);";

    private static final String SELECT_COMMENTS_BY_ID = "select id,name,content,date,user_id from my_blog.blog where id =?;";
    private static final String SELECT_ALL_COMMENTS = "select * from my_blog.comments;";
    private static final String DELETE_COMMENTS_SQL = "delete from my_blog.comments where id = ?;";
    private static final String UPDATE_COMMENTS_SQL = "update my_blog.comments set content =?,date=?, blog_id =? where id = ?;";

    public CommentsDAO() {
    }

    @Override
    public void insertComment(Comments comments, Blog blog) {
        System.out.println(INSERT_COMMENTS_SQL);
        try (Connection connection = userDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMMENTS_SQL)) {
            preparedStatement.setString(1, comments.getContentComments());
            preparedStatement.setTimestamp(2, comments.getDate());
            preparedStatement.setInt(3, blog.getId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            userDAO.printSQLException(e);
        }
    }

    @Override
    public Comments selectComment(int id) {
        Comments comments = null;
        try (Connection connection = userDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMMENTS_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String content = rs.getString("content");
                Timestamp date = rs.getTimestamp("date");
                int blog_id = rs.getInt("blog_id");
                comments = new Comments(id, content,date,blog_id);
            }
        } catch (SQLException e) {
            userDAO.printSQLException(e);
        }
        return comments;
    }

    @Override
    public List<Comments> selectAllComment() {
        List<Comments> comments = new ArrayList<>();
        try (Connection connection = userDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMMENTS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String content = rs.getString("content");
                Timestamp date = rs.getTimestamp("date");
                int blog_id = rs.getInt("blog_id");
                comments.add(new Comments(id, content,date,blog_id));
            }
        } catch (SQLException e) {
            userDAO.printSQLException(e);
        }
        return comments;
    }

    @Override
    public boolean deleteComment(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = userDAO.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_COMMENTS_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateComment(Comments comments) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = userDAO.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_COMMENTS_SQL)) {
            statement.setString(1, comments.getContentComments());
            statement.setTimestamp(2, comments.getDate());
            statement.setInt(3, comments.getBlog_id());
            statement.setInt(4, comments.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
