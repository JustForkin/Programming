<?php
include "code_chart.php"; //

$address = $_GET["email"];
$error = $_GET["msg"];
				if ($error == 1)     //pwd recover email success             
					{
					echo "Email has been sent to "; echo $address; echo '<br /> <a href="index.php">Back to login</a>';
					}
				else if ($error == 2)    //send email fields invalid
					{
					echo "Please enter a valid username/email combination."; echo '<br /> <a href="recoverpwd.php">Back to password recovery</a>';
					}
				else if ($error == 3)    //new user form
					{
					echo "Please enter a username and email address."; echo '<br /> <a href="newaccount.php">Back to registration</a>';
					}
				else if ($error == 4)
					{
					echo "Please enter a password and confirm it."; echo '<br /> <a href="newaccount.php">Back to registration</a>';
					}
				else if ($error == 5)
					{
					echo "Please make sure your password values are the same."; echo '<br /> <a href="newaccount.php">Back to registration</a>';
					}
				else if ($error == 5.5)
					{
					echo "Please make sure your new password values are the same."; //echo '<br /> <a href="new_account.html">Back to registration</a>';
					}
				else if ($error == 5.6)
					{
					echo "Please make sure your new password values are the same."; echo '<br /> <a href="changepassword.php">Back to edit account</a>';
					}					
				else if ($error == 6)
					{
					echo "Username already exists. Please choose a different username."; echo '<br /> <a href="newaccount.php">Back to registration</a>';
					}
				else if ($error == 7)    //recover pwd form
					{
					echo "Please enter your username and email."; echo '<br /> <a href="recoverpwd.php">Back to password recovery</a>'; //?recovery?
					}				
				else if ($error == 8)   //login form
					{
					echo "Please input user name."; echo '<br /> <a href="index.php">Back to login</a>';
					}
				else if ($error == 9)
					{
					echo "Please input password."; echo '<br /> <a href="index.php">Back to login</a>';
					}	
				else if ($error == 10)
					{
					echo "Invalid user name. Please try again."; echo '<br /> <a href="index.php">Back to login</a>';
					}	
				else if ($error == 11)
					{
					echo "Invalid password. Please try again."; echo '<br /> <a href="index.php">Back to login</a>';
					}	
				else if ($error == 12)
					{
					echo "Email failed to send. Please try again"; echo '<br /> <a href="recoverpwd.php">Back to password recovery</a>';
					}
				else if ($error == 99)
					{
					echo "Please return to previous page and fill out all forms"; //echo '<br /> <a href="recoverpwd.php">Back to password recovery</a>';
					}
?>
<html>
	<head>
		<title>
		<?php
		if ($error == 1)
		echo "Message";
		else
		echo "Error!";
		?>
		</title>
		<link rel="stylesheet" type="text/css" href="chart_style.css" />       
	</head>
</html>