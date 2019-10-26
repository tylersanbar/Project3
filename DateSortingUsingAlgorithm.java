import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DateSortingUsingAlgorithm {
	HashMap<LocalDate, Integer> hash = new HashMap<LocalDate, Integer>();
	//2018-11-12
	DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	ArrayList<String> unsorted = new ArrayList<String>();
	ArrayList<String> sorted;
	
	public void dateHashMapSortedDescending() {
		try {
			read("SortingDates.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(Map.Entry<LocalDate, Integer> entry: hash.entrySet()) {
			unsorted.add(format.format(entry.getKey()));
		}
		int sortedSize;
		sorted = new ArrayList<String>();
		String sort = unsorted.remove(0);
		sorted.add(sort);
		while(unsorted.size() > 0) {
			sortedSize = sorted.size();
			for(int j = 0; j < sortedSize; j++) {
				//If removed piece is less than sorted, add before
				if(sort.compareTo(sorted.get(j)) <= 0) {
					sorted.add(j, sort);
					break;
				}
				//If last element, add to end of list
				else if(sorted.size() == j + 1) {
					sorted.add(sort);
				}
		}
			sort = unsorted.remove(0);
		}

		for(int i = sorted.size() - 1; i >= 0; i--) {
			System.out.println(sorted.get(i));
		}
	}

	public void dateHashMapSorted() {
		try {
			read("SortingDates.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(Map.Entry<LocalDate, Integer> entry: hash.entrySet()) {
			unsorted.add(format.format(entry.getKey()));
		}
		int sortedSize;
		sorted = new ArrayList<String>();
		String sort = unsorted.remove(0);
		sorted.add(sort);
		while(unsorted.size() > 0) {
			sortedSize = sorted.size();
			for(int j = 0; j < sortedSize; j++) {
				//If removed piece is less than sorted, add before
				if(sort.compareTo(sorted.get(j)) <= 0) {
					sorted.add(j, sort);
					break;
				}
				//If last element, add to end of list
				else if(sorted.size() == j + 1) {
					sorted.add(sort);
				}
		}
			sort = unsorted.remove(0);
		}

		for(int i = 0; i < sorted.size(); i++) {
			System.out.println(sorted.get(i));
		}
	}
	
	private void read(String filename) throws IOException
    {
    	LocalDate date;
    	BufferedReader br = new BufferedReader(new FileReader(filename));
    	String strg = br.readLine();
    	int value = 1;
    	
    	//Adds stid, then loops through remaining lines
    	while (strg != null) {
    		strg = strg.replaceAll(" " , "");
    		strg = strg.replaceAll("	" , "");
    		date = LocalDate.parse(strg, format);
    		hash.put(date, value);
    		value++;
    		strg = br.readLine();
    	}
    	br.close();
    }

}
