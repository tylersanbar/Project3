import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MesoEquivalent {
	String stId;
	HashMap<String, Integer> hash = new HashMap<String, Integer>();
	private ArrayList<MesoStation> stationList = new ArrayList<MesoStation>();
	public MesoEquivalent(String stId) {
		this.stId = stId;
	}

	public HashMap<String, Integer> calAsciiEqual() {
		int asciiCal = new MesoAsciiCal(new MesoStation(this.stId)).calAverage();
		int listAsciiCal;
		MesoStation station;
		try {
			read("Mesonet.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < stationList.size(); i++) {
			station = stationList.get(i);
			listAsciiCal = new MesoAsciiCal(station).calAverage();
			if(asciiCal == listAsciiCal) {
				hash.put(station.getStID(), listAsciiCal);
			}
			
		}
		return hash;
	}
	
	private void read(String filename) throws IOException
    {
    	
    	BufferedReader br = new BufferedReader(new FileReader(filename));
    	
    	br.readLine();
    	br.readLine();
    	br.readLine();
    	String strg = br.readLine();
    	
    	//Adds stid, then loops through remaining lines
    	while (strg != null) {
    		strg = strg.replaceAll(" " , "");
    		strg = strg.replaceAll("	" , "");
    		strg = strg.substring(0,4);
    		MesoStation station = new MesoStation(strg);
    		stationList.add(station);
    		strg = br.readLine();
    	}
    	br.close();
    }

}
