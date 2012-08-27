<?php
include "code_master.php";

$rowSize = 6;
$colSize = 7;
$neededToWin = 4;

function resetBoard()
{
	runSQLNonQuery("UPDATE Boards SET Val = 'w'");
}

function placePiece($column, $value)
{
	//1. Find out if that column is full. If it is return false
		$result = runSQLQueryScalar("SELECT MAX(Row) FROM Boards WHERE Col = " . $column . " AND Val = 'w'");
	if (sizeof($result) == 0) //There is no row returned
		return false;
	
	//2. Assuming it's not full put the value in the next available slot
	$SQL = "UPDATE Boards SET Val = '" . $value . "' WHERE Row = " . $result . " AND Col = " . $column;
	runSQLNonQuery($SQL);
	
	//3. Return true to assure it has been done correctly
	return true;
}

function checkWin()
{
	$rowSize = 6;
	$colSize = 7;
	$neededToWin = 4;
	$soFar = 0;
	$currentColor = 'w';
	$board = getCurrentBoard();
	$tie = true;
	
	for ($i=0; $i<$rowSize; $i++)
	{
		for ($j=0; $j<$colSize; $j++)
		{
			$current = $board[$i][$j];
			if($current == 'w')
			{
				$tie = false;
				$currentColor = 'w';
				$soFar = 0;
			}
			else
			{
				if($current == $currentColor)
				{
					$soFar++;
				}
				else
				{
					$currentColor = $current;
					$soFar = 1;
				}
			}
			if($soFar == $neededToWin)
				return $current;
		}
		$currentColor = 'w';
		$soFar = 0;
	}
	
	for ($k=0; $k<$colSize; $k++)
	{
		for ($l=0; $l<$rowSize; $l++)
		{
			$current = $board[$l][$k];
			if($current == 'w')
			{
				$tie = false;
				$currentColor = 'w';
				$soFar = 0;
			}
			else
			{
				if($current == $currentColor)
				{
					$soFar++;
				}
				else
				{
					$currentColor = $current;
					$soFar = 1;
				}
			}
			if($soFar == $neededToWin)
				return $current;
		}
		$currentColor = 'w';
		$soFar = 0;
	}	
///////////////////	

	$canwin = true;
	$canwind = true;
	for ($i = 0; $i <= ($rowSize - $neededToWin); $i++) 
	{ 
		for ($j = 0; $j <= ($colSize - $neededToWin); $j++) 
		{
			$canwin = true;
			$canwind = true;
			$currentColor = $board[$i][$j];
			if($currentColor == 'w')
			{
				$canwin = false;
				$canwind = false;
			}
			for ($k = 1; $k<$neededToWin && $canwin; $k++)
			{
				if ($board[$rowSize-($i+$k)][$j-$k] != $currentColor)
					$canwind = false;
				if ($board[$i-$k][$j-$k] != $currentColor)
					$canwin = false;
			}	
			if ($canwin || $canwind)
				return $currentColor;
		}
	}
/////
	
///////////////
	
	if($tie)
		return "T";
	return "C";
}


/*
function switchTurns()
{
	//1. If it is Red's turn, change to black, and vice versa 
	$result = runSQLQuery("SELECT Val FROM `Status` WHERE `StatusName` = 'Turn'", false);
	$nextTurn = 'R';
	if ($result[0][0] == 'R')
		$nextTurn = 'B';
	runSQLNonQuery("UPDATE Status SET Val = '" . $nextTurn . "' WHERE StatusName = 'Turn'");
	return $nextTurn; 
}
*/


function whoseTurn()
{
	$R = runSQLQueryScalar("SELECT COUNT(*)  FROM Boards WHERE Val = 'R'");
	$B = runSQLQueryScalar("SELECT COUNT(*)  FROM Boards WHERE Val = 'B'");
	if($R == $B)
		return 'R';
	return 'B';
}



function getCurrentBoard()
{
$rowSize = 6;
$colSize = 7;
	$SQL = "SELECT Row, Col, Val FROM `Boards` ORDER BY Row, Col";
	$result = runSQLQuery($SQL, true);
	$i = 0;
	for($row = 0; $row < $rowSize; $row++)
	{
		for($col = 0; $col < $colSize; $col++)
		{
			$ret[$row][$col] = $result[$i]['Val'];
			$i++;
		}
	}
	return $ret;
}

?>