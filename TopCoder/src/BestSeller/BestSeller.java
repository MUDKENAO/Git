/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=6440
*/
package BestSeller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class BestSeller {
	public String findBestSeller(String[] items) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < items.length; i++) {
			if (map.containsKey(items[i])) {
				map.put(items[i], map.get(items[i]) + 1);
			} else {
				map.put(items[i], 1);
			}
		}
		String max = null;
		int times = -1;
		Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Integer> one = iterator.next();
			if (one.getValue() > times
					|| (one.getValue() == times && one.getKey().compareTo(max) < 0)) {
				max = one.getKey();
				times = one.getValue();
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		
		String items[]={"icecream", "peanuts", "peanuts", "chocolate", "candy", "chocolate", "icecream", "apple"};
		
		System.out.println(new BestSeller().findBestSeller(items));
	}
}
