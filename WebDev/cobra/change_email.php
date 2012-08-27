<?php
	session_start(); 
	include "code_chart.php"; //
	
	checkNotLogin();
	
	$username=$_SESSION['username'];
	$email=$_POST['email'];
	$email2=$_POST['email2'];
	$pwd=$_POST['password'];
	//prevent mysql injection 
	$email=stripslashes($email);
	$email2=stripslashes($email2);
	$pwd=stripslashes($pwd);
		
	if(isset($_POST['submit_change'])){
		//NEED TO CHECK IF FIELDS ARE FILLED IN
		if( !isset($email) || !isset($email2) || !isset($pwd) ){
		master_redirect("Messages.php?msg=99"); 
		exit();
	}	

		$SQL1="SELECT password FROM users WHERE username='$username';";  //retrieves password
		$SQL2="UPDATE users SET  email =  '$email' WHERE username = '$username' AND password = '$pwd';";  //updates email
		
		if ($email!==$email2){
			master_redirect("Messages.php?msg=5.6"); 
			exit();
		}
		else{
			if ($pwd==runSQLQueryscalar($SQL1)){
				runSQLNonQuery($SQL2);
				$_SESSION['email_changed']=1;  //allows print statement on editaccount
				master_redirect("editaccount.php");	
			}
			else{
				master_redirect("Messages.php?msg=11"); 
				exit();
			}
		}
		
	}	
	else{
		master_redirect("mainpage.php");
	}
	
?>




