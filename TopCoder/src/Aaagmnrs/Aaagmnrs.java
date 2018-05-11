//Problem statement: https://community.topcoder.com/stat?c=problem_statement&pm=2854

package Aaagmnrs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Aaagmnrs {
	
	public String[] anagrams(String[] phrases) {
		ArrayList<String> remaining = new ArrayList<String>();
		HashSet<String> keys = new HashSet<String>();
		for (String phrase : phrases) {
			String word = phrase.toLowerCase().replace(" ", "");
			int counts[] = new int[26];
			for (int i = 0; i < word.length(); i++) {
				counts[word.charAt(i) - 'a']++;
			}
			String key = "";
			for (int i = 0; i < counts.length; i++) {
				for (int j = 0; j < counts[i]; j++) {
					key += (char) ('a' + i);
				}
			}
			if (!keys.contains(key)) {
				keys.add(key);
				remaining.add(phrase);
			}
		}
		String result[] = new String[remaining.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = remaining.get(i);
		}
		return result;
	}
	
	public static void main(String args[]) {
		
		String phrases[] = { "Radar ghost jilts Kim", "patched hers first",
				  "DEPTH FIRST SEARCH", "DIJKSTRAS ALGORITHM" };
		System.out.println(Arrays.toString(new Aaagmnrs().anagrams(phrases)));
		
	}
}