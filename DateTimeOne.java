import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
	private Calendar dateServer;
	//date formatted as 10/10/2019 06:24 PM
	SimpleDateFormat format = new SimpleDateFormat("MM/dd/YYYY h:mm a");
	String dateFormat;
	HashMap<String, String> hash = new HashMap<String, String>();


	
	public DateTimeOne() {
		dateServer = Calendar.getInstance();
		dateFormat = format.format(dateServer.getTime());
	}
	
	@Override
	public int getValueOfSecond() {
		int second = dateServer.get(Calendar.SECOND);
		System.out.println("The value of Second now: " + second);
		return second;
	}

	@Override
	public void dateTimeNow() {
		new DateTimeOne();
		System.out.println("Current Date/Time " + dateFormat);
	}

	@Override
	void sleepForFiveSec() {
		try {
			this.wait(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
/**			Time on Server: 15:14
			GMT: 20:14
			BST (90E): 2:14
			CST (90W): 15:14
			**/
	@Override
	void dateTimeOfOtherCity() {
		SimpleDateFormat cityFormat = new SimpleDateFormat("H:mm");
		String formatServer = cityFormat.format(dateServer.getTime());
		
		cityFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		String formatGMT = cityFormat.format(dateServer.getTime());
		
		cityFormat.setTimeZone(TimeZone.getTimeZone("BST"));
		String formatBST = cityFormat.format(dateServer.getTime());
		
		cityFormat.setTimeZone(TimeZone.getTimeZone("CST"));
		String formatCST = cityFormat.format(dateServer.getTime());
		
		System.out.format("Time on Server: %1s\nGMT: %2s\nBST (90E): %5s\nCST (90W): %4s", formatServer, formatGMT, formatBST, formatCST);
		
	}
/**			GMT: 10/08/2019 20:26
			BST: 10/09/2019 02:26
			CST: 10/08/2019 15:26
			**/
	@Override
	public void dateTimeDifferentZone() {
	
	String zone1 = "GMT";
	String dateTime1 = "10/08/2019 20:26";
	String zone2 = "BST";
	String dateTime2 = "10/09/2019 02:26";
	String zone3 = "CST";
	String dateTime3 = "10/08/2019 15:26";
		
	hash.put(zone1,dateTime1);
	hash.put(zone2,dateTime2);
	hash.put(zone3,dateTime3);
	
	System.out.println(zone1 + ": " + dateTime1 + "\n" + zone2 + ": " + dateTime2 + "\n" + zone3 + ": " + dateTime3);
		
	}

	@Override
	public void timeZoneHashMap() {
		//Adding on to hash
		String zone4 = "ZST";
		String dateTime4 = "11/05/2018 19:59";
		String zone5 = "AST";
		String dateTime5 = "10/01/2020 19:59";
		hash.put(zone4, dateTime4);
		hash.put(zone5, dateTime5);
		//Creates hash 2, sorted hash and hash2
		HashMap<String, String> hash2 = new HashMap<String, String>();
		TreeMap<String, String> sortedHash = new TreeMap<String, String>(hash);
		ArrayList<LocalDateTime> array = new ArrayList<LocalDateTime>();
		//Fills data from hash to array and hash2
		for(Map.Entry<String, String> entry: hash.entrySet()) {
			hash2.put(entry.getValue(), entry.getKey());
			array.add(LocalDateTime.parse(entry.getValue(),DateTimeFormatter.ofPattern("M/dd/yyyy H:mm")));
		}
		//Creates TreeMap sortedHash2 from hash2 which sorts it using natural ordering
		TreeMap<String, String> sortedHash2 = new TreeMap<String, String>(hash2);
		//Copies array to sortedArray and sorts in descending order
		ArrayList<LocalDateTime> sortedArray = array;
		sortedArray.sort(Collections.reverseOrder());
		//Printing
		//Format is "YYYY-m-dd'T'h:mm"
		//Print Style 1
		System.out.println("Print Style 1:");
		for(Map.Entry<String, String> entry: sortedHash.entrySet()) { 
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		/* Print Style 2
		 * System.out.println("Print Style 2:"); for(Map.Entry<String, String> entry:
		 * hash2.entrySet()) { System.out.println(entry.getKey()); }
		 */
		//Print Style 3
		System.out.println("Print Style 3:");
		for(Map.Entry<String, String> entry: sortedHash2.entrySet()) { 
			System.out.println(entry.getKey());
		}
		/* Print Style 4
		 * System.out.println("Print Style 4:"); for(int i = 0; i < array.size(); i++) {
		 * System.out.println(array.get(i)); }
		 */
		//Print Style 5
		System.out.println("Print Style 5:");
		for(int i = 0; i < sortedArray.size(); i++) {
			System.out.println(sortedArray.get(i));
		}
		}
   
}