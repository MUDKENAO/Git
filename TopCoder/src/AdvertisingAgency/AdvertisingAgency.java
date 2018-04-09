/**
 * 
 */
package AdvertisingAgency;

import java.util.HashMap;


/**
 * @author Zhenglong Sun
 *
 */
public class AdvertisingAgency {
	
	public int numberofRejections(int[] request) {
		
		int countLoop = 0;
		int reject = 0;
		
		HashMap<Integer, Boolean> hashBillBoard = new HashMap<Integer, Boolean>();
		
		
		while(countLoop < request.length) {
			
			if(hashBillBoard.containsKey(request[countLoop]))
				reject ++;
			else
				hashBillBoard.put(request[countLoop], true);
			
			countLoop ++;
		}
		
		return reject;
		
//		int countLoop = 0;
//		int reject = 0;
//		int[] listBillBoard = new int[100];
//		
//		listBoardInitial(listBillBoard);
//		
//		while(countLoop < request.length) {
//			if (isOccupied(listBillBoard, request[countLoop])) {
//				reject ++;
//			}
//			countLoop++;
//		}
//		
//		return reject;
//	}
//	
//	private boolean isOccupied(int[] listBillBoard, int billBoard) {
//		boolean result = false;
//		
//		if(listBillBoard[billBoard-1] == 0)
//		{
//			listBillBoard[billBoard-1] = 1;
//		}else
//			result = true;
//		
//		return result;
//	}
//	
//	private void listBoardInitial(int[] listBillBoard) {
//		 
//		for(int i =0; i< listBillBoard.length; i++) {
//			listBillBoard[i] = 0;
//		}
//		
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] request = {1,2,1,1};
		
		System.out.print(new AdvertisingAgency().numberofRejections(request));

	}

}
