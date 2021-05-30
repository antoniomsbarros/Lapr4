
// IMPORTANT: notice the next request is scheduled only after the
//            previous request is fully processed either successfully
//	      or not.

function refreshActivitys() {
	var request = new XMLHttpRequest();
        var vBoard=document.getElementById("atividade");
        
        request.onload = function() {
            vBoard.innerHTML = this.responseText;
            vBoard.style.color="black";
            setTimeout(refreshActivitys, 2000);
            };
            
        request.ontimeout = function() {
            vBoard.innerHTML = "Server timeout, still trying ...";
            vBoard.style.color="red";
            setTimeout(refreshActivitys, 100);
        };
        
        request.onerror = function() { 
            vBoard.innerHTML = "No server reply, still trying ...";
            vBoard.style.color="red";
            setTimeout(refreshActivitys, 5000);
        };
        
  	request.open("GET", "/atividade", true);
	request.timeout = 5000;
  	request.send();

	}

	

