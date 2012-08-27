import java.util.Calendar;

/**
 * 
 * @author Michael
 *
 */
public class FrenchRevolutionaryCalendar extends Calendar {


	private static final long serialVersionUID = 1L;
	
	//days
	public static final int PRIMIDI = 1;
	public static final int DUODI = 2;
	public static final int TRIDI = 3;
	public static final int QUARTIDI = 4;
	public static final int QUINTIDI = 5;
	public static final int SEXTIDI = 6;
	public static final int SEPTIDI = 7;
	public static final int OCTIDI = 8;
	public static final int NONIDI = 9;
	public static final int DECADI = 10;
	
	//months
	public static final int VENDEMIAIRE = 1;
	public static final int BRUMAIRE = 2;
	public static final int FRIMAIRE = 3;
	public static final int NIVOSE = 4;
	public static final int PLUVIOSE = 5;
	public static final int VENTOSE = 6;
	public static final int GERMINAL = 7;
	public static final int FLOREAL = 8;
	public static final int PRAIRIAL = 9;
	public static final int MESSIDOR = 10;
	public static final int THERMIDOR = 11;
	public static final int FRUCTIDOR = 12;
	
	
	//extra days
	public static final int VERTU = 1;
	public static final int GENIE = 2;
	public static final int TRAVAIL = 3;
	public static final int LOPINION = 4;
	public static final int RECOMPENSES = 5;
	public static final int REVOLUTION = 6;
	
	//attributes
	private long time;
	
	private int year;
	private int month;
	private int dayOfMonth;
	private int dayOfWeek;
	private int hour;
	private int minute;
	private int second;
	
	
	//fields
	public static final int YEAR = 1;
	public static final int MONTH = 2;
	public static final int DAY_OF_MONTH = 3;
	public static final int DAY_OF_WEEK = 4;
	public static final int HOUR = 5;
	public static final int MINUTE = 6;
	public static final int SECOND = 7;
	
	//given conversions
	public static final int SEC_IN_MIN = 100;
	public static final int MIN_IN_HOUR = 100;
	public static final int HOUR_IN_DAY = 10;
	public static final int DAY_IN_WEEK = 10;
	public static final int WEEK_IN_MONTH = 3;
	public static final int MONTH_IN_YEAR = 12;
	public static final int XDAY_IN_YEAR = 5;
	public static final int XDAY_IN_LYEAR = 6;
	
	//calculated conversions
	public static final int DAY_IN_MONTH = DAY_IN_WEEK * WEEK_IN_MONTH; //30
	public static final int SEC_IN_COREYEAR = SEC_IN_MIN*MIN_IN_HOUR*HOUR_IN_DAY*DAY_IN_MONTH*MONTH_IN_YEAR;
	public static final int SEC_IN_5XDAY = XDAY_IN_YEAR*SEC_IN_MIN*MIN_IN_HOUR*HOUR_IN_DAY;
	public static final int SEC_IN_6XDAY = XDAY_IN_LYEAR*SEC_IN_MIN*MIN_IN_HOUR*HOUR_IN_DAY;
	public static final int SEC_IN_YEAR = SEC_IN_COREYEAR + SEC_IN_5XDAY;
	public static final int SEC_IN_LYEAR = SEC_IN_COREYEAR + SEC_IN_6XDAY;
	public static final int SEC_IN_MONTH = SEC_IN_MIN*MIN_IN_HOUR*HOUR_IN_DAY*DAY_IN_MONTH;
	public static final int SEC_IN_DAY = SEC_IN_MIN*MIN_IN_HOUR*HOUR_IN_DAY;
	public static final int SEC_IN_HOUR = SEC_IN_MIN*MIN_IN_HOUR;
	
	/**
	 * Creates a calendar with default values. The epoch in French Revolutionary time is considered to be 
	 * the first day of the week on first day of the first month of the first year at 00:00:00
	 */
	FrenchRevolutionaryCalendar()
	{
		year = 1;
		month = VENDEMIAIRE;
		dayOfMonth = 1;
		dayOfWeek = PRIMIDI;
		
		hour = 0;
		minute = 0;
		second = 0;
		
		time=0;
		
		computeTime();
	}
	
