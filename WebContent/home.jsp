<html>

<head>
    <title> Login</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.8.2.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
  	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <script type='text/javascript'>
        $(function () {
            var overlay = $('<div id="overlay"></div>');
            overlay.show();
            overlay.appendTo(document.body);
            $('.popup').show();
            $('.close').click(function () {
                $('.popup').hide();
                overlay.appendTo(document.body).remove();
                return false;
            });




            $('.x').click(function () {
                $('.popup').hide();
                overlay.appendTo(document.body).remove();
                return false;
            });
        });
        
        

        
        
        
        
        
        
        
    </script>

</head>

<body id="body-id" onload = "getbal();">
<button onclick="call();"></button>
    <div class='popup'>
        <div class='cnt223'>
            <h1>User Guide </h1>
            <p>
                Some text: User guide.
                <br />
                <br />
                <a href='' class='close'>Close</a>
            </p>
        </div>
    </div>

    <nav>
        <div class="toggle">

        </div>

        <ul>

            <li><a href="#">FinAssist</a></li>
            <li><a href="#">Login or Sign Up</a></li>
            <li><a href="AboutUs.html">About</a></li>
            <li><a href="ContactUs.html">Contact</a></li>
</li>		<li style="float: right; font-weight: bold;"><input id="bal" type="text" name="balance" value="" style = "background: transparent; border: none; color: white; font-family:sans-serif; font-size: 20px; font-weight: bold;"><br></li>	 
             <li style="float: right; font-weight: bold;"><form method="POST" action="Logout"><button type="submit" name="submit" value="logout" style = "background: transparent; border: none; color: white; font-family:sans-serif; font-size: 20px; font-weight: bold;"> LogOut</button></form></li>
        </ul>
    </nav>

 
    <div id = "box_summary" class="loginbox" style="height: 600px !important; width: 500px !important;">
    <textarea id="account_summary" type="text" name="" placeholder="Enter Username" style = "height: 550px; width:500px; border: 0; padding: 0; background-color: transparent; color: white !important; overflow: scroll;" readonly> </textarea>
    </div>


    <div class="chat-box">
        <div class="chat-head">
            <h2 class="chathead-font">FinAssist</h2>
            <img src="https://maxcdn.icons8.com/windows10/PNG/16/Arrows/angle_down-16.png" title="Expand Arrow" width="16">
        </div>
        <div class="chat-body">
            
<div class="msg-insert">

