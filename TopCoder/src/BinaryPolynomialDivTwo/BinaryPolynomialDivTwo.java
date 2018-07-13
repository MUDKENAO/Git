/**
Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=11800
 
* @author Z.SUN
* @version 2018年7月13日 上午9:39:43
*/
package BinaryPolynomialDivTwo;

public class BinaryPolynomialDivTwo {
	public int countRoots(int[] a) {
		int rootNum = 0;
		if (a[0] == 0) {
			rootNum++;
		}
		int sum = 0;
		for (int coef : a) {
			sum += coef;
		}
		if (sum % 2 == 0) {
			rootNum++;
		}
		return rootNum;
	}

	public static void main(String args[]) {

		int[] a = { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0,
				1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1,
				1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1,
				1, 0, 1, 0, 0, 1, 1 };
		System.out.println(
				new BinaryPolynomialDivTwo().countRoots(a));
	}

}
