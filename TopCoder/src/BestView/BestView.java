/**
Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=10341
 
* @author Z.SUN
* @version 2018年6月14日 上午8:57:25
*/

package BestView;

public class BestView {

	public int numberOfBuildings(int[] heights) {
		Vector[] roofs = new Vector[heights.length];
		for (int i = 0; i < roofs.length; i++) {
			roofs[i] = new Vector(i, heights[i]);
		}
		int maxSee = 0;
		for (int i = 0; i < roofs.length; i++) {
			int see = 0;
			if (i > 0) {
				see++;
				// get the number of left side
				Vector prev = new Vector(roofs[i],
						roofs[i - 1]);
				for (int j = i - 2; j >= 0; j--) {
					Vector cur = new Vector(roofs[i],
							roofs[j]);
					if ((long) cur.y
							* prev.x < (long) prev.y
									* cur.x) {
						see++;
						prev = cur;
					}
				}
			}
			// get the number of right side
			if (i + 1 < roofs.length) {
				see++;
				Vector prev = new Vector(roofs[i],
						roofs[i + 1]);

				for (int j = i + 2; j < roofs.length; j++) {

					Vector cur = new Vector(roofs[i],
							roofs[j]);
					if ((long) cur.y
							* prev.x > (long) prev.y
									* cur.x) {
						see++;
						prev = cur;
					}
				}
			}
			maxSee = Math.max(maxSee, see);
		}
		return maxSee;
	}

	public static void main(String args[]) {

		int heights[] = { 1, 5, 3, 2, 6, 3, 2, 6, 4, 2, 5, 7, 3, 1, 5 };
		System.out.println(
				new BestView().numberOfBuildings(heights));
	}
}

class Vector {
	int x;
	int y;

	Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Vector(Vector from, Vector to) {
		this.x = to.x - from.x;
		this.y = to.y - from.y;
	}
}
