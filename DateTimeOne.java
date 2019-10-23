import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
	private Calendar date;
	//date formatted as 10/10/2019 06:24 PM
	SimpleDateFormat format = new SimpleDateFormat("M/d/YYYY h:mm a");
	
	DateTimeOne() {
		date = Calendar.getInstance();
	}
	
	@Override
	int getValueOfSecond() {
		int second = date.get(Calendar.SECOND);
		System.out.println("The value of Second now: " + second);
		return second;
	}

	@Override
	void dateTimeNow() {
		date = Calendar.getInstance();

		String dateFormat = format.format(date.getTime());

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

	@Override
	void dateTimeOfOtherCity() {
		// TODO Auto-generated method stub
		
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