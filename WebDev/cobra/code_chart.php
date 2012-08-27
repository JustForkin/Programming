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

function loginUser($username, $password){
	//code injection defender
	$username=stripslashes($username);
	$password=stripslashes($password);
	//gets username and password
	$SQL="SELECT username, password FROM users WHERE username='$username';";
	$result=runSQLQuery($SQL, false);
	
	if(empty($result))
		master_redirect("Messages.php?msg=10");
	else{
		if($password==$result[0][1]) {
			//echo "Welcome " .$result[0][0]. "! <br/> You have logged in!";
			session_start();
			$_SESSION['username'] = $username;
			$_SESSION['status'] = 'logged';
			master_redirect("Main_page.php");  //?myuser=$username
			}
		else
			master_redirect("Messages.php?msg=11");
	}
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