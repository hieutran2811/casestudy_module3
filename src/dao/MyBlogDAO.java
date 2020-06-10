package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyBlogDAO {
    private static final String INSERT_USERS_SQL = "INSERT INTO my_blog.user" + " ( account, password) VALUES " +
            " (?, ?);";
    private static final String INSERT_BLOG_SQL = "INSERT INTO my_blog.blog" + " (name, content, date,user_id) VALUES " +
            " (?, ?, ?,?);";

    private static final String SELECT_BLOG_BY_ID = "select id,name,content,date,user_id from my_blog.blog where id =?;";
    private static final String SELECT_ALL_BLOG = "select * from my_blog.blog;";
    private static final String DELETE_BLOG_SQL = "delete from my_blog.blog where id = ?;";
    private static final String UPDATE_BLOG_SQL = "update my_blog.blog set name = ?,content =?,date=?, user_id =? where id = ?;";

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
}
