/**
 * Problem statement:
 * see http://community.topcoder.com/stat?c=problem_statement&pm=11146
 * 
 * The sequence given has at leash seq.size()/2 elements which are the same as the sequence we should return. Because the sequence we should return must be the one of the following form: one odd number, followed by one even number then, odd, even. etc.  ... Or even, odd, even, odd..etc....or identical to the given sequence.
 * 
 * So we can just rebuild the whole sequence with either the difference between seq[2] and seq[0] or the one between seq[3] and seq[1].
 * */

package AfraidOfEven;

import java.util.Arrays;

public class AfraidOfEven {

	public int[] restoreProgression(int[] seq) {
		if (isValid(seq)) {

			return seq;
		}

		int[] diffs = { seq[2] - seq[0], seq[3] - seq[1] };

		int[] dummyEven = createDummy(diffs[0], seq, "even");
		int[] dummyOdd = createDummy(diffs[1], seq, "odd");

		if ((dummyEven != null) && check(dummyEven, seq, "even")) {
			int[] restoredDummy = restore(dummyEven, diffs[0], "even");

			if (isValid(restoredDummy))
				return restoredDummy;
		}

		if ((dummyOdd != null) && check(dummyOdd, seq, "odd")) {

			int[] restoredDummy = restore(dummyOdd, diffs[1], "odd");

			if (isValid(restoredDummy))
				return restoredDummy;
		}
		return null;
	}

	private boolean isValid(int[] listCandidate) {

		int diff = listCandidate[1] - listCandidate[0];

		for (int i = 2; i < listCandidate.length; i++) {
			if (listCandidate[i] - listCandidate[i - 1] != diff)
				return false;
		}
		return true;
	}

	private int[] createDummy(int diff, int[] seq, String mark) {

		int[] dummy = new int[seq.length];

		if (mark == "even") {
			dummy[0] = seq[0];
			dummy[2] = seq[2];
			for (int i = 3; (i - 1) * 2 < seq.length; i++) {

				dummy[(i - 1) * 2] = dummy[(i - 2) * 2] + diff;
			}

		} else {
			dummy[1] = seq[1];
			dummy[3] = seq[3];
			for (int i = 3; ((i - 1) * 2 + 1) < seq.length; i++) {

				dummy[(i - 1) * 2 + 1] = dummy[(i - 2) * 2 + 1] + diff;
			}

		}

		if (check(dummy, seq, mark))
			return dummy;

		return null;
	}

	private boolean check(int[] dummy, int[] seq, String mark) {
		if (mark == "even") {
			for (int i = 0; i * 2 < seq.length; i++) {
				if (dummy[i * 2] != seq[i * 2])
					return false;
			}
			return true;

		}
		if (mark == "odd") {
			for (int i = 0; (i * 2 + 1) < seq.length; i++) {
				if (dummy[i * 2 + 1] != seq[i * 2 + 1])
					return false;
			}
			return true;

		}
		return false;
	}

	private int[] restore(int[] dummy, int diff, String mark) {

		if (mark == "even") {
			for (int i = 0; (i * 2 + 1) <= dummy.length; i++) {
				dummy[i * 2 + 1] = dummy[i * 2] + diff / 2;
			}

			return dummy;
		}
		if (mark == "odd") {
			dummy[0] = dummy[1] - diff / 2;
			for (int i = 1; (i * 2 + 1) <= dummy.length; i++) {
				dummy[i * 2] = dummy[i * 2 - 1] + diff / 2;
			}

			return dummy;
		}

		return null;

	}

	public static void main(String[] args) {

		int[] seq = {7, 47, 5, 113, 73, 179, 53};
		System.out.println(Arrays.toString(new AfraidOfEven().restoreProgression(seq)));

	}

}
