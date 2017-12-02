/*Problem Statement
If you compile a Java program and open the .class file in a text editor, you will find that the first four bytes spell "CAFEBABE"
in hexadecimal. Using hexadecimal numbers to spell words is called Hexspeak. Hexadecimal numbers are integers written in base 16. 
The letters 'A' through 'F' represent the digits with values 10 through 15. For example, the integer 202 written in hexadecimal 
is "CA". This is because 202 = 12*16 + 10, and the digits 12 and 10 are written as 'C' and 'A', respectively. 

In this problem we will use eight different letters: in addition to the letters 'A' through 'F' we will also interpret the digit 0
as the letter 'O' and the digit 1 as the letter 'I'. Hence, any word that only consists of the letters ABCDEFIO can be interpreted
as a hexadecimal number. Such words are called valid hexspeak words. Fox Ciel has a long ciphertext containing a positive integer.
Convert this number to hexadecimal. If you get the representation of a valid hexspeak word, return that word. Otherwise, return 
the string "Error!" (quotes for clarity). In other words, you should return "Error!" if the hexadecimal representation of 
ciphertext contains some occurrence of a digit between 2 and 9, inclusive.
 
Definition
    	
Class:	Hexspeak
Method:	decode
Parameters:	long
Returns:	String
Method signature:	String decode(long ciphertext)
(be sure your method is public)
     
Notes
-	The correct hexadecimal representation of ciphertext does not contain any leading zeros.
-	The return value is case-sensitive.
 
Constraints
-	ciphertext will be between 1 and 1,000,000,000,000,000,000, inclusive.
 */

package Hexspeak;

import java.util.*;

public class Hexspeak {
	public String decode(long ciphertext){
		long lowBit;
		ArrayList<Character> ret = new ArrayList<Character>();
		// split the ciphertext into single character and do simple comparison
		while (ciphertext > 0){
			lowBit = ciphertext % 16;
			if ( 2 <= lowBit && lowBit <= 9){
				return "Error!";
			}
			if (Bit2String(lowBit).equals("X"))
			{
				return "Error!";
			}
			else{
				ret.add(Bit2String(lowBit).charAt(0));
			}
			ciphertext /= 16;
		}
		return Reverse2String(ret);
	}
	
	// replace 0,1 with OX and check the boundary before change every bit to hex
	public String Bit2String(long bit){

		if (bit == 0){
			return "O";
		}
		else if( bit == 1){			
			return "I";
		}
		else if(bit >= 2 && bit <= 9){
			return "X";
		}
		else if( bit >= 16){
			return "X";
		}
		return Long.toHexString(bit).toUpperCase();
	}
	
	// reverse the Arraylist to the right order and transform the Arraylist to a string
	public String Reverse2String(ArrayList<Character> ret){
		char temp;
		for (int i = 0; i <= ((ret.size()-1)/2); i++){
			temp = ret.get(i);
			ret.set(i, ret.get(ret.size()-1-i));
			ret.set(ret.size()-1-i, temp);
		}
		String retString = "";
		for (Character s : ret){
			retString += s;
		}
		return retString;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long ciphertext = 999994830345994239L;
		System.out.println(
				new Hexspeak().decode(ciphertext));
	}

}
