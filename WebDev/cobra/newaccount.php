<?php
	session_start();
	include "code_chart.php";
	checkLogin();
?>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="chart_style.css" />   
		<title>Create new account</title>
		
		
		<h2>New Account</h2>
		
		
		
			<a href="index.php" class="leftlink">back to login</a> 
		
		
	</head>
	<body>
		
		<div id="stylized" class="myform" > 
			<form id="form" name="create_new" method="post" action="new_account.php"  >  
			
				<!--<h3>Titleeee</h3>-->
			
				<label for="one"> Username:
				<!--<h4>password will be sent here</h4>-->
				</label>
				<input type="text" name="user_name" id="one" maxlength="32" />
				
				<label for="two"> Password:
				</label>
				<input type="password" name="pwd1" id="two" maxlength="32" />
				
				<label for="three"> Password Confirm:
				</label>
				<input type="password" name="pwd2" id="three" maxlength="32" />
				
				<label for="four"> Email Address:
				</label>
				<input type="text" name="email" id="four" maxlength="32" />
					
				<button type="submit" name="submit_login">Create new account</button>
				<!--<div class="spacer"></div>	-->
			</form>
		</div>	
		
	</body>
</html>