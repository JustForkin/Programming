<html> 
	<form id="form" name="set_time" method="post" action="st.php" >
	
		<select name="day">
			<option value="sunday">Sunday</option>
			<option value="monday">Monday</option>
			<option value="tuesday">Tuesday</option>
			<option value="wednesday">Wednesday</option>
			<option value="thursday">Thursday</option>
			<option value="friday">Friday</option>
			<option value="saturday">Saturday</option>
		</select>

		<select name="hour">
			  <option value="1">1</option>
			  <option value="2">2</option>
			  <option value="3">3</option>
			  <option value="4">4</option>
			  <option value="5">5</option>
			  <option value="6">6</option>
			  <option value="7">7</option>
			  <option value="8">8</option>
			  <option value="9">9</option>
			  <option value="10">10</option>
			  <option value="11">11</option>
			  <option value="12">12</option> 
		</select> 
		
		<select name="minute">
			<option value="00">00</option>
			<option value="15">15</option>
			<option value="30">30</option>
			<option value="45">45</option>
		</select>
		
		
		<input type="radio" name="ampm" value="AM" /> AM
		<input type="radio" name="ampm" value="PM" checked="yes" /> PM
		
		<button type="submit" name="submit_time"> Submit </button>
	
	</form>

</html>
