	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=1848
	 
	* @author Z.SUN
	* @version 2018年8月13日 下午6:39:44
	*/

package BirthdayOdds;

public class BirthdayOdds {
	
	public int minPeople(int minOdds, int daysInYear) {
		double noShareProbability = 1;
		for (int i = 1;; i++) {
			noShareProbability *= (daysInYear - i + 1.0) / daysInYear;
			if (1 - noShareProbability >= minOdds / 100.0) {
				return i;
			}
		}
	}

	
	public static void main(String args[]){
	
		int minOdds = 84;
		int daysInYear = 9227;
		System.out.println(new BirthdayOdds().minPeople(minOdds, daysInYear) );
	}

}
