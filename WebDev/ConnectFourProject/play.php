<?php
include "code_board.php";
ob_start();
/*
if(!isset($_POST["c"]))             ////////////
	die "Please declare a color";   //////////
*/
////////////
$whoseTurn =  whoseTurn();
$winner = checkWin();
if(isset($_GET['winner']))
	$winner = $_GET['winner'];
	?>

<html>
	<head>
	<link rel="stylesheet" type="text/css" href="connectFour.css" />
	</head>
	<body>

<!----------------------------------------------------------------------------------------------------------------->
<!----------------------------------------------------------------------------------------------------------------->
<!--  target buttons drop() Function:says where you dropped,& makes ColumnClicked or says its full ---------------->
<!----------------------------------------------------------------------------------------------------------------->
<script language="javascript" type="text/javascript">
	function drop(clicked)
	{
		if (myBoard[0][clicked]=='w')              ////////////5/////////
		{
			//good placement
			var frm = document.getElementById('frmSubmitMove');
			frm.ColumnClicked.value = clicked;
			frm.submit();
		}
		else
		{
			//bad placement
			alert("You cannot go there!");
		}
	}
	function getBoard()
	{<?php
	$board = getCurrentBoard();
	echo "return new Array(";
	for($row = 0; $row < 6; $row++)
	{
		echo "new Array(";
		for($col = 0; $col < 7; $col++)
		{
			echo "'";
			echo $board[$row][$col];
			echo "'";
			if($col < 6)
				echo ",";
		}
		echo ")";
		if($row < 5)
			echo ",";
	}
	echo ");";
	?>}
</script>
<!-------------------------------------------------------->
<!-------------------------------------------------------->
<!--  Sends ColumnClicked to C4Submit.php page        ---->
<!-------------------------------------------------------->
<div style="display: none">
<form method="GET" action="C4Submit.php"  id="frmSubmitMove">
<input type="text" name="ColumnClicked" id="txtColumnClicked" value="-1" />
<input type="text" name="activeColor" value="<?php echo  $whoseTurn ?>" />            <!------------- ??? ----------------->
</form>
</div>
<!-------------------------------------------------------->
<!-------------------------------------------------------->
<!-- Actual TARGETS which Run drop()   ------------------->
<!-------------------------------------------------------->
			<span id="targets" >
				<br><br>
				<a href="javascript:drop(0)"><img border="0" src="target.jpg" height="30" width="30" style="position:absolute; top:15px; left:75px;"></a>
				<a href="javascript:drop(1)"><img border="0" src="target.jpg" height="30" width="30" style="position:absolute; top:15px; left:115px;"></a>
				<a href="javascript:drop(2)"><img border="0" src="target.jpg" height="30" width="30" style="position:absolute; top:15px; left:155px;"></a>
				<a href="javascript:drop(3)"><img border="0" src="target.jpg" height="30" width="30" style="position:absolute; top:15px; left:195px;"></a>
				<a href="javascript:drop(4)"><img border="0" src="target.jpg" height="30" width="30" style="position:absolute; top:15px; left:235px;"></a>
				<a href="javascript:drop(5)"><img border="0" src="target.jpg" height="30" width="30" style="position:absolute; top:15px; left:275px;"></a>
				<a href="javascript:drop(6)"><img border="0" src="target.jpg" height="30" width="30" style="position:absolute; top:15px; left:315px;"></a>
			</span>
			
<!-------------------------------------------------------->
<!-------------------------------------------------------->
<!-- Win/Lose BANNERS ------------------------------------>			
<!-------------------------------------------------------->
<h1 style="display:none; color: blue;" id="win">YOU WIN!  :)</h1>
<h1 style="display:none; color: red;" id="lose">YOU LOSE!  :(</h1>	
		
	<script language="javascript" type="text/javascript">

			//PHP must be used here
			<?php
//<!-------------------------------------------------------->
//<!-------------------------------------------------------->
//<!--   TURNS   ------------------------------------------->	
//<!-------------------------------------------------------->		
				//Is it my turn?
				//Ask code_board whose turn it is
				//Now that I know, is it my turn?
				//echo "var myTurn = true;";
				$color = $_GET["color"];
				if ($color == $whoseTurn)
					{
					//echo "R";
					echo "var myTurn = true;";
					}
				else 
					{
					//echo "B";
					echo "var myTurn = false;";
					}
//<!-------------------------------------------------------->			
//<!-------------------------------------------------------->			
//<!--  MAKES ARRAY  --------------------------------------->			
//<!-------------------------------------------------------->
	////
			
				echo "\n\t\tvar activeColor = '" . $whoseTurn . "';";
				echo "\n\t\tvar youWin = " . ($winner == $color ? "true" : "false") . ";";
				echo "\n\t\tvar youLose = " . ($winner != $color && $winner != 'C' ? "true" : "false")  . ";";
				echo "\n\t\tvar myBoard = getBoard();";
				
					
			?> 

<!-------------------------------------------------------->
<!-------------------------------------------------------->
<!-- REVEAL Win/Lose Banners ----------------------------->
<!-------------------------------------------------------->
			
			if(youWin == true) {
				document.getElementById("win").style.display="block";
			}
			if(youLose == true) {
				document.getElementById("lose").style.display="block";
			}
<!----------------------------------------------------------->
<!----------------------------------------------------------->			
<!-- shows targets, etc. Depending on Whose Turn it is ----->
<!----------------------------------------------------------->
			if (myTurn == false)
			{
				document.write("Waiting for your opponent... <br><br>".bold());
				document.getElementById("targets").style.display="none";
				setTimeout("location.reload(true);",5000); 
			}
<!----------------------------------------------------------------------------------------->
<!----------------------------------------------------------------------------------------->			
<!-- CREATES board, gives IDs, and changes Background Color based on array value   -------->
<!----------------------------------------------------------------------------------------->
document.write("<table id=\"tblBoard\">");
   for(var row = 0; row < 6; row++)
   {
       document.write("<tr>");
       for(var col = 0; col < 7; col++)
       {
           document.write("<td id=\"r" + row + "c" + col + "\">&nbsp;");
           //document.write("this is row " + row + ", column " + col);
           document.write("</td>");
       }
       document.write("</tr>");
   }
   document.write("</table>");
			for(var row = 0; row < 6; row++){
				for(var col = 0; col < 7; col++) {
					var thisCell = document.getElementById("r" + row + "c" + col);
					if(myBoard[row][col] == "w")
						thisCell.style.backgroundColor = "white";
					if(myBoard[row][col] == "R")
						thisCell.style.backgroundColor = "red";
					if(myBoard[row][col] == "B")
						thisCell.style.backgroundColor = "black";	
				}
			}
		
	</script>
<!-------------------------------------------------------->
<!-------------------------------------------------------->
<!-- RESET button----------------------------------------->		
<!-------------------------------------------------------->
		<button value="Reset" style="margin-left:160; margin-top:200; left:50px; top:50px; " onclick="window.location = 'reset.php'" >	
		<img src="target.jpg" style="height:15; width:15;" />
		Reset
		<img src="target.jpg" style="height:15; width:15;" />
		</button>
		
	</body>
</html>