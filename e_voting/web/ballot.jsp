<%-- 
    Author     : tjones
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eVoting</title>
        <link href="bootstrap-3.1.1-dist/css/bootstrap.min.css" rel="stylesheet" media="screen">
    </head>
    <body style="background-image:url(http://simsa.dsu.dal.ca/wp-content/uploads/2014/03/Vote.jpg)">
        <div style="width:250px; margin-left:auto; margin-right:auto;">
            <h1>eVoting System</h2>
            <form id="candidates">
              <input type="radio" name="candidate" value="trevorjones">Trevor Jones</input></br>
              <input type="radio" name="candidate" value="stevenharper">Steven Harper</input></br>
              <input type="radio" name="candidate" value="philkessel">Phil Kessel</input></br>
              <input type="radio" name="candidate" value="kylelowry">Kyle Lowry</input></br>
              <button type="submit" class="btn btn-success" style="width: 100%; margin-top: 10px;">Vote</button>
            </form>
        </div>
    </body>
</html>
