import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class DateTimeTwo {
	
	private Calendar dateServer;
	//date formatted as 10/10/2019 06:24 PM
	SimpleDateFormat format = new SimpleDateFormat("MM/dd/YYYY h:mm a");
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
		// TODO Auto-generated method stub
		
	}

	public void dateHashMap() {
		// TODO Auto-generated method stub
		
	}

	public void dateHashMapSorted() {
		// TODO Auto-generated method stub
		
	}

}
