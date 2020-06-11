package controller;

import dao.MyBlogDAO;
import model.Blog;
import model.Comments;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/myblog")
public class UserServlet extends HttpServlet {
    private MyBlogDAO myBlogDAO;

    @Override
    public void init() {
        myBlogDAO = new MyBlogDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
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
            case "create blog":
                try {
                    createBlog(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "create comments":
                try {
                    createComments(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit blog":
                try {
                    editBlog(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit comments":
                try {
                    editComments(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;

        }
    }

    private void editComments(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("commentsId"));
        String user_name = request.getParameter("user");
        int blog_id= Integer.parseInt(request.getParameter("blogId"));
        String content = request.getParameter("content");
        long millis1 =  new java.util.Date().getTime();
        java.sql.Timestamp ts = new java.sql.Timestamp(millis1);
        Comments comments = new Comments(id,content,ts,blog_id,user_name);
        myBlogDAO.updateCommentsById(comments);
        showAll(request,response,user_name);
//        User user = new User(user_name);
//        List<Blog> blogList = myBlogDAO.selectAllBlog();
//        request.setAttribute("blogList",blogList);
//        request.setAttribute("account",user);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/personal_page.jsp");
//        dispatcher.forward(request,response);
    }
    private  void showAll(HttpServletRequest request,HttpServletResponse response,String user_name) throws SQLException, ServletException, IOException {
        User user = new User(user_name);
        List<Blog> blogList = myBlogDAO.selectAllBlog();
        request.setAttribute("blogList",blogList);
        request.setAttribute("account",user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/personal_page.jsp");
        dispatcher.forward(request,response);

    }

    private void editBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        String user_name = request.getParameter("user");
        String name = request.getParameter("name");
        String content = request.getParameter("content");
        long millis1 =  new java.util.Date().getTime();
        java.sql.Timestamp ts = new java.sql.Timestamp(millis1);
        Blog blog = new Blog(id,name,content,ts,user_name);
        myBlogDAO.updateBlogById(blog);
        showAll(request,response,user_name);
//        User user = new User(user_name);
//        List<Blog> blogList = myBlogDAO.selectAllBlog();
//        request.setAttribute("blogList",blogList);
//        request.setAttribute("account",user);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/personal_page.jsp");
//        dispatcher.forward(request,response);
    }

    private void createComments(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String user_name = request.getParameter("user");
        String content = request.getParameter("content");
        int blog_id = Integer.parseInt(request.getParameter("blogId"));
        long millis1 =  new java.util.Date().getTime();
        java.sql.Timestamp ts = new java.sql.Timestamp(millis1);
        Comments comments = new Comments(content,ts,blog_id,user_name);
        myBlogDAO.insertComments(comments);
        showAll(request,response,user_name);
//        User user = new User(user_name);
//        List<Blog> blogList = myBlogDAO.selectAllBlog();
//        request.setAttribute("blogList",blogList);
//        request.setAttribute("account",user);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/personal_page.jsp");
//        dispatcher.forward(request,response);
    }


    private void createBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String user_name = request.getParameter("user");
        String content = request.getParameter("content");
        long millis1 =  new java.util.Date().getTime();
        java.sql.Timestamp ts = new java.sql.Timestamp(millis1);
        Blog blog = new Blog(name,content,ts,user_name);
        myBlogDAO.insertBlog(blog);
        showAll(request,response,user_name);
//        User user = new User(user_name);
//        List<Blog> blogList = myBlogDAO.selectAllBlog();
//        request.setAttribute("blogList",blogList);
//        request.setAttribute("account",user);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/personal_page.jsp");
//        dispatcher.forward(request,response);

    }

    private void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String account = request.getParameter("account");
        String firstPassword = request.getParameter("first password");
        String secondPassword = request.getParameter("second password");
        if (firstPassword.equals(secondPassword) ){
            User user = new User(account,firstPassword);
            boolean check = myBlogDAO.checkUserByAccount(user);
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
            case "editBlog":
                try {
                    String user_blog= request.getParameter("user");
                    String account= request.getParameter("account");
                    if (user_blog.equals(account)){
                        showEditBlog(request,response);
                    }else{
                        showAll(request,response,account);
//                        User user = new User(account);
//                        List<Blog> blogList = myBlogDAO.selectAllBlog();
//                        request.setAttribute("blogList",blogList);
//                        request.setAttribute("account",user);
//                        RequestDispatcher dispatcher = request.getRequestDispatcher("/personal_page.jsp");
//                        dispatcher.forward(request,response);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "deleteBlog":
                try {
                    String user_blog= request.getParameter("user");
                    String account= request.getParameter("account");
                    if (user_blog.equals(account)){
                        deleteBlog(request,response);
                    }else {
                        showAll(request,response,account);
//                        User user = new User(account);
//                        List<Blog> blogList = myBlogDAO.selectAllBlog();
//                        request.setAttribute("blogList",blogList);
//                        request.setAttribute("account",user);
//                        RequestDispatcher dispatcher = request.getRequestDispatcher("/personal_page.jsp");
//                        dispatcher.forward(request,response);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "editComments":
                String user_blog= request.getParameter("user");
                String account= request.getParameter("account");
                try {
                    if (user_blog.equals(account)){
                        showEditComments(request,response);
                    }else {
                        showAll(request,response,account);
//                        User user = new User(account);
//                        List<Blog> blogList = myBlogDAO.selectAllBlog();
//                        request.setAttribute("blogList",blogList);
//                        request.setAttribute("account",user);
//                        RequestDispatcher dispatcher = request.getRequestDispatcher("/personal_page.jsp");
//                        dispatcher.forward(request,response);
                    }
                }catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "deleteComments":
                String user_comments= request.getParameter("user");
                String account_comments= request.getParameter("account");
                try {
                    if (user_comments.equals(account_comments)) {
                        deleteComments(request, response);

                    }else {
                        showAll(request,response,user_comments);
//                        User user = new User(user_comments);
//                        List<Blog> blogList = myBlogDAO.selectAllBlog();
//                        request.setAttribute("blogList",blogList);
//                        request.setAttribute("account",user);
//                        RequestDispatcher dispatcher = request.getRequestDispatcher("/personal_page.jsp");
//                        dispatcher.forward(request,response);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

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

    private void deleteComments(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int comments_id = Integer.parseInt(request.getParameter("id"));
        String user_name = request.getParameter("user");
        myBlogDAO.deleteCommentsById(comments_id);
        showAll(request,response,user_name);
//        User user = new User(user_name);
//        List<Blog> blogList = myBlogDAO.selectAllBlog();
//        request.setAttribute("blogList",blogList);
//        request.setAttribute("account",user);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/personal_page.jsp");
//        dispatcher.forward(request,response);
    }

    private void showEditComments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int comments_id = Integer.parseInt(request.getParameter("id"));
        Comments comments = myBlogDAO.selectCommentsById(comments_id);
        request.setAttribute("comments",comments);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/editComments.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int blog_id = Integer.parseInt(request.getParameter("id"));
        String user_name = request.getParameter("user");
        myBlogDAO.deleteCommentsByBlogId(blog_id);
        myBlogDAO.deleteBlogById(blog_id);
        showAll(request,response,user_name);
//        User user = new User(user_name);
//        List<Blog> blogList = myBlogDAO.selectAllBlog();
//        request.setAttribute("blogList",blogList);
//        request.setAttribute("account",user);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/personal_page.jsp");
//        dispatcher.forward(request,response);

    }

    private void showEditBlog(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int blog_id = Integer.parseInt(request.getParameter("id"));
        Blog blog = myBlogDAO.selectBlogById(blog_id);
        request.setAttribute("blog",blog);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/editBlog.jsp");
        dispatcher.forward(request,response);

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
