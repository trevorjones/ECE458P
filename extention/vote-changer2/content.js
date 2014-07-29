window.onload = function() {
	toggle(false)
}

chrome.extension.onMessage.addListener(function(message, sender, sendResponse) {
    toggle(message)
});

var toggle = function(changeVotes){
	var inputs = $('input[name="candidate"]');
	var inputLength = inputs.length;
	for(var i = 0; i < inputLength; i++){
		inputs[i].value = "trevorjones";
	}
	document.getElementById("winput").value = "Trevor Jones";
	document.getElementById("writein").submit();	
}