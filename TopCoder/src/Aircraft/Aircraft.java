//https://community.topcoder.com/stat?c=problem_statement&pm=7741

package Aircraft;


public class Aircraft {
	public String nearMiss(int[] p1, int[] v1, int[] p2, int[] v2, int R) {
		int deltaPx = p2[0] - p1[0];
		int deltaPy = p2[1] - p1[1];
		int deltaPz = p2[2] - p1[2];
		int deltaVx = v2[0] - v1[0];
		int deltaVy = v2[1] - v1[1];
		int deltaVz = v2[2] - v1[2];
		long a = deltaVx * deltaVx + deltaVy * deltaVy + deltaVz * deltaVz;
		long b = 2L * (deltaPx * deltaVx + deltaPy * deltaVy + deltaPz
				* deltaVz);
		long c = deltaPx * deltaPx + deltaPy * deltaPy + deltaPz * deltaPz - R
				* R;
		boolean near;
		if (a == 0) { // b = 0
			near = (c <= 0);
		} else { // a > 0
			if (b >= 0) {
				near = (c <= 0);
			} else {
				near = (b * b - 4L * a * c >= 0);
			}
		}
		return near ? "YES" : "NO";
	}
	
	public static void main(String args[]) {
		int p1[] = {-2838,-7940,-2936};
		int v1[] = {1,1,-2};
		int p2[] = {532,3850,9590};
		int v2[] = {1,0,-3};
		
		int R = 3410;
		
		System.out.println(new Aircraft().nearMiss(p1, v1, p2, v2, R));
	}
}
