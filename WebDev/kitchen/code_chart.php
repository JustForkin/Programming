<?php
include "code_master.php";
//checkLogin();
//checkNotLogin();


function logged()
{
	return (isset($_SESSION['username']) && ($_SESSION['status'] == 'logged') );
}

function checkNotLogin()  //redirects if not logged
{
	if (!logged() )
	{
		master_redirect("index.php");
		exit();
	}
}

function checkLogin()  // redirects if logged
{
	if (logged() )
	{
		master_redirect("mainpage.php");
		exit();
	}
}

function reserveMeal($username, $password, $meal, $date){
	//code injection defender
	$username=stripslashes($username);
	$password=stripslashes($password);
	//gets username and password
	$SQL="SELECT name, password FROM userdata WHERE name='$username';";
	$result=runSQLQuery($SQL, false);
	
	if(empty($result))
		master_redirect("Messages.php?msg=10");
	else{
		if($password==$result[0][1]) {
			echo "Welcome " .$result[0][0]. "! <br/> You have booked your meal on ";
			
			//session_start();
			//$_SESSION['username'] = $username;
			//$_SESSION['status'] = 'logged';
			$SQL = "select count(mealid) from mealchart where date = STR_TO_DATE('$date', '%m/%d/%Y') and meal = '$meal';";
			if(runSQLQueryScalar($SQL) == 0)
			{
				book($username, $meal,  $date);
 				
				echo '<html>';
				echo '   <script type="text/javascript">';
				$SQL = "select meal from userdata as a join mealchart as b on a.id = b.id where date = STR_TO_DATE('$date', '%m/%d/%Y') and meal = '$meal' limit 1;";
				$mealBooked = runSQLQueryScalar($SQL);

				$SQL2 = "select date from userdata as a join mealchart as b on a.id = b.id where date = STR_TO_DATE('$date', '%m/%d/%Y') and meal = '$meal' limit 1;";
				$dateBooked = runSQLQueryScalar($SQL2);
				//$dateBooked = DATE_FORMAT('$dateBooked', '%m/%d/%Y');

				echo "   alert(\"$mealBooked booked on $dateBooked\");";

				echo '   </script>';
				echo '</html>';
				

			}
			else
			{
				echo '<html>';
				echo '   <script type="text/javascript">';
				$SQL = "select name from userdata as a join mealchart as b on a.id = b.id where date = STR_TO_DATE('$date', '%m/%d/%Y') and meal = '$meal' limit 1;";
				$booker = runSQLQueryScalar($SQL);
				echo "   alert(\"Meal already booked by $booker\");";

				echo '   </script>';
				echo '</html>';

			}
/////////////////////master_redirect("ReserveKitchen.php");  //?myuser=$username
			}
		else
			master_redirect("Messages.php?msg=11");
	}
}


function book($username, $meal,  $date){  //*** SIMILAR TO FUNcTION BELOW it **** 
	 $username = stripslashes($username);
	 $meal = stripslashes($meal);
	 $date  = stripslashes($date);
	 $SQL = "insert into mealchart values  (null, (select id from userdata where name = '$username') ,'$meal', STR_TO_DATE('$date', '%m/%d/%Y'), now());";
	 runSQLNonQuery($SQL);
}


function newUser($new_username, $new_pwd1, $new_pwd2, $new_email){
       //prevent mysql injection
       $new_username=stripslashes($new_username);
       $new_pwd1=stripslashes($new_pwd1);
       $new_pwd2=stripslashes($new_pwd2);
       $new_email=stripslashes($new_email);

       if("$new_pwd1" !== "$new_pwd2"  ){           //if confirm pwd doesn't match,
       master_redirect("Messages.php?msg=5");     //takes you to error page
       exit();                                      //instead of performing function
       }

       $SQL=("SELECT * FROM users WHERE username='$new_username'");
       $result=runSQLQuery($SQL, false);
       $count = count($result);

       if ($count > 0) {//Username already exist
       master_redirect("Messages.php?msg=6");
       exit();
       }else{
       $SQL1 = "INSERT INTO `famil85_mrproject`.`users` (`id`, `username`, `password`, `email`) VALUES ('', '$new_username', '$new_pwd1', '$new_email');";
       runSQLNonQuery($SQL1);
       $SQL2 = "CREATE TABLE  `famil85_mrproject`.`$new_username` (`targetBedTime` TIME NOT NULL , `actualBedTime` TIME NOT NULL , `date` DATE NOT NULL)";
       runSQLNonQuery($SQL2);

       //master_redirect("login.html");
       }
}

function sendEmail($rec_user, $rec_email) {

	$SQL=("SELECT password FROM users WHERE username='$rec_user' AND email='$rec_email'");
	$result=runSQLQueryScalar($SQL);
	//$count = count($result);
	
	if ( empty($result) ) {  //Username/email combo doesn't exist
	master_redirect("Messages.php?msg=2"); 
	exit();
	}
	
	else{                    
	//for ($i=0; $i<count($result); $i++) {                         /////
	//
	//$row = mysql_fetch_assoc($result);   
	//$pass=$row['password'];
		$pass = "$result";     //[0][1] ??
		$to="$rec_email";
		$from="From: Admin@SleepChart.com";
		$msg="Password: $pass";
		//$msg .="Username:$rec_user";
		//$msg .="Please change your password as soon as you logon";
		$subject="From Admin re:Your Login Password";
		//}   //
	//}

	// Send password to user
	//mail($to,$subject,$msg,$from);   //???    llllllllllllllllllkhi
	
		if(mail($to,$subject,$msg,$from)){
			master_redirect("Messages.php?msg=1&email=$rec_email" );
			exit();
		//echo "Please click here to log";
		}
		else{
			master_redirect("Messages.php?msg=12"); 
			exit();
		}
	//}
	}
}

?>