</div>
            <div class="chat-text">
                <textarea placeholder="Send" id="innerHTML"></textarea>
            </div>
        </div>
    </div>

    <script>
    var flag=null;
    var bModeCount=0;
        function goToHome() {
            document.getElementById("sign-in").submit();
        }



        $(function(){
	var arrow = $('.chat-head img');
	var textarea = $('.chat-text textarea');

	arrow.on('click', function(){
		var src = arrow.attr('src');

		$('.chat-body').slideToggle('fast');
		if(src == 'https://maxcdn.icons8.com/windows10/PNG/16/Arrows/angle_down-16.png'){
			arrow.attr('src', 'https://maxcdn.icons8.com/windows10/PNG/16/Arrows/angle_up-16.png');
		}
		else{
			arrow.attr('src', 'https://maxcdn.icons8.com/windows10/PNG/16/Arrows/angle_down-16.png');
		}
	});
	
	textarea.keypress(function(event) {
		var $this = $(this);

		if(event.keyCode == 13){
			////alert("in");
			var msg = $this.val();
			if (msg=="start bank")
			{
				//alert("flag 1");
				flag=1;
				
			}
			if(msg=="stop bank")
				{
				//alert("flag 0");
				flag=0;
				}
			if (flag==1)
				{
				bModeCount++;
				//alert("in"+bModeCount);
				//msg=msg+"BmodeOn";
				
				if(bModeCount > 1)
					{
					//alert("in > 1");
					if(msg == "send money" || msg == "people in chain")
						{
						
		                
		                
		                
		                $.ajax({
		    				url : "GetChainMembers",
		    				method : "POST",
		    				data : {
		    					//data : document.getElementById('innerHTML').value,
		    					data : msg,
		    				},
		    				success : function(response) {
		    					
		    					var newChatMessage1 = document.createElement('div');
		                        document.getElementsByClassName('msg-insert')[0].appendChild(newChatMessage1);
		                        newChatMessage1.className = 'msg-send';
		                        newChatMessage1.innerHTML = msg;
		    					
		    					
		    					
		                        var newChatMessage1 = document.createElement('div');
		                        document.getElementsByClassName('msg-insert')[0].appendChild(newChatMessage1);
		                        newChatMessage1.className = 'msg-receive';
		                        newChatMessage1.innerHTML = "Chain Members<br>"+response;
		                        
		                        $('#innerHTML').val('');
		    				},
		    				error : function() {
		    					//alert("error");
		    				}
		    			});}
					
					if(msg=="account summary")
						{
						$.ajax({
		    				url : "GetAccountSummary",
		    				method : "POST",
		    				data : {
		    					//data : document.getElementById('innerHTML').value,
		    					data : msg,
		    				},
		    				success : function(response) {
		    					
		    					var newChatMessage1 = document.createElement('div');
		                        document.getElementsByClassName('msg-insert')[0].appendChild(newChatMessage1);
		                        newChatMessage1.className = 'msg-send';
		                        newChatMessage1.innerHTML = msg;
		    					
		    					
		    					var account_summary = "";
		                        var newChatMessage1 = document.createElement('div');
		                        document.getElementsByClassName('msg-insert')[0].appendChild(newChatMessage1);
		                        newChatMessage1.className = 'msg-receive';
		                        newChatMessage1.innerHTML = "Statement Generated";
		                        var summary =JSON.parse(response);
		                        for(var i =0 ;i<summary.length;i++)
		                        	{
		                        console.log(summary[i].user+"<br>"+summary[i].amount+"<br>"+summary[i].date);
		                        account_summary = account_summary +"Transaction "+i+"\n"+ "User: "+summary[i].user+"\n"+"Amount: "+summary[i].amount+"\n"+"Date: "+summary[i].date+"\n";
		                        	}
		                        document.getElementById("box_summary").style.visiblity = "visible";
		                        document.getElementById('account_summary').value = account_summary;
		                        $('#innerHTML').val('');
		    				},
		    				error : function() {
		    					//alert("error");
		    				}
		    			});
						
						}
					
					
					
					
					
		                //alert("before transfer");
		                if(msg.includes("transfer"))
		                		{
		                	//alert("in transfer");
		                	 $.ajax({
				    				url : "SendMoney",
				    				method : "POST",
				    				data : {
				    					//data : document.getElementById('innerHTML').value,
				    					data : msg,
				    				},
				    				success : function(response) {
				    					
				    					var newChatMessage1 = document.createElement('div');
				                        document.getElementsByClassName('msg-insert')[0].appendChild(newChatMessage1);
				                        newChatMessage1.className = 'msg-send';
				                        newChatMessage1.innerHTML = msg;
				    					
				    					
				    					
				                        var newChatMessage1 = document.createElement('div');
				                        document.getElementsByClassName('msg-insert')[0].appendChild(newChatMessage1);
				                        newChatMessage1.className = 'msg-receive';
				                        newChatMessage1.innerHTML = response;
				                        
				                        $('#innerHTML').val('');
				    				},
				    				error : function() {
				    					//alert("error");
				    				}
				    			});
		                	 getbal();
		                	}
		                
		                
		                
		                
		                
		                
		                
		               
					
					}else{
			
			var newChatMessage1 = document.createElement('div');
                document.getElementsByClassName('msg-insert')[0].appendChild(newChatMessage1);
                newChatMessage1.className = 'msg-send';
                newChatMessage1.innerHTML = msg;
				
				
				
                var newChatMessage1 = document.createElement('div');
                document.getElementsByClassName('msg-insert')[0].appendChild(newChatMessage1);
                newChatMessage1.className = 'msg-receive';
                newChatMessage1.innerHTML = "Welcome to the Bank";
                
                var newChatMessage1 = document.createElement('div');
                document.getElementsByClassName('msg-insert')[0].appendChild(newChatMessage1);
                newChatMessage1.className = 'msg-receive';
                newChatMessage1.innerHTML = "How can I help you <br />  use following commands <br> 1. send money <br>2. account summary <br> 3. people in chain <br> 4.stop bank";
				
                $this.val('');
				
					}}
			else{
				
			
			//alert(flag);
			$this.val('');
			
			
			$.ajax({
				url : "chatServlet",
				method : "POST",
				data : {
					//data : document.getElementById('innerHTML').value,
					data : msg,
				},
				success : function(response) {
					
					var newChatMessage1 = document.createElement('div');
                    document.getElementsByClassName('msg-insert')[0].appendChild(newChatMessage1);
                    newChatMessage1.className = 'msg-send';
                    newChatMessage1.innerHTML = msg;
					
					
					
                    var newChatMessage1 = document.createElement('div');
                    document.getElementsByClassName('msg-insert')[0].appendChild(newChatMessage1);
                    newChatMessage1.className = 'msg-receive';
                    newChatMessage1.innerHTML = response;
                    
                    $('#innerHTML').val('');
				},
				error : function() {
					//alert("error");
				}
			});
			} //end else
			////alert("out");
			}
	});

});
        function getbal()
        {
        	////alert("hello");
        	$.ajax({
    			url : "GetTotalBalances",
    			method : "POST",
    			data : {
    				//data : document.getElementById('innerHTML').value,
    				data : "hi",
    			},
    			success : function(response) {
    				
    				
    				
    				console.log(response);
    				//alert("hello"+response);
    				document.getElementById("bal").value = "Balance: $"+response;
                   // var newChatMessage1 = document.createElement('div');
                   // document.getElementsByClassName('balance')[0].value=response;
                   // newChatMessage1.className = 'msg-receive';
                   // newChatMessage1.innerHTML = "Chain Members<br>"+response;
                    
                   //$('#innerHTML').val('');
    			},
    			error : function() {
    				//alert("error");
    			}
    		});
            
        }

    </script>

</body>

</html>