/*Problem Statement
https://community.topcoder.com/stat?c=problem_statement&pm=6736
*/
package AdditionCycles;

public class AdditionCycles {
	public int cycleLength(int n) {
		int number = n;
		for (int step = 1;; step++) {
			number = process(number);
			if (number == n) {
				return step;
			}
		}
	}

	static int process(int number) {
		return number % 10 * 10 + (number / 10 + number % 10) % 10;
	}
	
	public static void main(String args[]) {
		int n = 71;
		System.out.println(new AdditionCycles().cycleLength(n));
	}
}
