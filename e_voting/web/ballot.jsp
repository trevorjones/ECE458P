<%-- 
    Author     : tjones
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>eVoting</title>
        <script src="http://code.jquery.com/jquery.js"></script>
        <link href="bootstrap-3.1.1-dist/css/bootstrap.min.css" rel="stylesheet" media="screen">
    </head>
    <body style="background-image:url(http://simsa.dsu.dal.ca/wp-content/uploads/2014/03/Vote.jpg)" onload="protectInjection()" onchange="changed()">
        <h1 style="width:300px; margin: 0 auto;">Vote for President</h2>
        <div style="width:250px; margin-left:auto; margin-right:auto;" class="radio">
            <form id="candidates" method="post" action="VoteServlet">
              <input type="radio" name="candidate" value="1">Trevor Jones</input></br>
              <input type="radio" name="candidate" value="2">Steven Harper</input></br>
              <input type="radio" name="candidate" value="3">Phil Kessel</input></br>
              <input type="radio" name="candidate" value="4">Kyle Lowry</input></br>
              <img src="https://s3.amazonaws.com/i.fakecaptcha.com/words/d703037358cf.jpg" style="width: 230px;"></img>
              <input type="text" name="captcha" placeholder="Enter Captcha" style="width:100%"></input>
              <button id="submitV" type="submit" class="btn btn-success" style="width: 100%; margin-top: 10px;">Vote</button>
            </form>
            <form id="writein" method="post" action="WriteInServlet">
                <input id="winput" type="text" name="writein" style="width: 100%; margin-top: 10px;"></input>
                <button id="submitW" type="submit" class="btn btn-success" style="width: 100%; margin-top: 10px;">Submit write-in</button>
            </form>
        </div>
    </body>
    <script type="text/javascript" src="scripts/main.js"></script>
</html>
