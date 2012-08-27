<?php
session_start();
include "code_chart.php";
//include "fns.php";        // ????
//include "config.php";
checkLogin();

$rec_user=$_POST['rec_user'];
$rec_email=$_POST['rec_email'];
//prevent mysql injection 
$rec_user=stripslashes($rec_user);
$rec_email=stripslashes($rec_email);  

if(isset($_POST['submit_query'])){
//1. Check if form fields are filled in
	if(empty($rec_user) || (empty($rec_email))){
	master_redirect("Messages.php?msg=7" ); 
	exit();
	}

sendEmail($rec_user, $rec_email);
}

else master_redirect("recoverpwd.php");

?>