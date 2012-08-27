<?php
	include "code_board.php";
	ob_start();
	
	$col = $_GET['ColumnClicked'];
	$val = $_GET['activeColor'];
	
	placePiece($col, $val);
	
	$forwardTo = "play.php?color=" . $val;
	header("Location:$forwardTo");

?>