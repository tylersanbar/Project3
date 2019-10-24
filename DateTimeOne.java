import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
	private Calendar dateServer;
	//date formatted as 10/10/2019 06:24 PM
	SimpleDateFormat format = new SimpleDateFormat("M/d/YYYY h:mm a");
	String dateFormat;


	
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

	@Override
	void dateTimeDifferentZone() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void timeZoneHashMap() {
		// TODO Auto-generated method stub
		
	}
   
}