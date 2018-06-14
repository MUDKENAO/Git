	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=7421
	 
	* @author Z.SUN
	* @version 2018年6月14日 上午8:36:33
	*/

package BettingStrategy;

public class BettingStrategy {
	public int finalSum(int initSum, String outcome) {
		int sum = initSum;
		int bet = 1;
		for (int i = 0; i < outcome.length(); i++) {
			if (outcome.charAt(i) == 'W') {
				sum += bet;
				bet = 1;
			} else {
				sum -= bet;
				bet *= 2;
				if (sum < bet) {
					break;
				}
			}
		}
		return sum;
	}
	
	public static void main(String args[]){
		int initSum = 925;
		String outcome = "WLLLLLWLLLLLLWWWWWLWLLWLLLLLLWL";
		System.out.println(new BettingStrategy().finalSum(initSum, outcome) );
	}

}
