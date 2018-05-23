/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=6125
*/
package ApproximateDivision;

public class ApproximateDivision {
	public double quotient(int a, int b, int terms) {
		int t = 1;
		while (t < b) {
			t <<= 1;
		}
		int c = t - b;
		double term = 1.0 / t;
		double result = 0;
		for (int i = 0; i < terms; i++) {
			result += term;
			term *= (double) c / t;
		}
		result *= a;
		return result;
	}
	
	public static void main(String args[]) {
		int a = 0;
		int b = 4;
		int terms = 3;
		
		System.out.println(new ApproximateDivision().quotient(a, b, terms));
	}
}