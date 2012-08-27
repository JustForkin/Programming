<?php
	session_start(); 
	//include "code_master.php"; //enables Mo's functions to be used
	include "code_chart.php";
	
	checkNotLogin();
	
	
	$username=$_SESSION['username'];
	$old_pwd=$_POST['pwd0'];
	$new_pwd1=$_POST['pwd1'];
	$new_pwd2=$_POST['pwd2'];
	//prevent mysql injection 
	$old_pwd=stripslashes($old_pwd);
	$new_pwd1=stripslashes($new_pwd1);
	$new_pwd2=stripslashes($new_pwd2);
		
	if(isset($_POST['submit_change'])){
		//NEED TO CHECK IF FIELDS ARE FILLED IN
		if( !isset($old_pwd) || !isset($new_pwd1) || !isset($new_pwd2) ){
		master_redirect("Messages.php?msg=99"); 
		exit();
		}
		
		$SQL1="SELECT password FROM users WHERE username='$username';";  //retrieves pwd
		$SQL2="UPDATE users SET  password =  '$new_pwd1' WHERE username = '$username' AND password = '$old_pwd';"; //updates pwd

		if ($new_pwd1!==$new_pwd2){
			master_redirect("Messages.php?msg=5.6"); 
			exit();
		}
		else{
			if ($old_pwd==runSQLQueryscalar($SQL1)){
				runSQLNonQuery($SQL2);
				$_SESSION['password_changed']=1;  //allows print statement on editaccount
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




