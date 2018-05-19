/*Problem Statement
https://community.topcoder.com/stat?c=problem_statement&pm=13089
*/
package AmebaDiv2;

public class AmebaDiv2 {
	public int simulate(int[] X, int A) {
		int size = A;
		for (int oneX : X) {
			if (oneX == size) {
				size *= 2;
			}
		}
		return size;
	}
	
	public static void main(String args[]) {
		int X[] = {817,832,817,832,126,817,63,63,126,817,832,287,823,817,574};
		int A = 63;
		System.out.println(new AmebaDiv2().simulate(X, A));
	}
}