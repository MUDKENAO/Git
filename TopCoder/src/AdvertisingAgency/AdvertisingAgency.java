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
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] request = {1,2,1,1};
		
		System.out.print(new AdvertisingAgency().numberofRejections(request));

	}

}
