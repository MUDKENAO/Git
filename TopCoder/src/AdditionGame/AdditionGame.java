/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=11317&rd=14427
*/

package AdditionGame;

public class AdditionGame {
	public int getMaximumPoints(int A, int B, int C, int N) {
		int point = 0;
		for (int i = 0; i < N; i++) {
			int max = Math.max(Math.max(A, B), C);
			if (max == 0) {
				break;
			}
			point += max;
			if (A == max) {
				A--;
			} else if (B == max) {
				B--;
			} else if (C == max) {
				C--;
			}
		}
		return point;
	}
	
	public static void main(String args[]) {
		int A = 36;
		int B = 36;
		int C = 36;
		int N = 13;
		System.out.println(new AdditionGame().getMaximumPoints(A, B, C, N));
	}
}
