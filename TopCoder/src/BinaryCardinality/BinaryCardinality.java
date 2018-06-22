	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=1519
	 
	* @author Z.SUN
	* @version 2018年6月22日 上午8:28:05
	*/

package BinaryCardinality;

import java.util.Arrays;
import java.util.Comparator;

public class BinaryCardinality {
	public int[] arrange(int[] numbers) {
		Integer nums[] = new Integer[numbers.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = numbers[i];
		}
		Arrays.sort(nums, new CardinalityComparator());
		int result[] = new int[nums.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = nums[i];
		}
		return result;
	}
	
	public static void main(String args[]){
		int numbers[] = {811385,340578,980086,545001,774872,855585,13848,863414,419523,190151,784903,127461};
		System.out.println(Arrays.toString(new BinaryCardinality().arrange(numbers)));
	}
}

class CardinalityComparator implements Comparator<Integer> {
	public int compare(Integer number1, Integer number2) {
		int cardinality1 = calcCardinality(number1);
		int cardinality2 = calcCardinality(number2);
		if (cardinality1 != cardinality2) {
			return cardinality1 - cardinality2;
		} else {
			return number1 - number2;
		}
	}

	int calcCardinality(int number) {
		return Integer.toBinaryString(number).replace("0", "").length();
	}
}