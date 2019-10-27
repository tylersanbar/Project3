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
	String[] unsortedArray;
	String[] sortedAscendingArray;
	String[] sortedDescendingArray;
	private int numKeys;
	
	
	public DateSortingUsingAlgorithm() {
		//Reads file
		try {
			read("SortingDates.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		numKeys = hash.size();
		unsortedArray = new String[numKeys];
		sortedAscendingArray = new String[numKeys];
		sortedDescendingArray = new String[numKeys];
		//Puts map keys into an unsorted array
		int i = 0;
		for(Map.Entry<LocalDate, Integer> entry: hash.entrySet()) {
			unsortedArray[i] = (format.format(entry.getKey()));
			i++;
		}
	}
	
	public void dateHashMapSortedDescending() {
		Boolean notSorted = true;
		int tempValue;
		while(notSorted == true) {
			notSorted = false;
			for(Map.Entry<LocalDate, Integer> entry1: hash.entrySet()) {
				for(Map.Entry<LocalDate, Integer> entry2: hash.entrySet()) {
					//If entry1 is after entry2 and value 1 is less than value 2, swap values
					if(entry1.getKey().isAfter(entry2.getKey()) & entry1.getValue() < entry2.getValue()) {
						tempValue = entry1.getValue();
						entry1.setValue(entry2.getValue());
						entry2.setValue(tempValue);
						notSorted = true;
					}
					//If entry1 is before entry2 and value 1 is greater than value 2, swap values
					else if(entry1.getKey().isBefore(entry2.getKey()) & entry1.getValue() > entry2.getValue()) {
						tempValue = entry1.getValue();
						entry1.setValue(entry2.getValue());
						entry2.setValue(tempValue);
						notSorted = true;
					}
				}
			}
		}
		for(int i = hash.size(); i >= 1; i--) {
			for(Map.Entry<LocalDate, Integer> entry: hash.entrySet()) {
				if(entry.getValue() == i) {
					System.out.println(format.format(entry.getKey()));
				}	
			}
		}
	}
	public void dateHashMapSorted() {
		Boolean notSorted = true;
		int tempValue;
		while(notSorted == true) {
			notSorted = false;
			for(Map.Entry<LocalDate, Integer> entry1: hash.entrySet()) {
				for(Map.Entry<LocalDate, Integer> entry2: hash.entrySet()) {
					//If entry1 is after entry2 and value 1 is less than value 2, swap values
					if(entry1.getKey().isAfter(entry2.getKey()) & entry1.getValue() < entry2.getValue()) {
						tempValue = entry1.getValue();
						entry1.setValue(entry2.getValue());
						entry2.setValue(tempValue);
						notSorted = true;
					}
					//If entry1 is before entry2 and value 1 is greater than value 2, swap values
					else if(entry1.getKey().isBefore(entry2.getKey()) & entry1.getValue() > entry2.getValue()) {
						tempValue = entry1.getValue();
						entry1.setValue(entry2.getValue());
						entry2.setValue(tempValue);
						notSorted = true;
					}
				}
			}
			
		}
		for(int i = 1; i <= hash.size(); i++) {
			for(Map.Entry<LocalDate, Integer> entry: hash.entrySet()) {
				if(entry.getValue() == i) {
					System.out.println(format.format(entry.getKey()));
				}	
			}
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
