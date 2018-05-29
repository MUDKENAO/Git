/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=3970
*/
package AutoLoan;

import BinaryCode.BinaryCode;

public class AutoLoan {
	public double interestRate(double price, double monthlyPayment, int loanTerm) {
		final double ERROR = 1e-12;
		double lower = 0;
		double upper = 100;
		double middle = 0;
		while (true) {
			middle = (lower + upper) / 2;
			if (upper - lower < ERROR) {
				break;
			}
			
			// Binary search
			double balance = getBalance(price, monthlyPayment, loanTerm,
					middle / 100);
			if (balance > 0) {
				upper = middle;
			} else {
				lower = middle;
			}
		}
		return middle * 12;
	}

	double getBalance(double price, double monthlyPayment, int loanTerm,
			double monthlyRate) {
		double balance = price;
		for (int i = 0; i < loanTerm; i++) {
			balance += balance * monthlyRate - monthlyPayment;
		}
		return balance;
	}
	
	public static void main(String args[]) {
		double price  = 15000;
		double monthlyPayment = 364;
		int loanTerm = 48;
		
		System.out.println(new AutoLoan().interestRate(price, monthlyPayment, loanTerm));
	}
}