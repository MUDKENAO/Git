package BlockTower;

public class BlockTower {
	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=12200
	 
	* @author Z.SUN
	* @version 2018年8月16日 上午8:29:58
	*/
	public int getTallest(int[] blockHeights) {
		int maxTotalHeight = 0;
		int totalHeightEven = 0;
		for (int i = 0; i < blockHeights.length; i++) {
			if (blockHeights[i] % 2 == 0) {
				totalHeightEven += blockHeights[i];
				maxTotalHeight = Math.max(maxTotalHeight, totalHeightEven);
			} else {
				int totalHeightOdd = totalHeightEven + blockHeights[i];
				for (int j = i + 1; j < blockHeights.length; j++) {
					if (blockHeights[j] % 2 != 0) {
						totalHeightOdd += blockHeights[j];
					}
				}
				maxTotalHeight = Math.max(maxTotalHeight, totalHeightOdd);
			}
		}
		return maxTotalHeight;
	}
	
	public static void main(String args[]){
	
		int[] blockHeights = {44,3,44,3,44,47,2,47,2,47,2};
		System.out.println(new BlockTower().getTallest(blockHeights));
	}
	
}
