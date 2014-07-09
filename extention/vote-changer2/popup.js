window.onload = function() {
    document.getElementById("change").onclick = function() {
        chrome.extension.sendMessage("change");
    }
    document.getElementById("normal").onclick = function() {
        chrome.extension.sendMessage("normal");
    }
}