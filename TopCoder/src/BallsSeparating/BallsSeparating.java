/**
 *
 * Problem Statement
 * https://community.topcoder.com/stat?c=problem_statement&pm=12398
 * 
 * @author Sun
 */

package BallsSeparating;

public class BallsSeparating {

	int boxS[];

	public int minOperations(int[] red, int[] green, int[] blue) {
		if (red.length < 3) {
			return -1;
		}
		int l = red.length;
		int gb[] = new int[l];
		int rb[] = new int[l];
		int rg[] = new int[l];
		int min[] = new int[l];
		int r = Integer.MAX_VALUE;
		int sumAll =0;
		for (int i = 0; i < l; i++) {
			gb[i]=green[i]+blue[i];
			rb[i]=red[i]+blue[i];
			rg[i]=red[i]+green[i];
			min[i]=Math.min(gb[i], Math.min(rb[i], rg[i]));
			sumAll+=min[i];
		}

		for (int i = 0; i < blue.length; i++) {
			for (int j = 0; j < blue.length; j++) {
				for (int j2 = 0; j2 < blue.length; j2++) {
					int t = 0;
					if (i == j || i == j2 || j == j2)
						continue;
					int a=green[i]+blue[i]-min[i];
					int b=red[j]+blue[j]-min[j];
					int c=red[j2]+green[j2]-min[j2];
					t=a+b+c;
					r = t < r ? t : r;
				}
			}
		}
		sumAll+=r;
		return sumAll;
	}

	public static void main(String[] args) {
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;


		answer = new BallsSeparating().minOperations(new int[] { 1, 1, 1 },
				new int[] { 1, 1, 1 }, new int[] { 1, 1, 1 });

		desiredAnswer = 6;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("MATCH!");
		System.out.println();

		answer = new BallsSeparating().minOperations(new int[] { 5 },
				new int[] { 6 }, new int[] { 8 });

		desiredAnswer = -1;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("MATCH!");
		System.out.println();

		answer = new BallsSeparating().minOperations(new int[] { 4, 6, 5, 7 },
				new int[] { 7, 4, 6, 3 }, new int[] { 6, 5, 3, 8 });

		desiredAnswer = 37;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("MATCH!");
		System.out.println();

		answer = new BallsSeparating().minOperations(
				new int[] { 7, 12, 9, 9, 7 }, new int[] { 7, 10, 8, 8, 9 },
				new int[] { 8, 9, 5, 6, 13 });

		desiredAnswer = 77;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();

		answer = new BallsSeparating().minOperations(new int[] { 842398,
				491273, 958925, 849859, 771363, 67803, 184892, 391907, 256150,
				75799 }, new int[] { 268944, 342402, 894352, 228640, 903885,
						908656, 414271, 292588, 852057, 889141 }, new int[] { 662939,
								340220, 600081, 390298, 376707, 372199, 435097, 40266, 145590,
								505103 });

		desiredAnswer = 7230607;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("MATCH!");
		System.out.println();
	}
}

