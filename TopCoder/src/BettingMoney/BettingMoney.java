	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=2297
	 
	* @author Z.SUN
	* @version 2018年6月14日 上午8:51:56
	*/
package BettingMoney;

public class BettingMoney {
	
	public int moneyMade(int[] amounts, int[] centsPerDollar, int finalResult) {
		int netGain = 0;
		for (int i = 0; i < amounts.length; i++) {
			if (i == finalResult) {
				netGain -= amounts[i] * centsPerDollar[i];
			} else {
				netGain += amounts[i] * 100;
			}
		}
		return netGain;
	}

	public static void main(String args[]){
		int amounts[] = {100,100,100,100};
		int centsPerDollar[] = {5,5,5,5};
		int finalResult = 0;
		System.out.println(new BettingMoney().moneyMade(amounts, centsPerDollar, finalResult));
	}
}
