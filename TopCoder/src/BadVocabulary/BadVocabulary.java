/*Problem statement
https://community.topcoder.com/stat?c=problem_statement&pm=11190
*/
package BadVocabulary;

public class BadVocabulary {
	public int count(String badPrefix, String badSuffix,
			String badSubstring, String[] vocabulary) {
		int badNum = 0;
		for (String word : vocabulary) {
			if (word.startsWith(badPrefix)
					|| word.endsWith(badSuffix)
					|| (word.length() > 2 && word
							.substring(1, word.length() - 1)
							.contains(badSubstring))) {
				badNum++;
			}
		}
		return badNum;
	}

	public static void main(String[] args) {
		String badPrefix = "bar";
		String badSuffix = "else";
		String badSubstring = "foo";
		String vocabulary[] = {"foofoofoo", "foobar", "elsewhere"};
		
		System.out.println(new BadVocabulary().count(badPrefix, badSuffix, badSubstring, vocabulary));

	}

}
