	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=608
	 
	* @author Z.SUN
	* @version 2018年6月21日 上午10:33:20
	*/

package Billboard;

import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Billboard {
	
	public String[] enlarge(String message, String[] letters) {
		String result[] = new String[5];
		for (int i = 0; i < 5; i++) {
			result[i] = "";
		}
		for (int i = 0; i < message.length(); i++) {
			if (i != 0) {
				for (int j = 0; j < 5; j++) {
					result[j] += ".";
				}
			}
			for (int j = 0; j < letters.length; j++) {
				if (message.charAt(i) == letters[j].charAt(0)) {
					for (int k = 0; k < 5; k++) {
						result[k] += letters[j].substring(k * 6 + 2, k * 6 + 7);
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String args[]){
		String message = "RANDOMNESS";
		String letters[] = {"S:##.##-#####-#.#.#-#.#.#-####."
				,"N:#####-#####-#####-#####-#####"
				,"R:#####-#####-##.##-#####-#####"
				,"A:.....-.....-.....-.....-....."
				,"D:#.#.#-.#.#.-#.#.#-.#.#.-#.#.#"
				,"O:#####-#...#-#.#.#-#...#-#####"
				,"E:#....-.#...-..#..-...#.-....#"
				,"M:#....-.....-.....-.....-....."
				,"X:#...#-.#.#.-..#..-.#.#.-#...#"};
		System.out.println(Arrays.toString(new Billboard().enlarge(message, letters)));
	}

}
