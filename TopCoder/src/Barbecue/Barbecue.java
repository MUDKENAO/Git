//Problem statement
//https://community.topcoder.com/stat?c=problem_statement&pm=3556

package Barbecue;

public class Barbecue {
	
	public int eliminate(int n, int[] voter, int[] excluded) {
		int voting[] = new int[n];
		int voted[] = new int[n];
		for (int i = 0; i < voter.length; i++) {
			voting[voter[i]]++;
			voted[excluded[i]]++;
		}
		int excludeIndex = 0;
		for (int i = 1; i < n; i++) {
			if (voted[i] > voted[excludeIndex]
					|| (voted[i] == voted[excludeIndex] && voting[i] > voting[excludeIndex])) {
				excludeIndex = i;
			}
		}
		return excludeIndex;
	}

	public static void main(String[] args) {
		int n = 7;
		int voter[] = {1,2,3,4,5,6,0,2,3,4,5,6,0,1,3,4,5,6,0,1,2,
				 4,5,6,0,1,2,3,5,6,0,1,2,3,4,6,0,1,2,3,4,5};
		int excluded[] = {0,0,0,0,0,0,1,1,1,1,1,1,2,2,2,2,2,2,3,3,3,
				 3,3,3,4,4,4,4,4,4,5,5,5,5,5,5,6,6,6,6,6,6};
		System.out.println(new Barbecue().eliminate(n, voter, excluded));

	}

}
