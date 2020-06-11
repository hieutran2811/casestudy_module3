<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Blog Post - Start Bootstrap Template</title>
    <link href="bootstrap.min.css" rel="stylesheet">
    <link href="blog-post.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="Home.jsp">My Blog</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <%--                <li class="nav-item active">--%>
                <%--                    <a class="nav-link" href="#">Home--%>
                <%--                        <span class="sr-only">(current)</span>--%>
                <%--                    </a>--%>
                <%--                </li>--%>
                <%--                <li class="nav-item">--%>
                <%--                    <a class="nav-link" href="login_form.jsp">Login</a>--%>
                <%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    &lt;%&ndash;                    <p class="lead"><c:out value="${account.getAccount}"/></p>&ndash;%&gt;--%>
<%--                    <a class="nav-link" href="sign_up_form.jsp"><c:out value="${account.account}"/></a>--%>
<%--                </li>--%>
                <%--                <li class="nav-item">--%>
                <%--                    <a class="nav-link" href="#">Contact</a>--%>
                <%--                </li>--%>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="card my-4">
        <h5 class="card-header">Edit Comments:</h5>
        <div class="card-body">
            <form method="post" action="/myblog?action=edit comments&user=${comments.user_name}&commentsId=${comments.id}&blogId=${comments.blog_id}">
                <div class="form-group">
                    <textarea class="form-control" rows="3" name="content">
                        <c:out value="${comments.content}"/>
                    </textarea>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
<%--    <div class="row">--%>
<%--        <div class="col-lg-8">--%>
<%--            <h5 class="card-header">Create a Blog:</h5>--%>
<%--            <div class="card-body">--%>
<%--                <form method="post" action="/myblog?action=create blog&user=${account.account}">--%>
<%--                    <div class="form-group">--%>
<%--                        Blog Name : <input type="text" class="form-control" rows="3" name="name"><br>--%>
<%--                        Content:--%>
<%--                        <textarea class="form-control" rows="3" name="content"></textarea>--%>
<%--                    </div>--%>
<%--                    <button type="submit" class="btn btn-primary">Submit</button>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <c:forEach var="blog" items="${blogList}">--%>
<%--            <div class="col-lg-8">--%>
<%--                <h1 class="mt-4"><c:out value="${blog.name}"/></h1>--%>
<%--                <p class="lead">--%>
<%--                    by--%>
<%--                    <c:out value="${blog.user_name}"/>--%>
<%--                </p>--%>
<%--                <hr>--%>
<%--                <p><c:out value="${blog.date}"/></p>--%>
<%--                <a href="/myblog?action=editBlog&id=${blog.id}&user=${blog.user_name}&account=${account.account}">edit</a>--%>
<%--                <a href="/myblog?action=deleteBlog&id=${blog.id}&user=${blog.user_name}&account=${account.account}">delete</a>--%>
<%--                <hr>--%>
<%--                <img class="img-fluid rounded" src="http://placehold.it/900x300" alt="">--%>
<%--                <hr>--%>
<%--                <c:out value="${blog.contentBlog}"/>--%>
<%--                    &lt;%&ndash;            <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ducimus, vero, obcaecati, aut, error quam sapiente nemo saepe quibusdam sit excepturi nam quia corporis eligendi eos magni recusandae laborum minus inventore?</p>&ndash;%&gt;--%>

<%--                    &lt;%&ndash;            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ut, tenetur natus doloremque laborum quos iste ipsum rerum obcaecati impedit odit illo dolorum ab tempora nihil dicta earum fugiat. Temporibus, voluptatibus.</p>&ndash;%&gt;--%>

<%--                    &lt;%&ndash;            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eos, doloribus, dolorem iusto blanditiis unde eius illum consequuntur neque dicta incidunt ullam ea hic porro optio ratione repellat perspiciatis. Enim, iure!</p>&ndash;%&gt;--%>

<%--                    &lt;%&ndash;            <blockquote class="blockquote">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                <footer class="blockquote-footer">Someone famous in&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    <cite title="Source Title">Source Title</cite>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                </footer>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;            </blockquote>&ndash;%&gt;--%>

<%--                    &lt;%&ndash;            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Error, nostrum, aliquid, animi, ut quas placeat totam sunt tempora commodi nihil ullam alias modi dicta saepe minima ab quo voluptatem obcaecati?</p>&ndash;%&gt;--%>

<%--                    &lt;%&ndash;            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Harum, dolor quis. Sunt, ut, explicabo, aliquam tenetur ratione tempore quidem voluptates cupiditate voluptas illo saepe quaerat numquam recusandae? Qui, necessitatibus, est!</p>&ndash;%&gt;--%>

