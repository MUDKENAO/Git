package BoxLoader;

public class BoxLoader {
	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=2403
	 
	* @author Z.SUN
	* @version 2018年8月19日 上午9:49:17
	*/
	public int mostItems(int boxX, int boxY, int boxZ, int itemX, int itemY,
			int itemZ) {
		int orientations[][] = { { itemX, itemY, itemZ },
				{ itemX, itemZ, itemY }, { itemY, itemX, itemZ },
				{ itemY, itemZ, itemX }, { itemZ, itemX, itemY },
				{ itemZ, itemY, itemX } };
		int maxItemNum = -1;
		for (int orientation[] : orientations) {
			int itemNum = (boxX / orientation[0]) * (boxY / orientation[1])
					* (boxZ / orientation[2]);
			maxItemNum = Math.max(maxItemNum, itemNum);
		}
		return maxItemNum;
	}
	
	public static void main(String args[]){
	
		int boxX = 6;
		int boxY = 5;
		int boxZ = 4;
		int itemX = 3;
		int itemY = 2;
		int itemZ = 1;
		System.out.println(new BoxLoader().mostItems(boxX, boxY, boxZ, itemX, itemY, itemZ));
	}
	
}
