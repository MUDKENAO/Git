/*
Problem Statement
    	In genetics, most large animals have two copies of every gene - one from each parent. In the simplest genetic model, each of the genes takes on one of two forms, usually represented by an uppercase and lowercase letter of the same value ('A' and 'a', for example). The pair of genes typically contributes to the external qualities of the animal in one of two ways. If both genes are uppercase, they contribute in one way, while if both genes are lowercase, they contribute in another way. If one gene is uppercase and the other is lowercase, then the pair acts like either a pair of uppercase genes or a pair of lowercase genes depending on whether the gene represented by the uppercase letter is dominant or recessive, respectively. 



In this problem, you will be given two Strings, g1 and g2, each representing the genes from one parent. Hence, two characters from g1 and g2 with the same index make up a single gene. You will also be given a String, dom, telling you whether an uppercase gene is dominant or recessive, represented by 'D' and 'R', respectively (characters of dom correspond to characters of g1 and g2 with the same index). You are to return a String representing the external qualities of each pair of genes. If a pair of genes has the quality of two uppercase letters, the return should have an uppercase letter, and if not the return should have a lowercase letter. In either case, each letter should have the same value as the corresponding letters of g1 and g2.
 
Definition
    	
Class:	Genetics
Method:	getOffspring
Parameters:	String, String, String
Returns:	String
Method signature:	String getOffspring(String g1, String g2, String dom)
(be sure your method is public)
    
 
Constraints
-	g1 and g2 will contain only letters ('a'-'z' and 'A'-'Z').
-	dom will contain only 'D's and 'R's.
-	dom, g1 and g2 will each contain the same number of characters.
-	dom, g1 and g2 will each contain between 1 and 50 characters, inclusive.
-	Corresponding letters in g1 and g2 will have the same value, though potentially different cases.
*/
package Genetics;

public class Genetics {
	public String getOffspring(String g1, String g2, String dom){
		char[] ret = g1.toCharArray();
		
		for (int i = 0; i < g1.length(); i ++){
			if (g1.charAt(i) != g2.charAt(i)){   // if the genes in a pair equals to each other, we keep them
				if (dom.charAt(i) == 'D'){	     // if not, the gene is selected according to the char in String dom
					ret[i] = Character.toUpperCase(ret[i]);
				}else{
					ret[i] = Character.toLowerCase(ret[i]);
				}
			}
		}
		return new String(ret);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String g1 = "MGskgzTFQoclnDjZu";
		String g2 = "mgSKGzTFQoClnDJzU";
		String dom = "DDDDDRDDDDRDDDDDD";
		System.out.println(
				new Genetics().getOffspring(g1, g2, dom));
	}

}