	/**
	 * Constructs a F.R.C. with a specific field set to a chosen value
	 * @param field
	 * @param amount
	 */
	FrenchRevolutionaryCalendar(int field, int amount)
	{
		year = 1;
		month = VENDEMIAIRE;
		dayOfMonth = 1;
		dayOfWeek = PRIMIDI;
		
		hour = 0;
		minute = 0;
		second = 0;
		
		time=0;
		
		set(field, amount);
		
		computeTime();
	}
	
	/**
	 * constructs a FRC with date equal to a specified value of seconds from the epoch/default
	 * @param time
	 */
	FrenchRevolutionaryCalendar(long time)
	{
		year = 1;
		month = VENDEMIAIRE;
		dayOfMonth = 1;
		dayOfWeek = PRIMIDI;
		
		hour = 0;
		minute = 0;
		second = 0;
		
		this.time = time;
		computeFields();
	}
	
	/**
	 * Constructs a FRC with a specified year, month and day of the month
	 * @param year
	 * @param month
	 * @param dayOfMonth
	 */
	FrenchRevolutionaryCalendar(int year, int month, int dayOfMonth)
	{
		this.year = year;
		this.month = month;
		this.dayOfMonth = dayOfMonth;
		dayOfWeek = PRIMIDI;
		
		hour = 0;
		minute = 0;
		second = 0;
		
		time=0;
		
		computeTime();
	}
	
	/**
	 * Prints the date in format: E, d M y K:m:s
	 */
	public String toString()
	{
		String report = "";

			switch(this.get(DAY_OF_WEEK)){
				case PRIMIDI: report += "Primidi"; break;
				case DUODI: report += "Duodi"; break;
				case TRIDI: report += "Tridi"; break;
				case QUARTIDI: report += "Quartidi"; break;
				case QUINTIDI: report += "Quintidi"; break;
				case SEXTIDI: report += "Sextidi"; break;
				case SEPTIDI: report += "Septidi"; break;
				case OCTIDI: report += "Octidi"; break;
				case NONIDI: report += "Nonidi"; break;
				case DECADI: report += "Decadi"; break;
			}
		
		
		report += ", ";
		
		report += this.get(DAY_OF_MONTH);
		report += " ";
		
		switch(this.get(MONTH)){
		case VENDEMIAIRE: report += "Vendemiaire"; break;
		case BRUMAIRE: report += "Brumaire"; break;
		case FRIMAIRE: report += "Frimaire"; break;
		case NIVOSE: report += "Nivose"; break;
		case PLUVIOSE: report += "Pluviose"; break;
		case VENTOSE: report += "Ventose"; break;
		case GERMINAL: report += "Germinal"; break;
		case FLOREAL: report += "Floreal"; break;
		case PRAIRIAL: report += "Prairial"; break;
		case MESSIDOR: report += "Messidor"; break;
		case THERMIDOR: report += "Thermidor"; break;
		case FRUCTIDOR: report += "Fructidor"; break;
		}	
		
		report += " ";
		report += this.get(YEAR);
		
		report += " ";
		report += this.get(HOUR);
		report += ":";
		report += this.get(MINUTE);
		report += ":";
		report += this.get(SECOND);
		
		return report;
	}
	
	
	
