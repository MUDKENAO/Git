/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=7901
*/

package AverageProblem;

import java.util.ArrayList;

public class AverageProblem {
	public int numberOfParticipants(String[] marks) {
		ArrayList<Integer> oneThousandthes = new ArrayList<Integer>();
		for (String oneMarks : marks) {
			String fields[] = oneMarks.split(" ");
			for (String field : fields) {
				oneThousandthes.add(Integer.parseInt(field
						.replaceAll("\\.", "")));
			}
		}
		for (int participant = 1;; participant++) {
			boolean valid = true;
			for (int oneThousandth : oneThousandthes) {
				if (divideToCeil(participant * oneThousandth, 1000) * 1000
						/ participant != oneThousandth) {
					valid = false;
					break;
				}
			}
			if (valid) {
				return participant;
			}
		}
	}

	int divideToCeil(int a, int b) {
		return a / b + (a % b == 0 ? 0 : 1);
	}
	
	public static void main(String args[]) {
		String marks[] = {"0.500 0.250", "0.125"};
		System.out.println(new AverageProblem().numberOfParticipants(marks));;
	}
}