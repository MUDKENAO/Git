/*Problem Statement
https://community.topcoder.com/stat?c=problem_statement&pm=4720
*/
package Airways;

public class Airways {
	public double distance(int n, int east, int north) {
		double dist = Math.sqrt(east * east + north * north);
		double angle = Math.atan2(north, east);
		if (angle < 0) {
			angle += Math.PI * 2;
		}
		double minAngle = 0;
		double step = Math.PI * 2 / n;
		while (minAngle + step < angle) {
			minAngle += step;
		}
		double angle1 = angle - minAngle;
		double angle2 = step - angle1;
		return dist / Math.sin(Math.PI - step)
				* (Math.sin(angle1) + Math.sin(angle2));
	}
	
	public static void main(String args[]) {
		
		int n = 14;
		int east  = -3840;
		int north = -1768;
		
		System.out.println(new Airways().distance(n, east, north));
	}
}