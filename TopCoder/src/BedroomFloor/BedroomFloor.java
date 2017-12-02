/* TopCoder problem "BedroomFloor" used in SRM 442 (Division I Level Two)
 * 
 * Problem Statement url: http://topcoder.bgcoder.com/print.php?id=1038
 * 
 * Medium Problem 550 Points
 * 
 * Type: Medium
 * 
 * Solution: Firstly, we calculate the number of complete blocks (5 * 1x5 sticks) included in the red square. Then we compute
 * the types and number of incomplete sticks are needed besides those complete blocks. (The direction of sticks is important!). 
 * Finally, we consider the situations that different types of sticks can be combined into complete 1x5 sticks which can minimize
 * the amount of sticks we need to buy.
 * 
 * Submission was successful for 549.34 points.
 */

package BedroomFloor;

import static java.lang.Math.*;

public class BedroomFloor {
	
	// the array of number of different types of sticks (1x1, 1x2, 1x3, 1x4, 1x5)	
	long type[] = new long[6];
	
	public long numberOfSticks(int x1, int y1, int x2, int y2) {
		
		int ax1, ay1, ax2, ay2;
		long ans = 0;
		
		// Compute how many complete blocks (5 * 1x5 sticks) are included in the red square
		ax1 = (x1 + 4) /5 *5;
		ay1 = (y1 + 4) /5 *5;
		ax2 = x2 /5 *5;
		ay2 = y2 /5 *5;

		ans = (long)(ax2 - ax1)*(ay2 - ay1)/5;

		//Compute the types and numbers of sticks are needed in the four square corners.
		Corner(ax1 - x1, ay1 - y1, (ay1/5 + ax1/5 + 1) %2);//top left
		Corner(x2 - ax2, ay1 - y1, (ay1/5 + ax2/5) %2); //top right
		Corner(ax1 - x1, y2 - ay2, (ay2/5 + ax1/5) %2);//bottom left
		Corner(x2 - ax2, y2 - ay2,(ay2/5 + ax2/5 +1) %2);//bottom right

		//Compute the types and numbers of sticks are needed in the sides.
		Side(ax1 - x1,(ay2 - ay1)/5, (ay1/5 + ax1/5) %2);//left
		Side(x2 - ax2,(ay2 - ay1)/5, (ay1/5 + ax2/5 +1 )%2);//right
		Side(ay1 - y1,(ax2 - ax1)/5, (ay1/5 + ax1/5 + 1)%2);//top
		Side(y2 - ay2,(ax2 - ax1)/5,(ay2/5 + ax1/5) %2);//bottom
		
		// Combine all the sticks together to calculate the final number of sticks we need to buy
		
		// number of the complete 1x5 sticks
		ans += type[5];	
		
		// combine 1x1 and 1x4 into 1x5
		long t = min(type[1],type[4]);
		type[1] -= t;
		type[4] -= t;
		ans += t;
		ans += type[4];
		type[4] = 0;

		// combine 1x2 and 1x3 into 1x5
		t = min(type[2],type[3]);
		type[2] -= t;
		type[3] -= t;
		ans += t;

		// combine two 1x2 and 1x3 into 1x5
		t = min(type[1]/2,type[3]);
		type[1] -= t*2;
		type[3] -= t;
		ans += t;

		// If 1x3 are still left, that means there is no 1x1 left, since 1x3 can not be combine into 1x5 anymore, we have to buy 		1x3 separately.
		if(type[3] > 0)
			type[1] = 0;
		ans += type[3];
		type[3] = 0;

		// combine two 1x2 and 1x1 into 1x5
		t = min(type[1],type[2]/2);
		type[1] -= t;
		type[2] -= t*2;
		ans += t;

		// combine three 1x1 and 1x2 into 1x5
		t = min(type[1]/3,type[2]);
		type[1] -= t*3;
		type[2] -= t;
		ans += t;

		// If 1x2 are still left, that means there is no 1x1 or 1x3 left, since 1x2 can not be combine into 1x5 anymore, unless 		two 1x2 combine into 1x4, we have to buy (type[2] + 1)/2  of 1x2  sticks separately.
		if(type[2] > 0)
		{
			ans += (type[2]+1)/2;
			type[2] = 0;
			type[1] = 0;
		}		
		
		// If there is still 1x1 left, try to combine 5 1x1 into a 1x5, we have to buy extra 1x5 sticks if there are 1x1 left less 		than 5.
		ans += (type[1]+4)/5;
		type[1] = 0;
		return ans;
	}
	
	/* This function is to compute the types and numbers of sticks are needed in the four square corners. 
	*  3rd parameter determines the direction of sticks in the corner
	*  Since the direction of sticks is always the same with the one from the next block in diagonal direction. So we can 	determine the direction of sticks by the position of blocks it belongs to. 
	*  For example, the position of block in second row, third column is (2, 1), (2 + 1 + 1(offset))%2 = 0 , this means the direction of sticks in this block is vertical (if the result is 1, then direction is horizontal). if the red square has a top left corner 	in the diagonal direction of block (2,1), the direction of stick in the corner is determined as vertical.
	*/  
	private void Corner(int dx, int dy, long direction) {
		if(direction == 0)
		{
			type[dy] += dx;
		}
		else
		{
			type[dx] += dy;
		}
	}
	
	/*This function is to compute the types and numbers of sticks are needed in the sides
	 * The second parameter is used to calculate the number of two types sticks in the side. Variable num1 determines one type, 		num2 determines another.
	 */
	private void Side(int  dx, long num, long direction) {
		long num1 = ((num + 1)/2);
		long num2 = num/2;

		if(direction == 0)
		{
			type[5] += dx * num1;
			type[dx] += num2 * 5;
		}else{
			type[5] += dx * num2;
			type[dx] += num1 * 5;
		}		
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x1 = 8;
		int y1 = 5;
		int x2 = 20;
		int y2 = 16;
		System.out.println(
				new BedroomFloor().numberOfSticks(x1, y1, x2, y2));
	}
}