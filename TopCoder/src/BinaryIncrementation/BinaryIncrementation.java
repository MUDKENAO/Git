	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=7385
	 
	* @author Z.SUN
	* @version 2018年6月22日 上午8:32:00
	*/

package BinaryIncrementation;

public class BinaryIncrementation {
	
	public String plusOne(String x) {
		int number = Integer.parseInt(x, 2);
		return Integer.toBinaryString(number + 1);
	}

	
	public static void main(String args[]){
		String x = "1";
		System.out.println(new BinaryIncrementation().plusOne(x));
	}
	
}
