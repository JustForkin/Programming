<?php
	session_start();
	include "code_chart.php";
	checkLogin();
?>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="chart_style.css" /> 
		<title>Password recovery</title>                           <!--maybe change wording throughout because it's really making a NEW pword-->
		
		<h2>Recover Password</h2>
		
		
		
			<a href="index.php" class="leftlink">back to login</a> 
		
	</head>
	
	<body>
		
			<div id="stylized" class="myform" > 
			<form name="pwdform" id="form" name="login" method="post" action="recover_pwd.php" >  
				<label for="one"> Username:
				<!--<h4>password will be sent here</h4>-->
				</label>
				<input type="text" name="rec_user" id="one" maxlength="32" />
				
				<label for="two"> Email:
				<h4>Password will be sent here</h4>
				</label>
				<input type="text" name="rec_email" id="two" maxlength="32" />
				
				<button type="submit" name="submit_query">Retrieve password</button>
					
			</form>
			</div>
			
	</body>
</html>