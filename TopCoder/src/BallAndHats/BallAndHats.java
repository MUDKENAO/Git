/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=11964
*/
package BallAndHats;

public class BallAndHats {
	
	public int getHat(String hats, int numSwaps) {
		int ballSpot = hats.indexOf('o');
		if (numSwaps == 0) {
			return ballSpot;
		}
		if (ballSpot % 2 == numSwaps % 2) {
			return 0;
		} else {
			return 1;
		}
	}

	public static void main(String[] args) {
		String hats = "o..";
		int numSwaps = 101;
		System.out.println(new BallAndHats().getHat(hats, numSwaps));

	}

}
