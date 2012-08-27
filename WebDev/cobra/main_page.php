<?php 
	session_start(); 
	include "code_chart.php";
	checkNotLogin();
	
		//the first time the page opens it will execute the "else"
		//after hitting one of the submit boxes the proper if/elseif should execute
		if(isset($_GET['edit_account'])){
			$_SESSION['password_changed']=0;
			master_redirect("editaccount.php");
		}
		elseif(isset($_GET['edit_sleep']))
			echo 'under development';
		elseif(isset($_GET['view_data']))
			echo 'under development';
		else{
			master_redirect("mainpage.php");
			echo $file;
		}	
?>

<!-- when pages are constructed it won't be part of site
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="chart_style.css" />
	</head>
</html>
-->