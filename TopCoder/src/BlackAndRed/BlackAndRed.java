package BlackAndRed;

public class BlackAndRed {
	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=3457
	 
	* @author Z.SUN
	* @version 2018年8月14日 上午10:19:59
	*/
	public int cut(String deck) {
		for (int i = 0;; i++) {
			String cutted = deck.substring(i) + deck.substring(0, i);
			if (isWin(cutted)) {
				return i;
			}
		}
	}

	boolean isWin(String deck) {
		int red = 0;
		int black = 0;
		for (int i = 0; i < deck.length(); i++) {
			if (deck.charAt(i) == 'R') {
				red++;
			} else {
				black++;
			}
			if (red > black) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]){
	
		String deck = "RBRBBRRRRBBBRBBRRBRBBRRRBRBBBRBRBRBRBRRB";
		System.out.println(new BlackAndRed().cut(deck));
	}

}