	/**
	 * Adds or subtracts to the specified field of the given calendar field, based on the calendar's rules. 
	 * 
	 * @param field
	 * @param amount
	 */
	public void add(int field, int amount) {
		
		computeFields();
		
		if(amount>=0){
			for(int i = 0; i < amount; i++)
			{
				strictRoll(field, true);
			} 
		}
		if(amount<0){
			for(int i = 0; i > amount; i--)
			{
				strictRoll(field, false);
			} 
		}
		computeTime();		
	}

	
	/**
	 * Converts time value in seconds to field values
	 * 
	 */
	public void computeFields() {
		
		
		long tempTime = time;
		
		year = 1;
		month = VENDEMIAIRE;
		dayOfMonth = 1;
		hour = 0;
		minute = 0;
		second = 0;
		
		boolean again=true;
		while (again==true)
		if((year) >= 20 && (year)%4 == 0 && (year)%128 != 0)
		{
			if(tempTime/SEC_IN_LYEAR > 0)
			{
				tempTime -= SEC_IN_LYEAR;
				year++;
			}
			else {again = false;}
		}
		else
		{
			if(tempTime/SEC_IN_YEAR > 0)
			{
				tempTime -= SEC_IN_YEAR;
				year++;
			}
			else {again = false;}
		}
		
		boolean again1=true;
		while(again1==true)
		{
			if(tempTime/SEC_IN_MONTH > 0)
			{
				tempTime -= SEC_IN_MONTH;
				month++;
			}
			else {again1 = false;}
		}
		
		boolean again2=true;
		while(again2==true)
		{
			if(tempTime/SEC_IN_DAY > 0)
			{
				tempTime -= SEC_IN_DAY;
				dayOfMonth++;
			}
			else {again2 = false;}
		}
		
		boolean again3=true;
		while(again3==true)
		{
			if(tempTime/SEC_IN_HOUR > 0)
			{
				tempTime -= SEC_IN_HOUR;
				hour++;
			}
			else {again3 = false;}
		}
		
		boolean again4=true;
		while(again4==true)
		{
			if(tempTime/SEC_IN_MIN > 0)
			{
				tempTime -= SEC_IN_MIN;
				minute++;
			}
			else {again4 = false;}
		}
		
		while(tempTime > 0)
		{
			tempTime --;
			second++;
		}
		
		
	}

	
	/**
	 * calculates time in seconds based on fields
	 * 
	 */
	public void computeTime() {
		
		int leap = XDAY_IN_YEAR;
		
		time = 0;
		time += second;
		time += minute*SEC_IN_MIN;
		time += hour*SEC_IN_HOUR;
		time += (dayOfMonth-1)*SEC_IN_DAY;
		time += (month-1)*SEC_IN_MONTH;
		
		for(int i = 1; i < year; i++)
		{
			if(i >= 20 && i%4 == 0 && i%128 != 0)
				{leap = XDAY_IN_LYEAR;}
			else {leap = XDAY_IN_YEAR;}
			
			time += (SEC_IN_COREYEAR + leap*SEC_IN_DAY);
		}
		
	}

	
	/**
	 * Returns the highest minimum value for the given calendar field of this Calendar instance. 
	 * 
	 * @param field
	 * @return the highest minimum value for the given calendar field.
	 */
	public int getGreatestMinimum(int field) {
		switch(field){
		case YEAR: return 1; 
		case MONTH: return VENDEMIAIRE; 
		case DAY_OF_MONTH: return 1;
		case DAY_OF_WEEK: return PRIMIDI;
		case HOUR: return 0;
		case MINUTE: return 0; 
		case SECOND: return 0; 
		}
		return -1;
		
		
	}

	/**
	 * Returns the lowest maximum value for the given calendar field.
	 * @param field
	 * 
	 * @return the lowest maximum value for the given calendar field.

	 */
	public int getLeastMaximum(int field) {
		switch(field){
		case YEAR: return 2147483647; 
		case MONTH: return FRUCTIDOR; 
		case DAY_OF_MONTH: return DAY_IN_MONTH;
		case DAY_OF_WEEK: return DECADI;
		case HOUR: return HOUR_IN_DAY-1;
		case MINUTE: return MIN_IN_HOUR-1; 
		case SECOND: return SEC_IN_MIN-1; 
		}
		return -1;
	}

	/**
	 * Returns the maximum value for the given calendar field of this Calendar instance
	 * @param field
	 * @return the maximum value for the given calendar field of this Calendar instance
	 * 
	 */
	public int getMaximum(int field) {
		switch(field){
		case YEAR: return 2147483647; 
		case MONTH: return FRUCTIDOR; 
		case DAY_OF_MONTH: return DAY_IN_MONTH;
		case DAY_OF_WEEK: return DECADI;
		case HOUR: return HOUR_IN_DAY-1;
		case MINUTE: return MIN_IN_HOUR-1; 
		case SECOND: return SEC_IN_MIN-1; 
		}
		return -1;
	}

	/**
	 * Returns the minimum value for the given calendar field of this Calendar instance. 
	 * @param field
	 * @return the minimum value for the given calendar field of this Calendar instance. 
	 */
	public int getMinimum(int field) {
		switch(field){
		case YEAR: return 1; 
		case MONTH: return VENDEMIAIRE; 
		case DAY_OF_MONTH: return 1;
		case DAY_OF_WEEK: return PRIMIDI;
		case HOUR: return 0;
		case MINUTE: return 0; 
		case SECOND: return 0; 
		}
		return -1;
	}

