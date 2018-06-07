/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=1348
*/
package BenfordsLaw;

public class BenfordsLaw {
	
	public int questionableDigit(int[] transactions, int threshold) {
		int actuals[] = new int[10];
		for (int transaction : transactions) {
			actuals[(transaction + "").charAt(0) - '0']++;
		}
		for (int i = 1; i <= 9; i++) {
			double expected = Math.log10(1 + 1.0 / i) * transactions.length;
			if (actuals[i] * threshold < expected
					|| expected * threshold < actuals[i]) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		
		int transactions[] = { 987,234,1234,234873487,876,234562,17,
				  7575734,5555,4210,678234,3999,8123 };
		int threshold = 3;
		System.out.println(new BenfordsLaw().questionableDigit(transactions, threshold));

	}

}
