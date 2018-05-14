/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=6036
*/
package AccountBalance;

public class AccountBalance {
	public int processTransactions(int startingBalance, String[] transactions) {
		int balance = startingBalance;
		for (String transaction : transactions) {
			String fields[] = transaction.split(" ");
			int amount = Integer.parseInt(fields[1]);
			if (fields[0].equals("C")) {
				balance += amount;
			} else {
				balance -= amount;
			}
		}
		return balance;
	}
	
	public static void main(String args[]) {
		int start = 53874;
		String transactions[] = {"D 1234", "C 987", "D 2345", "C 654", "D 6789", "D 34567"};
		
		System.out.print(new AccountBalance().processTransactions(start, transactions));
	}
}