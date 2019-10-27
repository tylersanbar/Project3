
/**
 * @author tyler
 *
 */
public class MesoAsciiCal extends MesoAsciiAbstract 
{
	MesoStation mesoStation;
	char[] charArray = new char[4];
	
	/**
	 * @param mesoStation
	 */
	public MesoAsciiCal(MesoStation mesoStation) {
		this.mesoStation = mesoStation;
		for(int i = 0; i < 4; i++) {
			charArray[i] = mesoStation.getStID().charAt(i);
		}
	}

	/**
	 *
	 */
	@Override
	int calAverage() {
		double sum = 0.0;
		double average1;
		double average2 = 79;
		for(int i = 0; i < 4; i++) {
			sum += charArray[i];
		}
		average1 = Math.floor((sum/4.0) + 0.75);
		
		return (int) Math.ceil((average1 + average2) / 2.0);
	}
   
}