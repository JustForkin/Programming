<html>
  <body>
    <form action="./reserve.php" method="post" id="form">
      <input type="radio" name="meal" value="Lunch" checked="yes" /> lunch<br />
      <input type="radio" name="meal" value="Dinner" /> dinner<br  />
      Month:<br  />
      <select name="month">
         <option value="01">Jan</option>
         <option value="02">Feb</option>
         <option value="03">Mar</option>
         <option value="04">Apr</option>
         <option value="05">May</option>
         <option value="06">Jun</option>
         <option value="07">Jul</option>
         <option value="08">Aug</option>
         <option value="09">Sep</option>
         <option value="10">Oct</option>
         <option value="11">Nov</option>
         <option value="12">Dec</option>
      </select><br />
      <?php
         echo 'Day:<br />';
         echo '<select name="day">';
         for ($i = 1; $i <=31; $i++) {
              print "    <option value=\"";
          	if($i < 10) {
			echo "0$i\">0$i</option>";
		}
		else {
			echo "$i\">$i</option>";
       	}
	  }
         echo "</select><br />";
        echo 'Year:<br />';
        $year = 2012;
        $numberOfYears = 5;
        echo ' <select name="year">';
                 echo "    <option value=\"$year\" default>2012</option>";
                for ($i = $year+1; $i <= $year + $numberOfYears; $i++) {
                echo "    <option value=\"$i\">$i</option>";
         }
         echo "</select><br />";
        ?>
      Username: <input type="username" name="username" /><br />
      Password: <input type="password" name="password" /><br />
      <input type="submit" value="BOOK IT" name="reserve" />
    </form>
  </body>
</html>




