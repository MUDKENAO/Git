/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=10586
*/

package Archery;

public class Archery {
	public double expectedPoints(int N, int[] ringPoints) {
		int totalPoint = 0;
		for (int i = 0; i < ringPoints.length; i++) {
			totalPoint += (i * 2 + 1) * ringPoints[i];
		}
		return (double) totalPoint / (ringPoints.length * ringPoints.length);
	}
	
	public static void main (String args[]) {
		
		int N = 9;
		int ringPoints[] = {69, 50, 79, 16, 52, 71, 17, 96, 56, 32};
		
		System.out.println(new Archery().expectedPoints(N, ringPoints));
	}
}
