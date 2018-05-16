//https://community.topcoder.com/stat?c=problem_statement&pm=5879£¿

package AimToTen;

public class AimToTen {
	public int need(int[] marks) {
		int sum = 0;
		for (int mark : marks) {
			sum += mark;
		}
		return Math.max(0, 19 * marks.length - 2 * sum);
	}
	
	public static void main(String args[]) {
		int marks[]= {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		System.out.println(new AimToTen().need(marks));
	}
}