	/**
	 * Adds or subtracts (up/down) a single unit of time on the given time field without changing larger fields.
	 * @param field
	 * @param direction (up/down)
	 * 
	 */
	public void roll(int field, boolean up){
		switch(field){
		case YEAR: 
			if(up==true)
			{
				if(this.get(field) == this.getMaximum(field))
				{
					year=this.getMinimum(field);	
				}
				else
					year++;
			} 
			else //down
			{
				if(this.get(field) == this.getMinimum(field))
				{
					year=this.getMaximum(field);	
				}
				else
					year--;
			}
			setDayOfWeek();
			computeTime();
		break;
		case MONTH: 
			if(up==true)
			{
				if(this.get(field) == this.getMaximum(field))
				{
					month=this.getMinimum(field);	
				}
				else
					month++;
			} 
			else //down
			{
				if(this.get(field) == this.getMinimum(field))
				{
					month=this.getMaximum(field);	
				}
				else
					month--;
			}
			setDayOfWeek();
			computeTime();
		break;
		case DAY_OF_MONTH: 
			if(up==true)
			{
				if(this.get(field) == this.getMaximum(field))
				{
					dayOfMonth=this.getMinimum(field);	
				}
				else
					dayOfMonth++;
			} 
			else //down
			{
				if(this.get(field) == this.getMinimum(field))
				{
					dayOfMonth=this.getMaximum(field);	
				}
				else
					dayOfMonth--;
			}
			setDayOfWeek();
			computeTime();
		break;
		case DAY_OF_WEEK: 
			if(up==true)
			{
				if(this.get(field) == this.getMaximum(field))
				{
					dayOfWeek=this.getMinimum(field);	
				}
				else
					dayOfWeek++;
			} 
			else //down
			{
				if(this.get(field) == this.getMinimum(field))
				{
					dayOfWeek=this.getMaximum(field);	
				}
				else
					dayOfWeek--;
			}
			setDayOfWeek();
			computeTime();
		break;
		case HOUR: 
			if(up==true)
			{
				if(this.get(field) == this.getMaximum(field))
				{
					hour=this.getMinimum(field);	
				}
				else
					hour++;
			} 
			else //down
			{
				if(this.get(field) == this.getMinimum(field))
				{
					hour=this.getMaximum(field);	
				}
				else
					hour--;
			}
			setDayOfWeek();
			computeTime();
		break;
		case MINUTE: 
			if(up==true)
			{
				if(this.get(field) == this.getMaximum(field))
				{
					minute=this.getMinimum(field);	
				}
				else
					minute++;
			} 
			else //down
			{
				if(this.get(field) == this.getMinimum(field))
				{
					minute=this.getMaximum(field);	
				}
				else
					minute--;
			}
			setDayOfWeek();
			computeTime();
		break;
		case SECOND: 
			if(up==true)
			{
				if(this.get(field) == this.getMaximum(field))
				{
					second=this.getMinimum(field);	
				}
				else
					second++;
			} 
			else //down
			{
				if(this.get(field) == this.getMinimum(field))
				{
					second=this.getMaximum(field);	
				}
				else
					second--;
			}
			setDayOfWeek();
			computeTime();
		break;
		
		
		}
	}
	
