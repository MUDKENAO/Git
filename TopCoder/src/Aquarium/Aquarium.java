/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=6124
*/
package Aquarium;

public class Aquarium {
	public int peaceful(int minSize, int maxSize, int[] fishSizes) {
		int count = 0;
		for (int size = minSize; size <= maxSize; size++) {
			boolean peace = true;
			for (int fishSize : fishSizes) {
				if (eat(size, fishSize) || eat(fishSize, size)) {
					peace = false;
					break;
				}
			}
			if (peace) {
				count++;
			}
		}
		return count;
	}

	static boolean eat(int big, int small) {
		return big >= 2 * small && big <= small * 10;
	}
	
	public static void main(String args[]) {
		int minSize = 1;
		int maxSize = 791;
		int fishSizes[] = {1, 4, 12, 25, 79, 556, 625, 800, 801, 950, 952, 954, 956, 958, 980, 1000};
		
		System.out.println(new Aquarium().peaceful(minSize, maxSize, fishSizes));
	}
}
