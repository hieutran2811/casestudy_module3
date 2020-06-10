package controller;

import dao.BlogDAO;
import dao.CommentsDAO;
import dao.MyBlogDAO;
import dao.UserDAO;
import model.Blog;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/myblog")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO ;
    private BlogDAO blogDAO ;
    private MyBlogDAO myBlogDAO;
    private CommentsDAO commentsDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
        blogDAO = new BlogDAO();
        commentsDAO= new CommentsDAO();
        myBlogDAO = new MyBlogDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "login":
                try {
                    login(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "signUp":
                try {
                    signUp(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            
        }
    }

    private void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String account = request.getParameter("account");
        String firstPassword = request.getParameter("first password");
        String secondPassword = request.getParameter("second password");
        if (firstPassword.equals(secondPassword) ){
            User user = new User(account,firstPassword);
            boolean check = myBlogDAO.checkUser(user);
            if (check){
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sing_up_form.jsp");
                dispatcher.forward(request,response);
            }else{
                myBlogDAO.insertUser(user);
                List<Blog> blogList = myBlogDAO.selectAllBlog();
                request.setAttribute("blogList",blogList);
                request.setAttribute("account",user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/personal_page.jsp");
                dispatcher.forward(request,response);
            }
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/sing_up_form.jsp");
            dispatcher.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "login":
                break;
            case "signUp":
                break;
            default:
                try {
                    home(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }

    }

    private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Blog> blogList = myBlogDAO.selectAllBlog();
        request.setAttribute("blogList",blogList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Home.jsp");
        dispatcher.forward(request,response);
    }
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        User user = new User(account,password);
        boolean check = myBlogDAO.checkUser(user);
        if (check){
            List<Blog> blogList = myBlogDAO.selectAllBlog();
            request.setAttribute("blogList",blogList);
            request.setAttribute("account",user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/personal_page.jsp");
            dispatcher.forward(request,response);
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login_form.jsp");
            dispatcher.forward(request,response);
        }
    }
}
