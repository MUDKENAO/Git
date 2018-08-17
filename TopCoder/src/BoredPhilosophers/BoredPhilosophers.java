package BoredPhilosophers;

import java.util.Arrays;

public class BoredPhilosophers {
	/**
	Problem statement
	https://community.topcoder.com/stat?c=problem_statement&pm=10456
	 
	* @author Z.SUN
	* @version 2018年8月17日 下午11:12:28
	*/
	public int[] simulate(String[] text, int N) {
		String whole = "";
		for (String oneText : text) {
			whole += oneText;
		}
		String[] words = whole.split(" ");
		int[] result = new int[N];
		for (int consecutive = 1; consecutive <= N; consecutive++) {
			for (int i = 0; i + consecutive <= words.length; i++) {
				boolean duplicate = false;
				for (int j = 0; j < i; j++) {
					if (isSameSequence(words, i, j, consecutive)) {
						duplicate = true;
						break;
					}
				}
				if (!duplicate) {
					result[consecutive - 1]++;
				}
			}
		}
		return result;
	}

	boolean isSameSequence(String[] words, int start1, int start2,
			int consecutive) {
		for (int i = 0; i < consecutive; i++) {
			if (!words[start1 + i].equals(words[start2 + i])) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]){
	
		String[] text = {"a a a a a a a b a a b a a a b b a b a a a b a b"};
		int N = 6;
		System.out.println(Arrays.toString(new BoredPhilosophers().simulate(text, N)));
	}
	
}
