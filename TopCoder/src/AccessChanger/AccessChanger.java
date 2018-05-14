/*
 * Problem Statement:
 * https://community.topcoder.com/stat?c=problem_statement&pm=4830&rd=8002
*/
package AccessChanger;

import java.util.Arrays;

public class AccessChanger {

    public String[] convert(String[] program) {
        String converted[] = new String[program.length];
        for (int i = 0; i < converted.length; i++) {
            int commentPos = program[i].indexOf("//");
            if (commentPos >= 0) {
                converted[i] = program[i].substring(0, commentPos).replaceAll("->", ".") + program[i].substring(commentPos);
            } else {
                converted[i] = program[i].replaceAll("->", ".");
            }
        }
        return converted;
    }
    
    public static void main(String args[]) {
    	
    	String program[] = {"---> // the arrow --->",
    			 "---",
    	 "> // the parted arrow"};
    	System.out.println(Arrays.toString(new AccessChanger().convert(program)));
    }
    
}