	/**
	 * Adds or subtracts (up/down) a single unit of time on the given time field WHILE changing larger fields when necessary.
	 * @param field
	 * @param up
	 */
	public void strictRoll(int field, boolean up) {
		switch(field){
		case YEAR: 
			if(up==true)
				{year++;} 
			else {year--;} 
			setDayOfWeek();
			computeTime();
		break;
		case MONTH: 
			if(up==true)
			{
				if(month == this.getMaximum(MONTH))
				{
					month=this.getMinimum(MONTH);
					year++;
				}
				else
					month++;
			} 
			else //down
			{
				if(month == this.getMinimum(MONTH))
				{
					month=this.getMaximum(MONTH);
					year--;
				}
				else
					month--;
			
			} 
			setDayOfWeek();
			computeTime();
		break;
		case DAY_OF_MONTH: 
			if(up==true)
			{
				if(dayOfMonth == this.getMaximum(DAY_OF_MONTH))
				{
					dayOfMonth=this.getMinimum(DAY_OF_MONTH);
					if(month == this.getMaximum(MONTH))
					{
						month=this.getMinimum(MONTH);
						year++;
					}
					else
						month++;
				}
				else
					dayOfMonth++;
			} 
			else //down
			{
				if(dayOfMonth == this.getMinimum(DAY_OF_MONTH))
				{
					dayOfMonth=this.getMaximum(DAY_OF_MONTH);
					if(month == this.getMinimum(MONTH))
					{
						month=this.getMaximum(MONTH);
						year--;
					}
					else
						month--;
				}
				else
					dayOfMonth--;
			} 
			setDayOfWeek();
			computeTime();
		break;
		case DAY_OF_WEEK: 
			if(up==true)
			{
				if(dayOfMonth == this.getMaximum(DAY_OF_MONTH))
				{
					dayOfMonth=this.getMinimum(DAY_OF_MONTH);
					if(month == this.getMaximum(MONTH))
					{
						month=this.getMinimum(MONTH);
						year++;
					}
					else
						month++;
				}
				else
					dayOfMonth++;
			} 
			else //down
			{
				if(dayOfMonth == this.getMinimum(DAY_OF_MONTH))
				{
					dayOfMonth=this.getMaximum(DAY_OF_MONTH);
					if(month == this.getMinimum(MONTH))
					{
						month=this.getMaximum(MONTH);
						year--;
					}
					else
						month--;
				}
				else
					dayOfMonth--;
			} 
			setDayOfWeek();computeTime(); break;
		case HOUR: 
			if(up==true)
			{
				if(hour == this.getMaximum(HOUR))
				{
					hour=this.getMinimum(HOUR);
					if(dayOfMonth == this.getMaximum(DAY_OF_MONTH))
					{
						dayOfMonth=this.getMinimum(DAY_OF_MONTH);
						if(month == this.getMaximum(MONTH))
						{
							month=this.getMinimum(MONTH);
							year++;
						}
						else
							month++;
					}
					else
						dayOfMonth++;
				}
				else
					hour++;
			} 
			else //down
			{
				if(hour == this.getMinimum(HOUR))
				{
					hour=this.getMaximum(HOUR);
					if(dayOfMonth == this.getMinimum(DAY_OF_MONTH))
					{
						dayOfMonth=this.getMaximum(DAY_OF_MONTH);
						if(month == this.getMinimum(MONTH))
						{
							month=this.getMaximum(MONTH);
							year--;
						}
						else
							month--;
					}
					else
						dayOfMonth--;
				}
				else
					hour--;
			} 
			setDayOfWeek();computeTime();break;
		case MINUTE: 
			if(up==true)
			{
				if(minute == this.getMaximum(MINUTE))
				{
					minute=this.getMinimum(MINUTE);
					if(hour == this.getMaximum(HOUR))
					{
						hour=this.getMinimum(HOUR);
						if(dayOfMonth == this.getMaximum(DAY_OF_MONTH))
						{
							dayOfMonth=this.getMinimum(DAY_OF_MONTH);
							if(month == this.getMaximum(MONTH))
							{
								month=this.getMinimum(MONTH);
								year++;
							}
							else
								month++;
						}
						else
							dayOfMonth++;
					}
					else
						hour++;
				}
				else
					minute++;
			} 
			else //down
			{
				if(minute == this.getMinimum(MINUTE))
				{
					minute=this.getMaximum(MINUTE);
					if(hour == this.getMinimum(HOUR))
					{
						hour=this.getMaximum(HOUR);
						if(dayOfMonth == this.getMinimum(DAY_OF_MONTH))
						{
							dayOfMonth=this.getMaximum(DAY_OF_MONTH);
							if(month == this.getMinimum(MONTH))
							{
								month=this.getMaximum(MONTH);
								year--;
							}
							else
								month--;
						}
						else
							dayOfMonth--;
					}
					else
						hour--;
				}
				else
					minute--;
			} 
			setDayOfWeek();computeTime();break;
		case SECOND: 
			if(up==true)
			{
				if(second == this.getMaximum(SECOND))
				{
					second=this.getMinimum(SECOND);
					if(minute == this.getMaximum(MINUTE))
					{
						minute=this.getMinimum(MINUTE);
						if(hour == this.getMaximum(HOUR))
						{
							hour=this.getMinimum(HOUR);
							if(dayOfMonth == this.getMaximum(DAY_OF_MONTH))
							{
								dayOfMonth=this.getMinimum(DAY_OF_MONTH);
								if(month == this.getMaximum(MONTH))
								{
									month=this.getMinimum(MONTH);
									year++;
								}
								else
									month++;
							}
							else
								dayOfMonth++;
						}
						else
							hour++;
					}
					else
						minute++;
				}
				else
					second++;
			} 
			else //roll down
			{
				if(second == this.getMinimum(SECOND))
				{
					second=this.getMaximum(SECOND);
					if(minute == this.getMinimum(MINUTE))
					{
						minute=this.getMaximum(MINUTE);
						if(hour == this.getMinimum(HOUR))
						{
							hour=this.getMaximum(HOUR);
							if(dayOfMonth == this.getMinimum(DAY_OF_MONTH))
							{
								dayOfMonth=this.getMaximum(DAY_OF_MONTH);
								if(month == this.getMinimum(MONTH))
								{
									month=this.getMaximum(MONTH);
									year--;
								}
								else
									month--;
							}
							else
								dayOfMonth--;
						}
						else
							hour--;
					}
					else
						minute--;
				}
				else
					second--;
			} 
		setDayOfWeek();computeTime();break;
		}
	}

