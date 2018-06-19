package BigBurger;

public class BigBurger {
	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=1648
	 
	* @author Z.SUN
	* @version 2018年6月19日 下午1:47:10
	*/
	public int maxWait(int[] arrival, int[] service) {
		int length = arrival.length;
		int servTimes;
		int time = 0;
		int max = -1;
		for (int i = 0; i < length; i++) {
			servTimes = Math.max(time, arrival[i]);
			max = Math.max(max, servTimes - arrival[i]);
			time = servTimes + service[i];
		}
		return max;
	}
	
	public static void main(String args[]){
		int arrival[] = {2,10,12};
		int service[] = {15,1,15};
		System.out.println(new BigBurger().maxWait(arrival, service));
	}
	
}
