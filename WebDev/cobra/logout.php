<?php
//include "code_master.php";  causes error with code_chart also included
include "code_chart.php";
session_start();

if(logged() ) 
{
session_unset(); 
session_destroy();
//master_redirect("index.php" );   // .php?reg=2
//exit();
} 

master_redirect("index.php" ); 
exit();


?>
