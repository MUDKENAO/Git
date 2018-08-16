package BoardSplitting;

public class BoardSplitting {
	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=11951
	 
	* @author Z.SUN
	* @version 2018年8月16日 上午9:31:56
	*/
	public int minimumCuts(int desiredLength, int desiredCount, int actualLength) {
		int cutNum = 0;
		int lengthNeeded = desiredLength;
		int lengthRemaining = actualLength;
		while (desiredCount != 0) {
			if (lengthNeeded >= lengthRemaining) {
				lengthNeeded -= lengthRemaining;
				lengthRemaining = actualLength;
			} else {
				lengthRemaining -= lengthNeeded;
				lengthNeeded = 0;
				cutNum++;
			}
			if (lengthNeeded == 0) {
				lengthNeeded = desiredLength;
				desiredCount--;
			}
		}
		return cutNum;
	}
	
	public static void main(String args[]){
	
		int desiredLength = 5;
		int desiredCount = 4;
		int actualLength = 4;
		System.out.println(new BoardSplitting().minimumCuts(desiredLength, desiredCount, actualLength));
	}
	
}
