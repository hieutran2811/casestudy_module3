package model;

import java.util.List;

public class UserDemo {
    private List<User> listUser;
    private User user;

    public UserDemo(List<User> listUser, User user) {
        this.listUser = listUser;
        this.user = user;
    }

    public List<User> getListUser() {
        return listUser;
    }

    public void setListUser(List<User> listUser) {
        this.listUser = listUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
