/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=6006
*/
package BasketsWithApples;

import java.util.Arrays;

public class BasketsWithApples {
	
	public int removeExcess(int[] apples) {
		int maxRemaining = -1;
		Arrays.sort(apples);
		for (int i = 0; i < apples.length; i++) {
			int remaining = apples[i] * (apples.length - i);
			maxRemaining = Math.max(maxRemaining, remaining);
		}
		return maxRemaining;
	}

	public static void main(String[] args) {
		int apples[] = {24, 92, 38, 0, 79, 45};
		
		System.out.println(new BasketsWithApples().removeExcess(apples));

	}

}
