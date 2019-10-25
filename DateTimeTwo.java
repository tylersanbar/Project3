import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class DateTimeTwo {
	
	private Calendar dateServer;
	//date.txt formatted as 05.05.2017
	SimpleDateFormat format = new SimpleDateFormat("MM/dd/YYYY h:mm a");
	DateTimeFormatter readFormat = DateTimeFormatter.ofPattern("M.dd.yyyy");
	SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
	String dateFormat;
	HashMap<String, String> hash = new HashMap<String, String>();
	
	public DateTimeTwo() {
		dateServer = Calendar.getInstance();
		dateFormat = format.format(dateServer.getTime());
	}
	public void daysOfCurrentMonth() {
		Calendar dateMonth = Calendar.getInstance();
		dateMonth.set(Calendar.DAY_OF_MONTH, 10);
		String tenthDay = dayFormat.format(dateMonth.getTime()).toUpperCase();
		dateMonth.set(Calendar.DAY_OF_MONTH, 18);
		String eighteenthDay = dayFormat.format(dateMonth.getTime()).toUpperCase();
		System.out.println("The tenth day of this month is " + tenthDay + " and eighteenth is " + eighteenthDay);
		
	}

	public void daysOfAnyMonth(int i, int j) {
		Calendar dateAnyMonth = Calendar.getInstance();
		dateAnyMonth.set(j + 1, i + 1, 15);
		String fiftheenthDay = dayFormat.format(dateAnyMonth.getTime()).toUpperCase();
		dateAnyMonth.set(Calendar.DAY_OF_MONTH, dateAnyMonth.getActualMaximum(Calendar.DAY_OF_MONTH));;
		String lastDay = dayFormat.format(dateAnyMonth.getTime()).toUpperCase();
		System.out.println("For the year (" + j + ") and month (" + i + "), the fifteenth day is " + fiftheenthDay + " and the last day is " + lastDay);
	}

	public void compareYear() {
		LocalDate readDate;
		LocalDate todayDate = LocalDate.now();
		Period difference;
		String leapYear;
		
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader("Dates.txt"));
			String strDate = br.readLine();
			while(strDate != null) {

				readDate = LocalDate.parse(strDate, readFormat);
				if(readDate.isLeapYear()) {
					leapYear = " is";
				}
				else {
					leapYear = " is not";
				}
				difference = Period.between(todayDate, readDate);
				System.out.println(readDate.getYear() + leapYear +" a leap year, and Difference: " + Math.abs(difference.getYears()) + " years, " + Math.abs(difference.getMonths()) + " months, and " + Math.abs(difference.getDays()) +  " days.");
				strDate = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void dateHashMap() {
		// TODO Auto-generated method stub
		
	}

	public void dateHashMapSorted() {
		// TODO Auto-generated method stub
		
	}

}
