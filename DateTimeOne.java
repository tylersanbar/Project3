import java.util.Calendar;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
	private Calendar date;
	
	DateTimeOne() {
		date = Calendar.getInstance();
	}
	
	@Override
	int getValueOfSecond() {
		return date.get(Calendar.SECOND);
	}

	@Override
	void dateTimeNow() {
		date = Calendar.getInstance();
		//date formatted as 10/10/2019 06:24 PM
		System.out.format("Current Date/Time %tm/%td/%tY %tI:%tM %Tp\n",date);
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