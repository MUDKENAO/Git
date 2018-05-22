/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=11293
*/

package AnagramFree;

import java.util.HashSet;

public class AnagramFree {
	public int getMaximumSubset(String[] S) {
		HashSet<String> anagrams = new HashSet<String>();
		for (String str : S) {
			int counts[] = new int[26];
			for (int i = 0; i < str.length(); i++) {
				counts[str.charAt(i) - 'a']++;
			}
			String signature = "";
			for (int i = 0; i < counts.length; i++) {
				if (counts[i] > 0) {
					signature += ('a' + i) + counts[i];
				}
			}
			anagrams.add(signature);
		}
		return anagrams.size();
	}
	
	public static void main (String args[]) {
		String S[] = {"creation","sentence","reaction","sneak","star","rats","snake"};
		
		System.out.println(new AnagramFree().getMaximumSubset(S));
	}
}