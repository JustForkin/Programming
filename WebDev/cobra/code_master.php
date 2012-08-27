<?php

	

function master_redirect($newURL)
{
	header('Location:' . $newURL);
}

//Use this function for SELECT queries
//If $useColumnNames is true, return the array with column names for reference
//If $useColumnNames is false, return the array with columns by index
function runSQLQuery($SQL, $useColumnNames)
{
	//Set the values for connecting to the database
	$db_serverName = getServerName();
	$db_username = getUsername();
	$db_password = getPassword();
	$db_dbName = getDbName();
	$ret = array();
	$connection = mysql_connect($db_serverName, $db_username, $db_password) or die("HELP! BAD CONNECTION");
	mysql_select_db($db_dbName);
	$process = mysql_query($SQL, $connection)  or die("HELP! BAD SQL = '" . $SQL . "'");
	$columnCount = mysql_num_fields($process);
	$columnNames = array();
	if($useColumnNames)
	{
		for($i = 0; $i < $columnCount; $i++)
			$columnNames[] = mysql_field_name($process, $i);
	}
	for($rowCount = 0; $rowCount < mysql_num_rows($process); $rowCount++)
	{
		for($i = 0; $i < $columnCount; $i++)
		{
			if($useColumnNames)
				$ret[$rowCount][$columnNames[$i]] = mysql_result($process, $rowCount, $i);
			else
				$ret[$rowCount][$i] = mysql_result($process, $rowCount, $i);
		}
	}
	mysql_close($connection);
	return $ret;
}

//Use this function for SELECT queries that are SURE to return JUST ONE VALUE
function runSQLQueryScalar($SQL)
{
	$result = runSQLQuery($SQL, false);
	return $result[0][0];
}

//Use this function for INSERT queries in tables with auto_increment
//It will return the new auto_increment ID of the row
function runSQLQueryWithIdentity($SQL)
{
	//Set the values for connecting to the database
	$db_serverName = getServerName();
	$db_username = getUsername();
	$db_password = getPassword();
	$db_dbName = getDbName();
	$connection = mysql_connect($db_serverName, $db_username, $db_password);
	mysql_select_db($db_dbName);	
	mysql_query($SQL, $connection);
	$ret = mysql_insert_id();
	mysql_close($connection);
	return $ret;
}

//Use this function for INSERT, UDPATE or DELETE queries (amongst others)
//IT does not return anything :-(
function runSQLNonQuery($SQL)
{
	//Set the values for connecting to the database
	$db_serverName = getServerName();
	$db_username = getUsername();
	$db_password = getPassword();
	$db_dbName = getDbName();
	$connection = mysql_connect($db_serverName, $db_username, $db_password) or die("ERROR1! " . mysql_error());
	mysql_select_db($db_dbName);
	mysql_query($SQL, $connection) or die("ERROR2! " . mysql_error());
	mysql_close($connection);
}

function getServerName() { return "localhost"; }
function getUsername() { return "famil85_userone"; }
function getPassword() { return "doesntmatter"; }
function getDbName() { return "famil85_mrproject"; }
?>