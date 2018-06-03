/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=2348
*/
package BagOfHolding;

public class BagOfHolding {
	public double oddsReachable(int[] sizes, int item) {
		int nonSmallerNum = 0;
		for (int size : sizes) {
			if (size >= sizes[item]) {
				nonSmallerNum++;
			}
		}
		return 1.0 / nonSmallerNum;
	}

	public static void main(String[] args) {
		int sizes[] = {1,2,3,4,5,6,7,8,9,10};
		int item = 4;
		
		System.out.println(new BagOfHolding().oddsReachable(sizes, item));

	}

}
