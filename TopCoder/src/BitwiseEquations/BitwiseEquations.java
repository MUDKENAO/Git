package BitwiseEquations;

public class BitwiseEquations {
	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=9921
	 
	* @author Z.SUN
	* @version 2018年8月14日 上午10:57:09
	*/
	public long kthPlusOrSolution(int x, int k) {
		String binaryX = Integer.toBinaryString(x);
		String binaryK = Integer.toBinaryString(k);
		String binaryY = "";
		while (!binaryK.equals("")) {
			if (binaryX.endsWith("1")) {
				binaryY = "0" + binaryY;
			} else {
				binaryY = binaryK.charAt(binaryK.length() - 1) + binaryY;
				binaryK = binaryK.substring(0, binaryK.length() - 1);
			}
			if (!binaryX.equals("")) {
				binaryX = binaryX.substring(0, binaryX.length() - 1);
			}
		}
		return Long.parseLong(binaryY, 2);
	}
	
	public static void main(String args[]){
	
		int x = 10;
		int k = 3;
		System.out.println(new BitwiseEquations().kthPlusOrSolution(x, k));
	}
}
