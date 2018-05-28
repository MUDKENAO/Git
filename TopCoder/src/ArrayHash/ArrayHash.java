/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=4503
*/
package ArrayHash;

public class ArrayHash {
	public int getHash(String[] input) {
		int hash = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length(); j++) {
				hash += input[i].charAt(j) - 'A' + i + j;
			}
		}
		return hash;
	}
	
	public static void main(String args[]) {
		String input[] = {"ZZZZZZZZZZ"};
		System.out.println(new ArrayHash().getHash(input));
	}
}