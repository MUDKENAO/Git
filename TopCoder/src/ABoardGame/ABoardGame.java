/**
 *
Problem Statement
    
Your friends Alice and Bob are playing a board game. They have asked you to help them to determine the winner. The game is played on a square board with 2N rows and 2N columns. The exact rules of the game itself are not important for this problem. Once the game is over, each cell of the board is either empty or contains a single piece that belongs to either Alice or Bob. You are given vector <string> board, where the j-th character in i-th element (0-based indices) describes the contents of the cell in row i, column j: '.' represents an empty cell, 'A' a cell with Alice's piece and 'B' a cell with Bob's piece.  The entire board is divided into N regions. Region 1 occupies the 4 central cells of the board. Each next region contains all cells that are horizontally, vertically or diagonally adjacent to cells of the immediately previous region and do not belong to any of the previous regions. For example, when N = 4, here is how the regions look:
44444444
43333334
43222234
43211234
43211234
43222234
43333334
44444444
The winner is determined as follows. Consider the lowest numbered region that contains a different number of Alice's and Bob's pieces. The player who has more pieces in this region is the winner. If all regions contain the same number of Alice's and Bob's pieces, the game ends in a draw.  Return "Alice" if Alice wins the given game, "Bob" if Bob wins and "Draw" if the game ends in a draw. Note that return values are case-sensitive.
Definition
    
Class:
ABoardGame
Method:
whoWins
Parameters:
vector <string>
Returns:
string
Method signature:
string whoWins(vector <string> board)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
256
Constraints
-
board will contain between 2 and 50 elements, inclusive.
-
The number of elements in board will be even.
-
Each element of board will contain the same number of characters as the number of elements in board.
-
Each character in board will be 'A', 'B' or '.'.
Examples
0)
    
{".....A",
 "......",
 "..A...",
 "...B..",
 "......",
 "......"}
Returns: "Alice"
Both Alice and Bob have 1 piece in region 1, so they are tied there. In region 2, they have no pieces at all, so a tie again. Finally, in region 3 Alice has 1 piece, while Bob has none. So Alice is the winner of this game.
1)
    
{"AAAA",
 "A.BA",
 "A..A",
 "AAAA"}
Returns: "Bob"
Even though Alice has 12 pieces and Bob just one, this one piece is enough for him to win.
2)
    
{"..",
 ".."}
Returns: "Draw"
The board can be entirely empty.
3)
    
{"BBB..BAB...B.B",
 ".AAAAAAAAAAAA.",
 "AA.AA.AB..A.AB",
 "..........B.AB",
 ".A..BBAB.A.BAB",
 ".AB.B.......A.",
 ".A..A.AB.A..AB",
 ".ABAA.BA...BA.",
 "BAAAB.....ABA.",
 ".A....B..A..B.",
 "B...B....B..A.",
 "BA.B..A.ABA.A.",
 "BAAAA.AAAAA.A.",
 "B.B.B.BB.B...."}
Returns: "Alice"
4)
    
{"..A..AAA..AA",
 "ABABB..AAAAA",
 "ABBBBBBBBBA.",
 "AABBBABABBAA",
 "...BABABABBA",
 "B.BA..A.BBA.",
 "AA.A..B.AB.B",
 "..BA.B.AABAA",
 "..ABABBBABA.",
 ".ABB.BBBBBAA",
 "ABAAA.AA.A.A",
 "A..AAA.AAA.A"}
Returns: "Bob"
5)
    
{"B..ABAABBB",
 "B.........",
 "A..A.AA..B",
 "A.BBBAA..A",
 "B.AAAAB...",
 "A..BBBBB.A",
 "B..ABAABBA",
 "A......B.B",
 "B......A.A",
 "BA.AABBB.A"}
Returns: "Draw"
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 
 @author Sun
 */
package ABoardGame;

import java.util.Arrays;

public class ABoardGame {
	
	public String whoWins(String[] board){
		int boardLenght = board.length;
		int nBucket = boardLenght/2;
		int[][] bucket = new int[2][nBucket];
		int[][] finalBucket = new int[2][nBucket];
		
		char BoardArray[][] = new char[boardLenght][boardLenght];
		for (int i = 0; i < boardLenght; i++){
			for (int j = 0; j < boardLenght; j ++){
				BoardArray[i][j] = board[i].charAt(j);
			}
		}
		
		finalBucket = SplitIntoBucket(BoardArray, bucket);
		
		
		for(int i = 0; i < finalBucket[0].length; i++ ){
			if(finalBucket[0][i] > finalBucket[1][i])
				return "Alice";
			else if (finalBucket[0][i] < finalBucket[1][i]) {
				return "Bob";
			}
		}
		return "Draw";
	}
	
	public int[][] SplitIntoBucket(char[][] BoardArray, int[][] bucket){
		
		for(int j = 0; j < BoardArray.length; j++){
			if( BoardArray[0][j] == 'A')   //first row
				bucket[0][BoardArray.length/2 -1] ++;
			else if (BoardArray[0][j] == 'B') {
				bucket[1][BoardArray.length/2 -1]++;
			}
			
			if( BoardArray[BoardArray.length - 1][j] == 'A')  //bottom row
				bucket[0][BoardArray.length/2 -1] ++;
			else if (BoardArray[BoardArray.length - 1][j] == 'B') {
				bucket[1][BoardArray.length/2 -1]++;
			}
			
			if( j!= 0 && j!= (BoardArray.length -1) && BoardArray[j][0] == 'A')  //left side
				bucket[0][BoardArray.length/2 -1] ++;
			else if (j!= 0 && j!= (BoardArray.length -1) && BoardArray[j][0] == 'B') {
				bucket[1][BoardArray.length/2 -1] ++;
			}
			
			if( j!= 0 && j!= (BoardArray.length -1) && BoardArray[j][BoardArray.length - 1] == 'A')  //right side
				bucket[0][BoardArray.length/2 -1] ++;
			else if (j!= 0 && j!= (BoardArray.length -1) && BoardArray[j][BoardArray.length - 1] == 'B') {
				bucket[1][BoardArray.length/2 -1] ++;
			}		
		}
		if (BoardArray.length == 2){
			return bucket;
		}
		char[][] tempArray = new char[(BoardArray.length/2 - 1)*2][];
		for (int i =0; i < tempArray.length; i++){
			tempArray[i] = Arrays.copyOfRange(BoardArray[i + 1], 1, tempArray.length+1);
		}
		
		bucket = SplitIntoBucket(tempArray, bucket);
		return bucket;
		
	}
	public static void main(String[] args) {
		String board[] = {"..A..AAA..AA", "ABABB..AAAAA", "ABBBBBBBBBA.", "AABBBABABBAA", "...BABABABBA", "B.BA..A.BBA.", "AA.A..B.AB.B", "..BA.B.AABAA", "..ABABBBABA.", ".ABB.BBBBBAA", "ABAAA.AA.A.A", "A..AAA.AAA.A"};
		System.out.println(
				new ABoardGame().whoWins(board));

	}

}
