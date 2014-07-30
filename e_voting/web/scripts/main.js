/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var loadedBody;
var shouldBe = "\n        <h1 style=\"width:300px; margin: 0 auto;\">Vote for President</h1>\n        <div style=\"width:250px; margin-left:auto; margin-right:auto;\" class=\"radio\">\n            <form id=\"candidates\" method=\"post\" action=\"VoteServlet\">\n              <input type=\"radio\" name=\"candidate\" value=\"1\">Trevor Jones<br>\n              <input type=\"radio\" name=\"candidate\" value=\"2\">Steven Harper<br>\n              <input type=\"radio\" name=\"candidate\" value=\"3\">Phil Kessel<br>\n              <input type=\"radio\" name=\"candidate\" value=\"4\">Kyle Lowry<br>\n              <img src=\"https://s3.amazonaws.com/i.fakecaptcha.com/words/d703037358cf.jpg\" style=\"width: 230px;\">\n              <input type=\"text\" name=\"captcha\" placeholder=\"Enter Captcha\" style=\"width:100%\">\n              <button id=\"submitV\" type=\"submit\" class=\"btn btn-success\" style=\"width: 100%; margin-top: 10px;\">Vote</button>\n            </form>\n            <form id=\"writein\" method=\"post\" action=\"WriteInServlet\">\n                <input id=\"winput\" type=\"text\" name=\"writein\" style=\"width: 100%; margin-top: 10px;\">\n                <button id=\"submitW\" type=\"submit\" class=\"btn btn-success\" style=\"width: 100%; margin-top: 10px;\">Submit write-in</button>\n            </form>\n        </div>\n    \n    <script type=\"text/javascript\" src=\"scripts/main.js\"></script> \n".trim();


function protectInjection(){
    loadedBody = document.body.innerHTML.trim();
    console.log(loadedBody == shouldBe);
    if(loadedBody != shouldBe){
//        $(":submit").attr("disabled", true);
//        document.body.innerHTML = shouldBe;
//        alert("Malware Detected - HTML Reverted");
    }
}