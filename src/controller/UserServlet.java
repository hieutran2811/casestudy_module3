package controller;

import dao.BlogDAO;
import dao.CommentsDAO;
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
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/myblog")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO ;
    private BlogDAO blogDAO ;
    private CommentsDAO commentsDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
        blogDAO = new BlogDAO();
        commentsDAO= new CommentsDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "login":
                login(request,response);
                break;
            case "signUp":
                signUp(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "login":
                showLogin(request,response);
                break;
            case "signUp":
                showSignUp(request,response);
                break;
            default:
                home(request,response);
                break;
        }

    }

    private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Home.jsp");
        dispatcher.forward(request,response);
    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login_form.jsp");
        dispatcher.forward(request,response);
    }

    private void showSignUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/sign_up_form.jsp");
        dispatcher.forward(request,response);
    }
    private void signUp(HttpServletRequest request, HttpServletResponse response) {
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        User user = userDAO.selectUser(account);
        if (password.equals(user.getPassword())){
            List<Blog> blogs = blogDAO.selectAllBlog();
            request.setAttribute("listBlog",blogs);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/show_blog.jsp");
            dispatcher.forward(request,response);

        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login_form.jsp");
            dispatcher.forward(request,response);
        }


    }
}
