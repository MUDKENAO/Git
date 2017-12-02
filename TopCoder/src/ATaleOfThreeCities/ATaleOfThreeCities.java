/*
https://community.topcoder.com/stat?c=problem_statement&pm=3543&rd=6538
 */
package ATaleOfThreeCities;

import java.util.Arrays;

public class ATaleOfThreeCities {
    private double connect(int[] ax, int[] ay, int[] bx, int[] by, int[] cx, int[] cy) {
	double distance[] = { findClosest(ax, ay, bx, by), findClosest(ax, ay, cx, cy), findClosest(cx, cy, bx, by) };
	Arrays.sort(distance);
	return distance[0] + distance[1];
    }

    double findClosest(int x1[], int y1[], int x2[], int y2[]) {
	double miniDistance = Double.MAX_VALUE;
	for (int i = 0; i < x1.length; i++) {
	    for (int j = 0; j < x2.length; j++) {
		miniDistance = Math.min(miniDistance,
			Math.sqrt((x1[i] - x2[j]) * (x1[i] - x2[j]) + (y1[i] - y2[j]) * (y1[i] - y2[j])));
	    }
	}
	return miniDistance;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	long startTime = System.currentTimeMillis();
	int[] ax = new int[]{4,5,11,21,8,10,3,9,5,6};
	int[] ay = new int[]{12,8,9,12,2,3,5,7,10,13};
	int[] bx = new int[]{34,35,36,41,32,39,41,37,39,50};
	int[] by = new int[]{51,33,41,45,48,22,33,51,41,40};
	int[] cx = new int[]{86,75,78,81,89,77,83,88,99,77};
	int[] cy = new int[]{10,20,30,40,50,60,70,80,90,100};
	System.out.println(new ATaleOfThreeCities().connect(ax, ay, bx, by, cx, cy));
	long endTime = System.currentTimeMillis();
	System.out.println("running time:"+ (endTime - startTime) + "ms");
    }

}
