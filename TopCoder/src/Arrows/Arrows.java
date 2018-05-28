/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=7256
*/
package Arrows;

public class Arrows {
	public int longestArrow(String s) {
		for (int length = s.length(); length > 0; length--) {
			for (int i = 0; i + length <= s.length(); i++) {
				if (isArrow(s.substring(i, i + length))) {
					return length;
				}
			}
		}
		return -1;
	}

	boolean isArrow(String str) {
		char first = str.charAt(0);
		char last = str.charAt(str.length() - 1);
		return (first == '<' && isSameLine(str.substring(1)))
				|| (last == '>' && isSameLine(str.substring(0,
						str.length() - 1)));
	}

	boolean isSameLine(String str) {
		return isSameChar(str, '-') || isSameChar(str, '=');
	}

	boolean isSameChar(String str, char ch) {
		return str.replaceAll(ch + "", "").equals("");
	}
	
	public static void main(String args[]) {
		String s= "<----=====>";
		System.out.println(new Arrows().longestArrow(s));
	}
}
