/**
 *
 * Problem Statement
 * https://arena.topcoder.com/index.html#/u/practiceCode/1626/4170/4512/2/1626
 * 
 * @author Sun
 */

package Abacus;

import java.util.Arrays;

public class Abacus {

	public String[] add(String[] original, int val) {
		int totalValue = readAbacus(original);
		
		return generateAbacus(totalValue + val);

	}
	
	private int reaDigit(String thread) {
		int number = 0;
		int loopCount = 0;
		int decimal = 9;
		
		for (; loopCount < thread.length(); loopCount++){
			if (thread.charAt(loopCount) == 'o')
				number ++; 
			else
				break;
		}
		return decimal-number;
	} 
	
	
	private int readAbacus(String[] original) {
		int totalValue = 0;
		int currentValue = 0;
		int k = 5;
		
		for(int i = 0; i < original.length; i++) {
			currentValue = reaDigit(original[i]);
			totalValue +=  pow(10, (k - i)) * currentValue ;
		}
		
		return totalValue;
	} 
	
	private String generateThread(int digit) {
		String result = "";
		double prefix  = 9 - digit;
		
		for(int i=0; i< prefix; i++)
			result += "o";
		
		result += "---";
		
		for(int i=0; i< digit; i++)
			result += "o";
		
		return result;
	} 
	
	private int pow(int base, int power) {
		int result = 1;
		for(int i = 0; i < power; i++)
			result *= base;
		return result;
	}
	
	private String[] generateAbacus(int value) {
		int rest = value;
		int currentDigit = 0;
		int numberAbacus = 6;
		String[] abacus = new String[numberAbacus];
		
		for (int i = 1; rest != 0; i++) {
			currentDigit = rest%10;
			abacus[numberAbacus - i] = generateThread(currentDigit);
			rest  = rest/10;
		}
		return abacus;
	}

	
	
	public static void main(String[] args) {
		
		String original[] = {"o---oooooooo",
				 "---ooooooooo",
				 "---ooooooooo",
				 "---ooooooooo",
				 "---ooooooooo",
				 "---ooooooooo"
				};
		
		int val = 1;
		
		System.out.println(Arrays.toString(original) + "+" + val +"=");
		System.out.println(Arrays.toString(new Abacus().add(original, val)));
	}
}