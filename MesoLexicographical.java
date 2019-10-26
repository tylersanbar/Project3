import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MesoLexicographical extends MesoSortedAbstract
{
	TreeMap<String, Integer> tree;
	HashMap<String, Integer> asciiVal;
	public MesoLexicographical(HashMap<String, Integer> asciiVal) {
		this.asciiVal = asciiVal;
		tree = new TreeMap<String, Integer>(asciiVal);
		for(Map.Entry<String, Integer> entry: tree.entrySet()) {
			System.out.println(entry.getKey());
		}
	}

	@Override
	Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted) {
		tree = new TreeMap<String, Integer>(unsorted);
		for(Map.Entry<String, Integer> entry: tree.entrySet()) {
			System.out.println(entry.getKey());
		}
		return tree;
	}

}