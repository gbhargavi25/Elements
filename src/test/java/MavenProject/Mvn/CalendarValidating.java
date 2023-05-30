package MavenProject.Mvn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarValidating {

	public static void main(String[] args) throws ParseException
	{
		String targetDate= "30-Feb-2023"; 
		// String targetDate= "20-Feb-2023"; 
		SimpleDateFormat targetDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		targetDateFormat.setLenient(false);
		// the above line help us to give the output as false if there is no such kind of date in a month
		// absence of this line gives the output of Mar 02 i.e the date will be carry forward to next month
		targetDateFormat.parse(targetDate);
		Date formattedTargetDate = targetDateFormat.parse(targetDate);
		System.out.println(formattedTargetDate);

	}

}
