/**
 * SRM 146 DIV 2, 1000 points Problem
 * Problem Statement
 * A well-known riddle goes like this: Four people are crossing an old bridge. The bridge cannot hold more than two people at once. It is dark, so they can't walk without a flashlight, and they only have one flashlight! Furthermore, the time needed to cross the bridge varies among the people in the group. For instance, let's say that the people take 1, 2, 5 and 10 minutes to cross the bridge. When people walk together, they always walk at the speed of the slowest person. It is impossible to toss the flashlight across the bridge, so one person always has to go back with the flashlight to the others. What is the minimum amount of time needed to get all the people across the bridge?
 * In this instance, the answer is 17. Person number 1 and 2 cross the bridge together, spending 2 minutes. Then person 1 goes back with the flashlight, spending an additional one minute. Then person 3 and 4 cross the bridge together, spending 10 minutes. Person 2 goes back with the flashlight (2 min), and person 1 and 2 cross the bridge together (2 min). This yields a total of 2+1+10+2+2 = 17 minutes spent.
 * You want to create a computer program to help you solve new instances of this problem. Given an int[] times, where the elements represent the time each person spends on a crossing, your program should return the minimum possible amount of time spent crossing the bridge.
 * Definition
 * Class: BridgeCrossing
 * Method: minTime
 * Parameters: int[]
 * Returns: int
 * Method signature: int minTime(int[] times)
 * (be sure your method is public)
 * Limits
 * Time limit (s): 2.000
 * Memory limit (MB): 64
 * Notes
 * In an optimal solution, exactly two people will be sent across the bridge with the flashlight each time (if possible), and exactly one person will be sent back with the flashlight each time. In other words, in an optimal solution, you will never send more than one person back from the far side at a time, and you will never send less than two people across to the far side each time (when possible).
 * Constraints
 * times will have between 1 and 6 elements, inclusive.
 * Each element of times will be between 1 and 100, inclusive.
 * Examples
 * Input 1: { 1, 2, 5, 10 }
 * Correct answer: 17
 * The example from the text.
 * Input 2: { 1, 2, 3, 4, 5 }
 * Correct answer: 16
 * One solution is: 1 and 2 cross together (2min), 1 goes back (1min), 4 and 5 cross together (5min), 2 goes back (2min), 1 and 3 cross together (3min), 1 goes back (1min), 1 and 2 cross together (2min). This yields a total of 2 + 1 + 5 + 2 + 3 + 1 + 2 = 16 minutes spent.
 * Input 3: { 100 }
 * Correct answer: 100
 * Only one person crosses the bridge once.
 * Input 4: { 1, 2, 3, 50, 99, 100 }
 * Correct answer: 162
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 * */

package BridgeCrossing;

import java.util.Arrays;

public class BridgeCrossing {
	
    /**
     * 
     * @param times - array where the elements represent the time each person spends on a crossing the bridge
     * @return best possible time
     */
	public int minTime(int[] times) {
		if (times.length == 1) {
			return times[0];
		}
		Arrays.sort(times);
		int total = 0;
		int rest = times.length;
		while (rest > 3) {
			total += Math.min(
					times[0] * 2 + times[rest - 2]
							+ times[rest - 1],
					times[0] + times[1] * 2
							+ times[rest - 1]);
			rest -= 2;
		}
		if (rest == 3) {
			return total + times[0] + times[1] + times[2];
		} else if (rest == 2) {
			return total + times[1];
		}
		return -1;
	}

	public static void main(String[] args) {
		
		int times[] = { 1, 2, 3, 4, 5 };
		System.out.println(new BridgeCrossing().minTime(times));

	}

}
