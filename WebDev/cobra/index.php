<?php
	session_start();
	include "code_chart.php";
	checkLogin();
?>
<html>

	<head>
		<link rel="stylesheet" type="text/css" href="chart_style.css" /> 
		<meta name="description" content="Sleep chart website by Raanan Cohen and Michael Rubin" />
		<meta name="keywords" content="Sleep chart website by Raanan Cohen and Michael Rubin" />
		<title>Login</title>
		<h1 id = "pageTop"> Bedtime Star Chart </h1>
	</head>
	
	<body>
	
		<div id="stylized" class="myform" > 
			<form name="login" id="form" method="post" action="login.php" >  
				
				<!-- TRY with or without the h3 below -->
				<!-- <h3> Login </h3> -->
				
				<label for="one">Username:
				<!--<h4>Enter your name</h4>-->
				</label >
				<input type="text" name="user_name" id="one" maxlength="32" /> 
				
				<!--  TRY with or without the field below below (or any number of fields)  -->
				<!-- And with or without the 'h4' subtext in the span  -->
				
				<label for="two">Password:<!--<h4>Enter your name</h4>-->
				</label>
				<input type="password" name="pwd" id="two" maxlength="32" />	
				
				<button type="submit"  name="submit_login">Login</button>
				<!--<div class="spacer"></div>-->	
			</form>
		</div>
		
		<!--end of table begining of links for new account and recover password-->
		
		<div id="bottom" class="underForm" >
				<span class = "left"> <span class="small">Don't have an account?</span> 
				</br>
				<a href="newaccount.php">Create one.</a>
				</span>
		
			<div id="bar" class="small" > </div>
		
				<span class="right"><span class="small">Forgot your password?</span> 
				</br>
				<a href="recoverpwd.php">Recover it.</a>
				</span>
		</div>
		
		
		
		
		
		
	</body>
</html>