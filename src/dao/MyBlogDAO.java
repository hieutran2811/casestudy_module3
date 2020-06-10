package dao;

import model.Blog;
import model.Comments;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyBlogDAO {
    private static final String INSERT_USERS_SQL = "INSERT INTO my_blog.user" + " ( account, password) VALUES " +
            " (?, ?);";
    private static final String SELECT_ALL_USER = "select * from my_blog.user;";
    private static final String SELECT_USER_BY_ACCOUNT_AND_PASSWORD = "select * from my_blog.user where account =? and password =?;";

    private static final String INSERT_BLOG_SQL = "INSERT INTO my_blog.blog" + " (name, content, date,user_id) VALUES " +
            " (?, ?, ?,?);";

    private static final String SELECT_BLOG_BY_ID = "select id,name,content,date,user_id from my_blog.blog where id =?;";
    private static final String SELECT_ALL_BLOG = "select * from my_blog.blog;";
    private static final String DELETE_BLOG_SQL = "delete from my_blog.blog where id = ?;";
    private static final String UPDATE_BLOG_SQL = "update my_blog.blog set name = ?,content =?,date=?, user_id =? where id = ?;";
    private static final String SELECT_ALL_COMMENTS_BY_BLOG_ID = "select * from my_blog.comments where blog_id=?;";
    public MyBlogDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String jdbcURL = "jdbc:mysql://localhost:3306/my_blog?useSSL=false";
            String jdbcUsername = "root";
            String jdbcPassword = "1234";
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public boolean checkUser(User user) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ACCOUNT_AND_PASSWORD);
        preparedStatement.setString(1,user.getAccount());
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
    public void insertUser(User user) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
        preparedStatement.setString(1,user.getAccount());
        preparedStatement.setString(1,user.getPassword());
        preparedStatement.executeUpdate();
    }
    public List<Blog> selectAllBlog() throws SQLException {
        List<Blog> blogList = new ArrayList<>();
        Connection connection= getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BLOG);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int blog_id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String content = resultSet.getString("content");
            Timestamp date = resultSet.getTimestamp("date");
            int user_id = resultSet.getInt("user_id");
            List<Comments> commentsList = selectAllCommentsByBlogId(blog_id);
            Blog blog = new Blog(blog_id,name,content,date,user_id,commentsList);
            blogList.add(blog);
        }
        return blogList;
    }
    public List<Comments> selectAllCommentsByBlogId(int blog_id) throws SQLException {
        List<Comments> commentsList = new ArrayList<>();
        Connection connection= getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMMENTS_BY_BLOG_ID);
        preparedStatement.setInt(1,blog_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int comments_id = resultSet.getInt("id");
            String content = resultSet.getString("content");
            Timestamp date = resultSet.getTimestamp("date");
            String user_name = resultSet.getString("user_name");
            Comments comments = new Comments(comments_id,content,date,blog_id,user_name);
            commentsList.add(comments);
        }
        return commentsList;
    }

}
