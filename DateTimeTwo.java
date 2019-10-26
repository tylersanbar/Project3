import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DateTimeTwo {
	
	//date.txt formatted as 05.05.2017
	DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	DateTimeFormatter readFormat = DateTimeFormatter.ofPattern("MM.dd.yyyy");
	SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
	String dateFormat;
	HashMap<LocalDate, Integer> hash = new HashMap<LocalDate, Integer>();
	TreeMap<LocalDate, Integer> tree;
	
	public DateTimeTwo() {
		//dateServer = Calendar.getInstance();
		//dateFormat = format.format(dateServer.getTime());
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
			int value = 1;
		
			while(strDate != null) {
				readDate = LocalDate.parse(strDate, readFormat);
				hash.put(readDate, value);
				value++;
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
		for(Map.Entry<LocalDate, Integer> entry: hash.entrySet()) {
			System.out.println(format.format(entry.getKey()) + ":" + entry.getValue());
		}
		
	}

	public void dateHashMapSorted() {
		tree = new TreeMap<LocalDate, Integer>(hash);
		for(Map.Entry<LocalDate, Integer> entry: tree.entrySet()) {
			System.out.println(format.format(entry.getKey()) + ":" + entry.getValue());
		}
	}

}
