/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=8707
*/
package AverageCandyLifetime;

public class AverageCandyLifetime {
	public double getAverage(int[] eatenCandies) {
		int daysInMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int total = 0;
		int lifetime = 0;
		int candyNum = 0;
		for (int i = 0; i < eatenCandies.length; i++) {
			lifetime += daysInMonth[i];
			total += eatenCandies[i] * lifetime;
			candyNum += eatenCandies[i];
		}
		return (double) total / candyNum;
	}
	
	public static void main(String args[]) {
		int eatenCandies[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		System.out.println(new AverageCandyLifetime().getAverage(eatenCandies));
	}
}