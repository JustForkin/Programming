<?php
include "code_chart.php";

$error = $_GET["msg"];
        if  ($error == 8)
        {
		echo "Please input user name."; 
		echo '<br /> <a href="ReserveKitchen.php">Back to booking</a>';
	}
	else if ($error == 9)
    	{
		echo "Please input password."; 
		echo '<br /> <a href="ReserveKitchen.php">Back to booking</a>';
	}    
	else if ($error == 10)
	{
		echo "Invalid user name. Please try again."; 
		echo '<br /> <a href="index.php">Back to login</a>';
   	}
	else if ($error == 11)
	{
		echo "Invalid password. Please try again."; 
		echo '<br /> <a href="index.php">Back to login</a>';
  	}

?>
<html>
	<head>
		<title>
			<?php
			//if ($error == 1)
	   		//echo "Message";
			//else
			echo "Error!";
			?>
			</title>
			<!--<link rel="stylesheet" type="text/css" href="chart_style.css" /> -->	
	</head>
</html>