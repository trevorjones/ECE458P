<%-- 
    Document   : index
    Created on : Jul 9, 2014, 3:13:52 PM
    Author     : slouli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eVoting</title>
        <jsp:useBean id="user" class="models.User" scope="session"/>
        <link href="bootstrap-3.1.1-dist/css/bootstrap.min.css" rel="stylesheet" media="screen">
    </head>
    <body style="background-image:url(http://simsa.dsu.dal.ca/wp-content/uploads/2014/03/Vote.jpg)">
        <div style="width:250px; margin-left:auto; margin-right:auto;">
            <form class="form-signin" method="post" action="SigninServlet">
                <input style="margin-bottom: 10px; margin-top: 20px;" class="form-control" type="text" name="user_id" placeholder="User ID"></input>
                <input style="margin-bottom: 10px;" class="form-control" type="password" name="password" placeholder="Password"></input>
                <button type="submit" value="Login" class="btn btn-default">Sign In</button>
            </form>
        </div>
    </body>
</html>
