    function handleMessage(data) {
    	publisherSID = data.split('*')[1];
    	if (publisherSID != getJSessionId()){
    		PF('changeDlg').show();
    	}
    }
    
    function getJSessionId(){
        var jsId = document.cookie.match(/JSESSIONID=[^;]+/);
        if(jsId != null) {
            if (jsId instanceof Array)
                jsId = jsId[0].substring(11);
            else
                jsId = jsId.substring(11);
        }
        return jsId;
    }