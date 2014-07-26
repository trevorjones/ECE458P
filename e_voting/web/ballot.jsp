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
    <body style="background-image:url(http://simsa.dsu.dal.ca/wp-content/uploads/2014/03/Vote.jpg)" onload="saveState()" onchange="changed()">
        <h1 style="width:300px; margin: 0 auto;">Vote for President</h2>
        <div style="width:250px; margin-left:auto; margin-right:auto;" class="radio">
            <form id="candidates" method="post" action="VoteServlet">
              <input type="radio" name="candidate" value="trevorjones">Trevor Jones</input></br>
              <input type="radio" name="candidate" value="stevenharper">Steven Harper</input></br>
              <input type="radio" name="candidate" value="philkessel">Phil Kessel</input></br>
              <input type="radio" name="candidate" value="kylelowry">Kyle Lowry</input></br>
              <button type="submit" class="btn btn-success" style="width: 100%; margin-top: 10px;">Vote</button>
            </form>
        </div>
    </body>
    <script type="text/javascript" src="scripts/main.js"></script>
</html>
