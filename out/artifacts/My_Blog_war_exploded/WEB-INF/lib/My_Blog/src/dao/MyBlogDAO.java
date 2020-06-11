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
//    private static final String SELECT_ALL_USER = "select * from my_blog.user;";
    private static final String SELECT_USER_BY_ACCOUNT_AND_PASSWORD = "select * from my_blog.user where account =? and password =?;";
    private static final String SELECT_USER_BY_ACCOUNT = "select * from my_blog.user where account =?;";

    private static final String INSERT_BLOG_SQL = "INSERT INTO my_blog.blog" + " (name, content, date,user_name) VALUES " +
            " (?, ?, ?,?);";

    private static final String SELECT_BLOG_BY_ID = "select * from my_blog.blog where id =?;";
    private static final String SELECT_COMMENTS_BY_ID = "select * from my_blog.comments where id =?;";
    private static final String SELECT_ALL_BLOG = "select * from my_blog.blog order by date DESC ;";
    private static final String DELETE_BLOG_SQL = "delete from my_blog.blog where id = ?;";
    private static final String DELETE_COMMENTS_BY_BLOG_ID_SQL = "delete from my_blog.comments where blog_id = ?;";
    private static final String DELETE_COMMENTS_SQL = "delete from my_blog.comments where id = ?;";
    private static final String UPDATE_BLOG_SQL = "update my_blog.blog set name = ?,content =?,date=?, user_name =? where id = ?;";
    private static final String UPDATE_COMMENTS_SQL = "update my_blog.comments set content =?,date=?,blog_id=? , user_name =? where id = ?;";
    private static final String SELECT_ALL_COMMENTS_BY_BLOG_ID = "select * from my_blog.comments where blog_id=? order by date ;";
    private static final String INSERT_COMMENTS_SQL = "INSERT INTO my_blog.comments" + " ( content, date,blog_id,user_name) VALUES " +
            " (?, ?, ?,?);";

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
        preparedStatement.setString(2,user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
    public void insertUser(User user) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
        preparedStatement.setString(1,user.getAccount());
        preparedStatement.setString(2,user.getPassword());
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
            String user_name = resultSet.getString("user_name");
            List<Comments> commentsList = selectAllCommentsByBlogId(blog_id);
            Blog blog = new Blog(blog_id,name,content,date,user_name,commentsList);
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

    public boolean checkUserByAccount(User user) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ACCOUNT);
        preparedStatement.setString(1,user.getAccount());
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    public void insertBlog(Blog blog) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BLOG_SQL);
        preparedStatement.setString(1,blog.getName());
        preparedStatement.setString(2,blog.getContentBlog());
        preparedStatement.setTimestamp(3,blog.getDate());
        preparedStatement.setString(4,blog.getUser_name());
        preparedStatement.executeUpdate();
    }

    public void insertComments(Comments comments) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMMENTS_SQL);
        preparedStatement.setString(1,comments.getContent());
        preparedStatement.setTimestamp(2,comments.getDate());
        preparedStatement.setInt(3,comments.getBlog_id());
        preparedStatement.setString(4,comments.getUser_name());
        preparedStatement.executeUpdate();
    }
    public Blog selectBlogById(int blog_id) throws SQLException {
        Blog blog= null;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BLOG_BY_ID);
        preparedStatement.setInt(1,blog_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            Timestamp timestamp = resultSet.getTimestamp("date");
            String content = resultSet.getString("content");
            String user_name = resultSet.getString("user_name");
            blog=new  Blog(blog_id,name,content,timestamp,user_name);
        }
        return  blog;
    }

    public void updateBlogById(Blog blog) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BLOG_SQL);
        preparedStatement.setInt(5,blog.getId());
        preparedStatement.setString(1,blog.getName());
        preparedStatement.setString(2,blog.getContentBlog());
        preparedStatement.setTimestamp(3,blog.getDate());
        preparedStatement.setString(4,blog.getUser_name());
        preparedStatement.executeUpdate();
    }
    public void deleteCommentsByBlogId(int blog_id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COMMENTS_BY_BLOG_ID_SQL);
        preparedStatement.setInt(1,blog_id);
        preparedStatement.executeUpdate();
    }

    public void deleteBlogById(int blog_id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BLOG_SQL);
        preparedStatement.setInt(1,blog_id);
        preparedStatement.executeUpdate();
    }

    public Comments selectCommentsById(int comments_id) throws SQLException {
        Comments comments = null;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMMENTS_BY_ID);
        preparedStatement.setInt(1,comments_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Timestamp timestamp = resultSet.getTimestamp("date");
            String content = resultSet.getString("content");
            String user_name = resultSet.getString("user_name");
            int blog_id = resultSet.getInt("blog_id");
            comments = new Comments(comments_id,content,timestamp,blog_id,user_name);
        }
        return  comments;
    }

    public void updateCommentsById(Comments comments) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COMMENTS_SQL);
        preparedStatement.setInt(5,comments.getId());
        preparedStatement.setString(1,comments.getContent());
        preparedStatement.setTimestamp(2,comments.getDate());
        preparedStatement.setInt(3,comments.getBlog_id());
        preparedStatement.setString(4,comments.getUser_name());
        preparedStatement.executeUpdate();
    }

    public void deleteCommentsById(int comments_id) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COMMENTS_SQL);
        preparedStatement.setInt(1,comments_id);
        preparedStatement.executeUpdate();
    }
}
