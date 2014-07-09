chrome.extension.onMessage.addListener(function(request, sender, sendResponse) {
    if (request == "change"){
        chrome.tabs.getSelected(null, function(tab){
    		chrome.tabs.sendMessage(tab.id, true);
		});
	} else if (request == "normal"){
        chrome.tabs.getSelected(null, function(tab){
    		chrome.tabs.sendMessage(tab.id, false);
		});
    }
});