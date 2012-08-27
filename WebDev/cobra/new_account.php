<?php
include "code_chart.php";
session_start();
checkLogin(); //


$new_username=$_POST['user_name'];
$new_pwd1=$_POST['pwd1'];
$new_pwd2=$_POST['pwd2'];
$new_email=$_POST['email'];

$new_username=stripslashes($new_username);
$new_pwd1=stripslashes($new_pwd1);
$new_pwd2=stripslashes($new_pwd2);
$new_email=stripslashes($new_email);

/*
$new_username=mysql_real_escape_string($new_username);
$new_pwd1=mysql_real_escape_string($new_pwd1);
$new_pwd2=mysql_real_escape_string($new_pwd2);
$new_email=mysql_real_escape_string($new_email);
*/

if(isset($_POST['submit_login'])){
//NEED TO CHECK IF FIELDS ARE FILLED IN
	if( empty($new_username) || empty($new_email)  ){
	master_redirect("Messages.php?msg=3"); 
	exit();
	}
	if( empty($new_pwd1) || empty($new_pwd2) ){
	master_redirect("Messages.php?msg=4"); 
	exit();
	}


newUser($new_username, $new_pwd1, $new_pwd2, $new_email);
loginUser($new_username, $new_pwd1);
}
else master_redirect("newaccount.php");

?>

