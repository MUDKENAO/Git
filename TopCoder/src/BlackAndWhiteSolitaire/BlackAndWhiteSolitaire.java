package BlackAndWhiteSolitaire;

public class BlackAndWhiteSolitaire {
	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=12589
	 
	* @author Z.SUN
	* @version 2018年8月15日 下午2:39:18
	*/
	public int minimumTurns(String cardFront) {
		return Math.min(countTurn(cardFront, 'B'), countTurn(cardFront, 'W'));
	}

	int countTurn(String cardFront, char firstCard) {
		int turnNum = 0;
		for (int i = 0; i < cardFront.length(); i++) {
			turnNum += ((i % 2 == 0) == (cardFront.charAt(i) == firstCard)) ? 1
					: 0;
		}
		return turnNum;
	}
	
	public static void main(String args[]){
	
		String cardFront = "BBWBWWBWBWWBBBWBWBWBBWBBW";
		System.out.println(new BlackAndWhiteSolitaire().minimumTurns(cardFront));
	}
	
}
