/*Problem Statement
https://community.topcoder.com/stat?c=problem_statement&pm=12950
*/

package AlienAndPassword;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlienAndPassword {
	public int getNumber(String S) {
		return IntStream.range(0, S.length()).mapToObj(i -> S.substring(0, i) + S.substring(i + 1))
				.collect(Collectors.toSet()).size();
	}
	
	public static void main(String args[]) {
		String S1 = "AGAAGAHHHHFTQLLAPUURQQRRRUFJJSBSZVJZZZ";
		String S2 = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";
		
		System.out.println(new AlienAndPassword().getNumber(S1));
		System.out.println(new AlienAndPassword().getNumber(S2));
	}
}
