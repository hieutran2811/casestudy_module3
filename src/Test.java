import dao.BlogDAO;
import dao.CommentsDAO;
import dao.UserDAO;
import model.Blog;
import model.Comments;
import model.User;

import java.sql.Timestamp;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        long millis1 =  new Date().getTime();
        Timestamp ts = new Timestamp(millis1);
        User user = new User("vinh","vinh linh tinh",
                "vinh","vinhvang@gmail.com","0945158375");
        UserDAO userDAO = new UserDAO();
        BlogDAO blogDAO = new BlogDAO();
        CommentsDAO commentsDAO = new CommentsDAO();
        userDAO.insertUser(user);
        User user1 = userDAO.selectUser(1);
        Blog blog = new Blog("mình đã làm case study như thế nào?",
                "coppy paste",ts,user1.getId());
        blogDAO.insertBlog(blog,user1);
        Blog blog1 = blogDAO.selectBlog(1);
        long millis2 =  new Date().getTime();
        Timestamp ts2 = new Timestamp(millis2);
        Comments comments = new Comments("hay",ts2,blog1.getId());
        commentsDAO.insertComment(comments,blog1);


    }
}
