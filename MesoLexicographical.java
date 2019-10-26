import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MesoLexicographical extends MesoSortedAbstract
{

	public MesoLexicographical(HashMap<String, Integer> asciiVal) {
		TreeMap<String, Integer> tree = new TreeMap<String, Integer>(asciiVal);
		for(Map.Entry<String, Integer> entry: tree.entrySet()) {
			System.out.println(entry.getKey());
		}
	}

	@Override
	Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted) {
		// TODO Auto-generated method stub
		return null;
	}

}