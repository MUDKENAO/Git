/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=6808
*/

package Alliteration;

public class Alliteration {
	public int count(String[] words) {
		int alliterationNum = 0;
		boolean alliteration = false;
		for (int i = 1; i < words.length; i++) {
			if (Character.toLowerCase(words[i].charAt(0)) == Character
					.toLowerCase(words[i - 1].charAt(0))) {
				if (!alliteration) {
					alliteration = true;
					alliterationNum++;
				}
			} else {
				alliteration = false;
			}
		}
		return alliterationNum;
	}
	
	public static void main (String args[]) {
		String words[] = {"Round", "the", "rugged", "rock", "the", "ragged", "rascal", "ran"};
		System.out.println(new Alliteration().count(words));
	}
}