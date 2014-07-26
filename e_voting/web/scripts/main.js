/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var loadedBody;

function saveState(){
    loadedBody = document.body.innerHTML.trim();
    var shouldBe = "\n        <h1 style=\"width:300px; margin: 0 auto;\">Vote for President</h1>\n        <div style=\"width:250px; margin-left:auto; margin-right:auto;\" class=\"radio\">\n            <form id=\"candidates\" method=\"post\" action=\"VoteServlet\">\n              <input type=\"radio\" name=\"candidate\" value=\"trevorjones\">Trevor Jones<br>\n              <input type=\"radio\" name=\"candidate\" value=\"stevenharper\">Steven Harper<br>\n              <input type=\"radio\" name=\"candidate\" value=\"philkessel\">Phil Kessel<br>\n              <input type=\"radio\" name=\"candidate\" value=\"kylelowry\">Kyle Lowry<br>\n              <button type=\"submit\" class=\"btn btn-success\" style=\"width: 100%; margin-top: 10px;\">Vote</button>\n            </form>\n        </div>\n    \n    <script type=\"text/javascript\" src=\"scripts/main.js\"></script>\n".trim();
    if(loadedBody != shouldBe){
        alert("Malware Detected - Voting Compromised");
        $(":submit").attr("disabled", true);
    }
}