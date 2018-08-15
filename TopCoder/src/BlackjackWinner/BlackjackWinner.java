package BlackjackWinner;

public class BlackjackWinner {
	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=4500
	 
	* @author Z.SUN
	* @version 2018年8月15日 下午3:14:17
	*/
	public int winnings(int bet, int dealer, int dealerBlackjack, int player,
			int blackjack) {
		if (blackjack > dealerBlackjack
				|| (player <= 21 && (dealer > 21 || player > dealer))) {
			if (blackjack == 1) {
				return bet / 2 * 3;
			} else {
				return bet;
			}
		} else if (player <= 21 && player == dealer
				&& dealerBlackjack == blackjack) {
			return 0;
		} else {
			return -bet;
		}
	}
	
	public static void main(String args[]){
	
		int bet = 78;
		int dealer = 22;
		int dealerBlackjack = 0;
		int player = 23;
		int blackjack = 0;
		System.out.println(new BlackjackWinner().winnings(bet, dealer, dealerBlackjack, player, blackjack));
	}
	
}