<%--                <hr>--%>
<%--                <div class="card my-4">--%>
<%--                    <h5 class="card-header">Create a Comment:</h5>--%>
<%--                    <div class="card-body">--%>
<%--                        <form method="post" action="/myblog?action=create comments&user=${account.account}&blogId=${blog.id}">--%>
<%--                            <div class="form-group">--%>
<%--                                <textarea class="form-control" rows="3" name="content"></textarea>--%>
<%--                            </div>--%>
<%--                            <button type="submit" class="btn btn-primary">Submit</button>--%>
<%--                        </form>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <c:forEach var="comments" items="${blog.commentsList}">--%>
<%--                    <div class="media mb-4">--%>
<%--                        <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">--%>
<%--                        <div class="media-body">--%>
<%--                            <h5 class="mt-0"><c:out value="${comments.user_name}"/></h5>--%>
<%--                            <h5 class="mt-0"><c:out value="${comments.date}"/></h5>--%>
<%--                            <a href="/myblog?action=editComments&id=${comments.id}&user=${comments.user_name}&account=${account.account}">edit</a>--%>
<%--                            <a href="/myblog?action=deleteComments&id=${comments.id}&user=${comments.user_name}&account=${account.account}">delete</a>--%>
<%--                            <br>--%>
<%--                            <c:out value="${comments.content}"/>--%>
<%--                        </div>--%>

<%--                            &lt;%&ndash;            </div>&ndash;%&gt;--%>
<%--                            &lt;%&ndash;            <div class="media mb-4">&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                <div class="media-body">&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                    <h5 class="mt-0">Commenter Name</h5>&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.&ndash;%&gt;--%>

<%--                            &lt;%&ndash;&lt;%&ndash;                    <div class="media mt-4">&ndash;%&gt;&ndash;%&gt;--%>
<%--                            &lt;%&ndash;&lt;%&ndash;                        <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">&ndash;%&gt;&ndash;%&gt;--%>
<%--                            &lt;%&ndash;&lt;%&ndash;                        <div class="media-body">&ndash;%&gt;&ndash;%&gt;--%>
<%--                            &lt;%&ndash;&lt;%&ndash;                            <h5 class="mt-0">Commenter Name</h5>&ndash;%&gt;&ndash;%&gt;--%>
<%--                            &lt;%&ndash;&lt;%&ndash;                            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.&ndash;%&gt;&ndash;%&gt;--%>
<%--                            &lt;%&ndash;&lt;%&ndash;                        </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--                            &lt;%&ndash;&lt;%&ndash;                    </div>&ndash;%&gt;&ndash;%&gt;--%>

<%--                            &lt;%&ndash;&lt;%&ndash;                    <div class="media mt-4">&ndash;%&gt;&ndash;%&gt;--%>
<%--                            &lt;%&ndash;&lt;%&ndash;                        <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">&ndash;%&gt;&ndash;%&gt;--%>
<%--                            &lt;%&ndash;&lt;%&ndash;                        <div class="media-body">&ndash;%&gt;&ndash;%&gt;--%>
<%--                            &lt;%&ndash;&lt;%&ndash;                            <h5 class="mt-0">Commenter Name</h5>&ndash;%&gt;&ndash;%&gt;--%>
<%--                            &lt;%&ndash;&lt;%&ndash;                            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.&ndash;%&gt;&ndash;%&gt;--%>
<%--                            &lt;%&ndash;&lt;%&ndash;                        </div>&ndash;%&gt;&ndash;%&gt;--%>
<%--                            &lt;%&ndash;&lt;%&ndash;                    </div>&ndash;%&gt;&ndash;%&gt;--%>

<%--                            &lt;%&ndash;                </div>&ndash;%&gt;--%>
<%--                            &lt;%&ndash;            </div>&ndash;%&gt;--%>

<%--                    </div>--%>
<%--                </c:forEach>--%>


<%--                    &lt;%&ndash;        <!-- Sidebar Widgets Column -->&ndash;%&gt;--%>
<%--                    &lt;%&ndash;        <div class="col-md-4">&ndash;%&gt;--%>

<%--                    &lt;%&ndash;            <!-- Search Widget -->&ndash;%&gt;--%>
<%--                    &lt;%&ndash;            <div class="card my-4">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                <h5 class="card-header">Search</h5>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                <div class="card-body">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    <div class="input-group">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        <input type="text" class="form-control" placeholder="Search for...">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        <span class="input-group-btn">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                <button class="btn btn-secondary" type="button">Go!</button>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;              </span>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    </div>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                </div>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;            </div>&ndash;%&gt;--%>

<%--                    &lt;%&ndash;            <!-- Categories Widget -->&ndash;%&gt;--%>
<%--                    &lt;%&ndash;            <div class="card my-4">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                <h5 class="card-header">Categories</h5>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                <div class="card-body">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    <div class="row">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        <div class="col-lg-6">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                            <ul class="list-unstyled mb-0">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                <li>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                    <a href="#">Web Design</a>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                </li>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                <li>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                    <a href="#">HTML</a>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                </li>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                <li>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                    <a href="#">Freebies</a>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                </li>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                            </ul>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        <div class="col-lg-6">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                            <ul class="list-unstyled mb-0">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                <li>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                    <a href="#">JavaScript</a>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                </li>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                <li>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                    <a href="#">CSS</a>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                </li>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                <li>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                    <a href="#">Tutorials</a>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                                </li>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                            </ul>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                        </div>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    </div>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                </div>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;            </div>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;            <div class="card my-4">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                <h5 class="card-header">Side Widget</h5>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                <div class="card-body">&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                    You can put anything you want inside of these side widgets. They are easy to use, and feature the new Bootstrap 4 card containers!&ndash;%&gt;--%>
<%--                    &lt;%&ndash;                </div>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;            </div>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;        </div>&ndash;%&gt;--%>
<%--            </div>--%>
<%--        </c:forEach>--%>
<%--    </div>--%>
</div>
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
    </div>
</footer>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
