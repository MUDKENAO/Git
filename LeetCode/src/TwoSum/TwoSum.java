package TwoSum;

import java.util.Scanner;
import java.util.HashMap;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i<nums.length; i++){
			map.put(nums[i], i);
		}
		
		for (int j = 0; j < nums.length; j++){
			Integer index = map.get(target - nums[j]);
			if (index != null && index != j){ 
				return new int[]{
						j,index
				};
			}
		}
		return null;
    }

	public static void main(String[] args){
		
		int k = 0;
		int length = 10;
		int[] foo = new int[length];
		int target = 5;
		
		System.out.print("input the element of the array, end with non-integer symbol");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		while(input.hasNextInt()){
			foo[k++]=input.nextInt();
		}
		int[] ret = twoSum(foo, target);
		System.out.println(ret[0]);
		System.out.println(ret[1]);
		
	}

}
