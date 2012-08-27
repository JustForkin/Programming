<?php
session_start();
include "code_chart.php";
checkNotLogin(); //
?>

<html>
	
	<head>
		<link rel="stylesheet" type="text/css" href="chart_style.css" />  
		<title>Edit account</title>
		
		<a href="main_page.php" class="leftlink">home</a> 
		<a href="logout.php" class="rightlink">logout</a> 
		
			
		<h2>Edit account</h2>
		
		
	</head>
	
	
	
	<body>
		<div id="stylized" class="myform" > 
			<form name="edit_password" id="form" method="post" action="change_password.php" >
				
				<!-- TRY with or without the h3 below -->
				<h3> Change Password </h3>
				
					<label for="one"> Current password: </label>  
					<input type="password" name="pwd0" id="one" maxlength="32" />
						
					<label for="two"> New password: </label>
					<input type="password" name="pwd1" id="two" maxlength="32" />
					
					<label for="three"> New password confirm: </label>
					<input type="password" name="pwd2" id="three" maxlength="32" />
						
						
					<button type="submit" name="submit_change" >Update</button>
				
			</form>
		</div>
		
		<?php 
		if($_SESSION['password_changed']==1) 
		{
		echo '<div style="position:relative; top:10; " class="spacer">Your password has been updated.</div>'; 
		$_SESSION['password_changed']=0;
		}
		else 
		{
		echo '<div style="position:relative; top:10; " class="spacer"></div>';
		}
		?>
		
		<!-- <div class="spacer"></div>  -- ********************* puts space between the two forms -->
		
		<div id="stylized" class="myform" > 
			<form name="edit_email" id="form" method="post" action="change_email.php">
				<h3> Change Email </h3>						
				
						<label for="one"> New email: </label>
						<input type="text" name="email" id="one" maxlength="32" />
						
						<label for="two"> Confirm new email: </label>
						<input type="text" name="email2" id="two" maxlength="32" />
						
						<label for="three">Password: </label>
						<input type="password" name="password" id="three" maxlength="32" />
						
					
						<button type="submit" name="submit_change"> Update </button>
					
			</form>
		</div>
		
		<?php
		if($_SESSION['email_changed']==1) 
		{
		echo '<div style="position:relative; top:10;" class="spacer">Your email has been updated.</div>'; 
		$_SESSION['email_changed']=0;		
		} 
		else
		{
		echo '<div style="position:relative; top:10;" class="spacer"></div>';
		}
		?>
		
	</body>
</html>
		
	