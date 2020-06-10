package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    void insertUser(User user) throws SQLException;
    User selectUser(String account);
    List<User> selectAllUsers();
    boolean deleteUser(int id) throws SQLException;
    boolean updateUser(User user) throws SQLException;
}
