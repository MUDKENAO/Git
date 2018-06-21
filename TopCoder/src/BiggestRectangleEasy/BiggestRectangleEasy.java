	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=6677
	 
	* @author Z.SUN
	* @version 2018年6月21日 上午10:42:32
	*/
package BiggestRectangleEasy;

public class BiggestRectangleEasy {
	
	public int findArea(int N) {
		int semiPerimeter = N / 2;
		int width = semiPerimeter / 2;
		int height = semiPerimeter - width;
		return height * width;
	}

	public static void main(String args[]){
	
		int N = 7254;
		System.out.println(new BiggestRectangleEasy().findArea(N));
	}

}
