package BootsExchange;
import java.util.Arrays;
public class BootsExchange {
	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=6081
	 
	* @author Z.SUN
	* @version 2018年8月17日 下午09:10:52
	*/
	public int leastAmount(int[] left, int[] right) {
		int exchangeNum = 0;
		Arrays.sort(left);
		Arrays.sort(right);
		int leftIndex = 0;
		int rightIndex = 0;
		while (leftIndex < left.length) {
			if (rightIndex == right.length
					|| left[leftIndex] < right[rightIndex]) {
				leftIndex++;
				exchangeNum++;
			} else if (left[leftIndex] == right[rightIndex]) {
				leftIndex++;
				rightIndex++;
			} else {
				rightIndex++;
			}
		}
		return exchangeNum;
	}
	
	public static void main(String args[]){
	
		int[] left = {1,3};
		int[] right = {2,2};
		System.out.println(new BootsExchange().leastAmount(left, right));
	}
	
}
