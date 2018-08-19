package BoundingBox;

import java.util.Arrays;

public class BoundingBox {
	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=12990
	 
	* @author Z.SUN
	* @version 2018年8月19日 上午9:46:03
	*/
	public int smallestArea(int[] X, int[] Y) {
		return span(X) * span(Y);
	}

	int span(int[] a) {
		return Arrays.stream(a).max().getAsInt() - Arrays.stream(a).min().getAsInt();
	}
	
	public static void main(String args[]){
	
		int[] X = {9,-88,-40,98,-55,41,-38};
		int[] Y = {-65,56,-67,7,-58,33,68};
		System.out.println(new BoundingBox().smallestArea(X, Y));
	}
}