	/**
	 * Returns the value of the given calendar field
	 * @param field
	 * @return the value of the given calendar field. 
	 */
	public int get(int field)
	{
		switch(field){
		case YEAR: return year; 
		case MONTH: return month; 
		case DAY_OF_MONTH: return dayOfMonth;
		case DAY_OF_WEEK: return dayOfWeek;
		case HOUR: return hour;
		case MINUTE: return minute; 
		case SECOND: return second; 
		}
		return -1;
	}
	
	/**
	 * Returns the display name of the given field
	 * @param field
	 * @return
	 */
	public String getDisplayName(int field)
	{
		switch(field){
		case YEAR: return "year"; 
		case MONTH: return "month"; 
		case DAY_OF_MONTH: return "day of month";
		case DAY_OF_WEEK: return "day of week";
		case HOUR: return "hour";
		case MINUTE: return "minute"; 
		case SECOND: return "second"; 
		}
		return "";
	}
	
	/**
	 * Returns the first day of the week
	 */
	public int getFirstDayOfWeek()
	{
		return PRIMIDI;
	}
	
	/**
	 * Returns the minimal number of days in the first week of a month
	 */
	public int getMinimalDaysInFirstWeek() 
	{
		return DAY_IN_WEEK;
	}
	
	/**
	 * Returns the time (of the calendar instance's date) in ms
	 */
	public long getTimeInMillis() 
	{
		computeTime();
		return time*10;
	}
	
	/**
	 * Sets the given calendar field to the given value. Larger fields are not affected.
	 * @param field
	 * @param value
	 */
	public void set(int field, int value) 
	{
		switch(field){
		case YEAR: year = value; break;
		case MONTH: month = value; break; 
		case DAY_OF_MONTH: dayOfMonth = value; break;
		case DAY_OF_WEEK: dayOfMonth = value; break;
		case HOUR: hour = value; break;
		case MINUTE: minute = value; break;
		case SECOND: second = value; break; 
		}
		computeTime();
	}
	
	/**
	 * Sets this Calendar's current time from the given long value. 
	 * @param millis - time value in ms
	 */
	public void setTimeInMillis(long millis) 
	{
		time = millis/10;
		computeFields();
	}
	
	/**
	 * Sets the day of the week depending on what day of the month it is
	 */
	public void setDayOfWeek()
	{
		switch((this.get(DAY_OF_MONTH)%10)){
		case PRIMIDI: dayOfWeek = PRIMIDI; break;
		case DUODI: dayOfWeek = DUODI; break;
		case TRIDI: dayOfWeek = TRIDI; break;
		case QUARTIDI: dayOfWeek = QUARTIDI; break;
		case QUINTIDI: dayOfWeek = QUINTIDI; break;
		case SEXTIDI: dayOfWeek = SEXTIDI; break;
		case SEPTIDI: dayOfWeek = SEPTIDI; break;
		case OCTIDI: dayOfWeek = OCTIDI; break;
		case NONIDI: dayOfWeek = NONIDI; break;
		case 0: dayOfWeek = DECADI; break;
		
		}
	}
	
}
