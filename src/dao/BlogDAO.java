package dao;

import model.Blog;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDAO implements IBlogDAO {
    UserDAO userDAO = new UserDAO();
    private static final String INSERT_BLOG_SQL = "INSERT INTO my_blog.blog" + " (name, content, date,user_id) VALUES " +
            " (?, ?, ?,?);";

    private static final String SELECT_BLOG_BY_ID = "select id,name,content,date,user_id from my_blog.blog where id =?;";
    private static final String SELECT_ALL_BLOG = "select * from my_blog.blog;";
    private static final String DELETE_BLOG_SQL = "delete from my_blog.blog where id = ?;";
    private static final String UPDATE_BLOG_SQL = "update my_blog.blog set name = ?,content =?,date=?, user_id =? where id = ?;";

    public BlogDAO() {
    }

    @Override
    public void insertBlog(Blog blog, User user) {
        System.out.println(INSERT_BLOG_SQL);
        try (Connection connection = userDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BLOG_SQL)) {
            preparedStatement.setString(1, blog.getName());
            preparedStatement.setString(2, blog.getContentBlog());
            preparedStatement.setTimestamp(3, blog.getDate());
            preparedStatement.setInt(4, user.getId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            userDAO.printSQLException(e);
        }

    }

    @Override
    public Blog selectBlog(int id) {
        Blog blog = null;
        try (Connection connection = userDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BLOG_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String content = rs.getString("content");
                Timestamp date = rs.getTimestamp("date");
                int user_id = rs.getInt("user_id");
                blog = new Blog(id, name, content,date,user_id);
            }
        } catch (SQLException e) {
            userDAO.printSQLException(e);
        }
        return blog;
    }

    @Override
    public List<Blog> selectAllBlog() {
        List<Blog> blogs = new ArrayList<>();
        try (Connection connection = userDAO.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BLOG)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String content = rs.getString("content");
                Timestamp date = rs.getTimestamp("date");
                int user_id = rs.getInt("user_id");
                blogs.add(new Blog(id, name, content,date,user_id));
            }
        } catch (SQLException e) {
            userDAO.printSQLException(e);
        }
        return blogs;
    }

    @Override
    public boolean deleteBlog(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = userDAO.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_BLOG_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateBlog(Blog blog) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = userDAO.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_BLOG_SQL)) {
            statement.setString(1, blog.getName());
            statement.setString(2, blog.getContentBlog());
            statement.setTimestamp(3, blog.getDate());
            statement.setInt(4, blog.getUser_id());
            statement.setInt(5, blog.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

}

