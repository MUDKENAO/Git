/*Problem Statement

https://community.topcoder.com/stat?c=problem_statement&pm=12029
*/
package ANDEquation;

public class ANDEquation {
	public int restoreY(int[] input) {
		for (int i = 0; i < input.length; i++) {
			int andResult = -1;
			for (int j = 0; j < input.length; j++) {
				if (j == i) {
					continue;
				}
				if (andResult < 0) {
					andResult = input[j];
				} else {
					andResult &= input[j];
				}
			}
			if (input[i] == andResult) {
				return input[i];
			}
		}
		return -1;
	}
	
	public static void main(String args[]) {
		int input[] = 	
			{1362,1066,1659,2010,1912,1720,1851,1593,1799,1805,1139,1493,1141,1163,1211};

		System.out.println(new ANDEquation().restoreY(input));
	}
}