<?php 
	session_start();
	include "code_chart.php";
	checkLogin();   
	
	$username=$_POST['user_name'];
	$password=$_POST['pwd'];
	
	$username=stripslashes($username);
	$password=stripslashes($password);

	//check if all forms are filled
	if(isset($_POST['submit_login'])){
		if(empty($username)) 
		{
			master_redirect("Messages.php?msg=8");
			exit();
		}
		if(empty($password)) 
		{
			master_redirect("Messages.php?msg=9");
			exit();
		}
			
		loginUser($username, $password); //calls loginUser function
	}
	
	else master_redirect("index.php");

?>