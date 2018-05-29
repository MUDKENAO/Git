/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=7777
*/
package AttendanceShort;

import java.util.ArrayList;
import java.util.Arrays;

public class AttendanceShort {
	public String[] shortList(String[] names, String[] attendance) {
		ArrayList<String> shorts = new ArrayList<String>();
		for (int i = 0; i < names.length; i++) {
			int countA = 0;
			int countP = 0;
			for (int j = 0; j < attendance[i].length(); j++) {
				char record = attendance[i].charAt(j);
				if (record == 'A') {
					countA++;
				} else if (record == 'P') {
					countP++;
				}
			}
			if (4 * countP < 3 * (countA + countP)) {
				shorts.add(names[i]);
			}
		}
		return shorts.toArray(new String[] {});
	}
	
	public static void main(String args[]) {
		String names[] = {"Mansi", "Arjun", "Nikhil", "Taneja"};
		String attendance[] = {"PPPPMPPAPP", "AAMAAPP", "PPPPAAP", "PPPAAAMPP"};
		System.out.println(Arrays.toString(new AttendanceShort().shortList(names, attendance)));
	}
}