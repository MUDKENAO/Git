package Bits;

public class Bits {
	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=520
	 
	* @author Z.SUN
	* @version 2018年8月14日 上午9:53:19
	*/

	public int minBits(int n) {
		return Integer.toBinaryString(n).length();
	}
	
	public static void main(String args[]){
		int n = 1500;
		System.out.println(new Bits().minBits(n) );
	}
}
